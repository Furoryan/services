package fr.alma.supplier;

import fr.alma.domaine.valueobject.impl.Article;

public class OrderStatus {
	/** Liste des articles manquants */
	Article[] articles;
	
	/** Indique si la commande a pu être passée ou non */
	boolean status;
	
	/** Identifiant de la transaction */
	String transactionId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
