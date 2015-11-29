package fr.alma.supplier;

import fr.alma.domaine.valueobject.impl.Article;

public class Transaction {
	
	String id;
	Article[] articles;
	boolean canceled = false;
	
	public Transaction(String id, Article[] articles){
		this.id = id;
		this.articles = articles;
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public String getId() {
		return id;
	}
	
}
