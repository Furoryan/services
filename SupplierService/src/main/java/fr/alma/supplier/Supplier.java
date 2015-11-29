package fr.alma.supplier;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fr.alma.domaine.valueobject.IArticle;
import fr.alma.domaine.valueobject.impl.Article;
import fr.alma.domaine.factories.ArticleFactory;
import fr.alma.implementation.domaine.factories.SimpleArticleFactory;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class Supplier {

	ArticleFactory articleFactory;
	private Map<String, Article> articleList;
	private List<Transaction> transactions;

	public Supplier(){
		// construire la Factory des articles
		this.articleFactory = new SimpleArticleFactory();
		// construire la liste des articles
		this.articleList = new HashMap<String, Article>();
		// construire la liste des transactions
		this.transactions = new LinkedList<Transaction>();
		this.loadData();
	}

	/**
	* Charge les données. Emet une exception en cas de problème.
	*/
	private void loadData(){
		try {
			MongoClient dbClient = new MongoClient();
			MongoDatabase db = dbClient.getDatabase("supplier");
			//db.createCollection("supplier");
			MongoCollection<Document> coll = db.getCollection("articles");
			FindIterable<Document> itr = coll.find();
			itr.forEach(new Block<Document>() {
			    
			    public void apply(final Document document) {
				String id = document.getObjectId("_id").toString();
				
				Supplier.this.articleList.put(
					id,
					(Article)articleFactory.getArticle(
						id,
						document.getString("name"),
						document.getString("description"),
						document.getDouble("price"),
						document.getInteger("quantity")
					)
				);
				
			    }
			});
		} catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("Can't load data");
		}
	}

	/**
	 * Retourne la liste des articles.
	 * @return La liste des articles
	 */
	public Article[] getArticleList(){
		return articleList.values().toArray(new Article[0]);
	}
	
	/**
	 * Retourne un article spécifique.
	 * @param id L'identifiant
	 * @return un Article
	 */
	public Article getArticleById(String id){
		return articleList.get(id);
	}
	
	/*
	public void removeArticle(String id){
		// TODO ??? 
		//articleList.get(id);
	}
	*/
	
	/** Numéro de transaction incrémental */
	private int transacId = 1;
	
	/**
	 * Effectue une commande fournisseur.
	 * @param articles La liste des articles
	 * @return Le statut de la commande fournisseur
	 */
	public synchronized OrderStatus placeOrder(Article [] articles){
		OrderStatus os = new OrderStatus();
		List<Article> outOfStockList = new LinkedList<Article>();
		for(Article a : articles){
			Article cmp = this.articleList.get(a.getId());
			if (cmp == null){
				outOfStockList.add(a);
				continue;
			}
			if (cmp.getQuantity() < a.getQuantity()){
				outOfStockList.add(a);
			}
		}
		if (outOfStockList.size() > 0){
			os.articles = outOfStockList.toArray(new Article[0]);
			os.status = false;
			return os;
		}else{
			// retrait des quantités
			for (Article a : articles){
				Article old = this.articleList.remove(a.getId());
				Article newOne = new Article(old.getId(), old.getName(), old.getDescription(), old.getPrice(), old.getQuantity() - a.getQuantity());
				this.articleList.put(newOne.getId(), newOne);
				// TODO update l'article sur la DB
			}
			os.status = true;
			String transactionId = Integer.toString(transacId);
			
			os.setTransactionId(transactionId);
			this.transactions.add(new Transaction(transactionId, articles));
			transacId++;
			return os;
		}	
	}
	
	/**
	 * Annule un ordre de commande.
	 * @param transacId L'identifiant de la transaction
	 * @return Vrai si la transaction a pu être annulée, faux sinon
	 */
	public synchronized boolean cancelOrder(String transacId){
		for (Transaction t : this.transactions){
			if (t.getId().equals(transacId)){
				t.setCanceled(true);
				return true;
			}
		}
		return false;
	}
	
}
