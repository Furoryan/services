package fr.alma.implementation.domaine.factories;

import fr.alma.domaine.factories.ArticleFactory;
import fr.alma.domaine.valueObject.impl.Article;

public class SimpleArticleFactory implements ArticleFactory {
	@Override
	public Article getArticle(int id, String name, String description, double price, int quantity){
		return new Article(id, name, description, price, quantity);
	}
	
}
	