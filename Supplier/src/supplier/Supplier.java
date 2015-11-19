package supplier;

import java.util.LinkedList;

import com.mongodb.MongoClient;

import shared.*;

public class Supplier {
	
	private LinkedList<Article> articles;
	
	public Supplier(){
		this.articles = new LinkedList<>();
	}
	
	private void loadData(){
		MongoClient dbClient = new MongoClient();
	}
	
	/**
	 * Retourne le nom de l'intégralité des articles.
	 * @return
	 */
	public String[] getItemsNames(){
		String [] s = new String[this.articles.size()];
		int i=0;
		for (Article a : this.articles){
			s[i++] = a.name;
		}
		return s;
	}
	
	/**
	 * Retourne l'intégralité des articles sous forme d'un tableau d'instances Article.
	 * @return
	 */
    public Article[] getItemsList(){
    	return (Article[])this.articles.toArray();
    }
    
    /**
     * Retourne une partie des articles, de startId à endId inclusivement.
     * @param startId
     * @param endId
     * @return
     */
    public Article[] getItemsList(int startId, int endId){
    	LinkedList<Article> list = new LinkedList<>();
    	for (Article a : this.articles){
    		if (a.id < startId) continue;
    		if (a.id > endId) break;
    		list.add(a);
    	}
    	return (Article[])list.toArray();
    }
    
    /**
     * Retourne une liste de count articles à partir de startId.
     * @param startId
     * @param count
     * @return
     */
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
    
    /**
     * Retourne un seul article par son id, ou null s'il n'existe pas.
     * @param id
     * @return
     */
    public Article getItemByArticle(int id){
    	for (Article a : this.articles){
    		if (a.id == id) return a;
    	}
    	return null;
    }
    
    /**
     * Retourne un seul article par son nom, ou null s'il n'est pas trouvé.
     * @param name
     * @return
     */
    public Article getItemByName(String name){
    	for (Article a : this.articles){
    		if (a.name.equals(name)) return a;
    	}
    	return null;
    }
    
    public int getItemsCount(){
    	return this.articles.size();
    }
    
    public OrderReceipt placeOrder(Order order){
    	// En premier lieu on vérifie que tous les articles sont disponibles
    	OrderReceipt or = new OrderReceipt();
    	return or;
    }

}
