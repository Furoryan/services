package fr.alma.domaine.services.impl;

import fr.alma.domaine.services.IStore;
import fr.alma.domaine.valueobject.IArticle;
import fr.alma.domaine.valueobject.ICreditCard;

import java.util.Map;
import java.util.HashMap;

import fr.alma.domaine.valueobject.*;
import fr.alma.domaine.valueobject.impl.*;
/*
import fr.alma.domaine.factories.*;
import fr.alma.implementation.domaine.factories.*;
*/

public class Store implements IStore{

	Map<Integer, IArticle> articles;
	//ArticleFactory articleFactory;

	public Store(){
		this.articles = new HashMap<Integer, IArticle>();
		//this.articleFactory = new SimpleArticleFactory();
	}
	
	

	public IArticle[] articles(){
		return (IArticle[])this.articles.values().toArray();
	}
	public String placeOrder(IArticle[] articles, ICreditCard creditCard){
		return null;
	}
}
