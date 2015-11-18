package api;

import java.util.List;

public class Supplier {

	private List<Article> articleList;

	public List<Article> getArticleList(){
		return articleList;
	}
	
	public Article getArticleById(int id){
		return articleList.get(id);
	}
	
	
	public void removeArticle(int id){
		articleList.get(id);
	}
	
	
	
	
}
