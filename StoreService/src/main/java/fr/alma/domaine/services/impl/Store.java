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
import fr.alma.supplier.SupplierStub.OrderStatus;
import fr.alma.supplier.SupplierStub.PlaceOrder;
import fr.alma.supplier.SupplierStub.PlaceOrderResponse;
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
		// Vérifier la dispo de tous les articles
		try {
			SupplierStub stub = new SupplierStub("http://127.0.0.1:9763/services/Supplier/");
			PlaceOrder param = new PlaceOrder();
			SupplierStub.Article[] arts = new SupplierStub.Article[articles.length];
			int i = 0;
			for (IArticle a : articles){
				arts[i] = new SupplierStub.Article();
				arts[i].setId(a.getId());
				arts[i].setName(a.getName());
				arts[i].setDescription(a.getDescription());
				arts[i].setPrice(a.getPrice());
				arts[i].setQuantity(a.getQuantity());
				i++;
			}
			param.setArticles(arts);
			PlaceOrderResponse por = stub.placeOrder(param);
			OrderStatus os = por.get_return();
			if (os.getStatus() == false){
				return "ERROR:Des articles sont indisponibles";
			}
		} catch (AxisFault e) {
			// TODO traiter ça proprement
			e.printStackTrace();
		} catch (RemoteException e){
			// TODO traiter ça proprement
			e.printStackTrace();
		}
		
		// Vérifier la carte bancaire
		// TODO
		
		return "SUCCESS";
	}
}
