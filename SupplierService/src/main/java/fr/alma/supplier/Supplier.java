package fr.alma.supplier;

import java.util.Map;
import java.util.HashMap;
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

	public Supplier(){
		// construire la Factory des articles
		this.articleFactory = new SimpleArticleFactory();
		// construire la liste des articles
		this.articleList = new HashMap<String, Article>();
		/*
		this.articleList.add(articleFactory.getArticle(1, "Article 1", "Description 1", 12.99, 10));
		this.articleList.add(articleFactory.getArticle(2, "Article 2", "Description 2", 44.99, 5));
		*/
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

	public Article[] getArticleList(){
		return articleList.values().toArray(new Article[0]);
	}
	
	public Article getArticleById(String id){
		return articleList.get(id);
	}
	
	public void removeArticle(String id){
		// TODO ??? 
		//articleList.get(id);
	}
	
}
