package fr.alma.domaine.services;

import fr.alma.domaine.valueObject.IArticle;
import fr.alma.domaine.valueObject.ICreditCard;

public interface IStore {
	public IArticle[] articles();
	public String placeOrder(IArticle[] articles, ICreditCard creditCard);
}
