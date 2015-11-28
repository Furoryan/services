package fr.alma.domaine.services;

import fr.alma.domaine.valueobject.IArticle;
import fr.alma.domaine.valueobject.ICreditCard;

public interface IStore {
	public IArticle[] articles();
	
	public String placeOrder(IArticle[] articles, ICreditCard creditCard);
	
}
