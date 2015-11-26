package fr.alma.domaine.repositories;

import fr.alma.domaine.valueobject.IArticle;

public interface PurchaseRepository {

	public void saveToDb(IArticle[] articles);
	
}