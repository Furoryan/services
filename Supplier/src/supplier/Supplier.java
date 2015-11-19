package supplier;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shared.*;

public class Supplier {
	
	public static void main(String args[]){
		new Supplier();
	}
	
	private HashMap<String, Article> articles;
	
	public Supplier(){
		this.articles = new HashMap<>();
		loadData();
	}
	
	private void loadData(){
		MongoClient dbClient = new MongoClient();
		MongoDatabase db = dbClient.getDatabase("supplier");
		//db.createCollection("supplier");
		MongoCollection<Document> coll = db.getCollection("articles");
		FindIterable<Document> itr = coll.find();
		itr.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		    	String id = document.getObjectId("_id").toString();
		    	
		        Supplier.this.articles.put(
		        	id,
		        	new Article(
			        	id,
			        	document.getString("name"),
			        	document.getString("description"),
			        	document.getInteger("quantity"),
			        	document.getDouble("price")
			        )
		        );
		        
		    }
		});
	}
	
	/**
	 * Retourne le nom de l'intégralité des articles.
	 * @return
	 */
	public String[] getItemsNames(){
		String [] s = new String[this.articles.size()];
		int i=0;
		Iterator<Map.Entry<String, Article>> it = this.articles.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Article> pair = it.next();
	        s[i++] = pair.getValue().name;
	    }
		return s;
	}
	
	/**
	 * Retourne l'intégralité des articles sous forme d'un tableau d'instances Article.
	 * @return
	 */
    public Article[] getItemsList(){
    	Article[] arts = new Article[this.articles.size()];
    	int i = 0;
    	for (Article a : this.articles.values()){
    		arts[i++] = a;
    	}
    	return arts;
    }
    
    /**
     * Retourne une partie des articles, de startId à endId inclusivement.
     * @param startId
     * @param endId
     * @return
     */
    /*
    public Article[] getItemsList(int startId, int endId){
    	LinkedList<Article> list = new LinkedList<>();
    	for (Article a : this.articles){
    		if (a.id < startId) continue;
    		if (a.id > endId) break;
    		list.add(a);
    	}
    	return (Article[])list.toArray();
    }
    */
    
    /**
     * Retourne une liste de count articles à partir de startId.
     * @param startId
     * @param count
     * @return
     */
    /*
    public Article[] getItemsListFrom(int startId, int count){
    	int i = 0;
    	Article[] list = new Article[count];
    	for (Article a : this.articles){
    		if (a.id < startId) continue;
    		list[i++] = a;
    		if (i == count) break;
    	}
    	return list;
    }
    */
    
    /**
     * Retourne un seul article par son id, ou null s'il n'existe pas.
     * @param id
     * @return
     */
    public Article getItemByArticle(String id){
    	return this.articles.get(id);
    }
    
    /**
     * Retourne un seul article par son nom, ou null s'il n'est pas trouvé.
     * @param name
     * @return
     */
    /*
    public Article getItemByName(String name){
    	for (Article a : this.articles){
    		if (a.name.equals(name)) return a;
    	}
    	return null;
    }
    */
    
    public int getItemsCount(){
    	return this.articles.size();
    }
    
    public OrderReceipt placeOrder(Order order){
    	// En premier lieu on vérifie que tous les articles sont disponibles
    	OrderReceipt or = new OrderReceipt();
    	return or;
    }

}
