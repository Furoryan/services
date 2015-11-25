package fr.alma.domaine.repositories;

import fr.alma.domaine.valueObject.IArticle;

public interface PurchaseRepository {

	public void saveToDb(IArticle[] articles);
	
}