package fr.alma.domaine.services.impl;

import fr.alma.domaine.services.IStore;
import fr.alma.domaine.valueobject.IArticle;
import fr.alma.domaine.valueobject.ICreditCard;

import java.util.Map;

import org.apache.axis2.AxisFault;

import java.rmi.RemoteException;
import java.util.HashMap;

import fr.alma.domaine.valueobject.*;
import fr.alma.domaine.valueobject.impl.*;
import fr.alma.supplier.SupplierStub;
import fr.alma.supplier.SupplierStub.GetArticleList;
import fr.alma.supplier.SupplierStub.GetArticleListResponse;
/*
import fr.alma.domaine.factories.*;
import fr.alma.implementation.domaine.factories.*;
*/

public class Store implements IStore {

	Map<String, Article> articles;
	//ArticleFactory articleFactory;

	public Store(){
		this.articles = new HashMap<String, Article>();
		//this.articleFactory = new SimpleArticleFactory();
		this.loadData();
	}
	
	private void loadData(){
		// Chargement des données
		try {
			SupplierStub stub = new SupplierStub("http://127.0.0.1:9763/services/Supplier/");
			GetArticleList param = new GetArticleList();
			GetArticleListResponse resp = stub.getArticleList(param);
			fr.alma.supplier.SupplierStub.Article[] arts = resp.get_return();
			for (fr.alma.supplier.SupplierStub.Article a : arts){
				this.articles.put(a.getId(), new Article(
					a.getId(), a.getName(), a.getDescription(), a.getPrice(), a.getQuantity() 
				));
			}
		} catch (AxisFault e) {
			// TODO traiter ça proprement
			e.printStackTrace();
		} catch (RemoteException e){
			// TODO traiter ça proprement
			e.printStackTrace();
		}
		
		
	}
	
	

	public Article[] articles(){
		return (Article[])this.articles.values().toArray(new Article[0]);
	}
	public String placeOrder(IArticle[] articles, ICreditCard creditCard){
		return null;
	}
}
