package fr.alma.domaine.factories;

import fr.alma.domaine.valueObject.IArticle;


public interface ArticleFactory  {

	public IArticle getArticle(int id, String name, String description, double price, int quantity);
	
}
