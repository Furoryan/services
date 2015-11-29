package fr.alma.domaine.services.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;

import fr.alma.bank.BankStub;
import fr.alma.bank.BankStub.Payment;
import fr.alma.bank.BankStub.PaymentResponse;
import fr.alma.domaine.services.IStore;
import fr.alma.domaine.valueobject.IArticle;
import fr.alma.domaine.valueobject.ICreditCard;
import fr.alma.domaine.valueobject.impl.Article;
import fr.alma.supplier.SupplierStub;
import fr.alma.supplier.SupplierStub.CancelOrder;
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
	
	/*
	public String testPlaceOrder(){
		String r = "test 1 should be true:";
		r += placeOrder(new Article[]{
					new Article("5659eabf0f8038a656e29bcd", "Nom Article 4", "Description article 4", 81.37, 7),
					new Article("5659eabf0f8038a656e29bce", "Nom Article 2", "Description article 2", 14.28, 1)},
				new CreditCard("code", 123, 12, 16, 3000));
		r += " \n test 2 should be false:";
		r += placeOrder(new Article[]{new Article("5659eabf0f8038a656e29bcd", "Nom Article 4", "Description article 4", 81.37, 200)},
				new CreditCard("code", 123, 12, 16, 3000));
		r += " \n test 3 should be false:";
		r += placeOrder(new Article[]{new Article("5659eabf0f8038a650000000", "Nom Article 4", "Description article 4", 81.37, 1)},
						new CreditCard("code", 123, 12, 16, 3000));
		return r;
	}
	*/
	
	public Article[] articles(){
		return (Article[])this.articles.values().toArray(new Article[0]);
	}
	public String placeOrder(IArticle[] articles, ICreditCard creditCard){
		String transacId = null;
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
			transacId = os.getTransactionId();
		} catch (AxisFault e) {
			e.printStackTrace();
			return "ERROR:AxisFault:" + e.getMessage();
		} catch (RemoteException e){
			e.printStackTrace();
			return "ERROR:RemoteException:" + e.getMessage();
		}
		
		// calcul du total
		double amount = 0;
		for (IArticle a : articles){
			amount += a.getPrice() * a.getQuantity();
		}
		
		// Vérifier la carte bancaire
		try {
			BankStub stub = new BankStub();
			Payment param = new Payment();
			param.setCardNumber(creditCard.getCardNumber());
			param.setMonth(creditCard.getExpirationMonth());
			param.setYear(creditCard.getExpirationYear());
			param.setCryptogram(creditCard.getCardCryptogram());
			param.setAmount(amount);
			PaymentResponse pr = stub.payment(param);
			if (pr.get_return()){
				return "SUCCESS";
			}else{
				// pas assez de sous!
				// on annule la commande auprès du fournisseur
				SupplierStub suppStub = new SupplierStub();
				CancelOrder p = new CancelOrder();
				p.setTransacId(transacId);	
				if (!suppStub.cancelOrder(p).get_return()){
					// le fournisseur n'a pas pu annuler la commande => gros PB!
				}
				return "ERROR:payment";
			}		
		} catch (AxisFault e) {
			e.printStackTrace();
			return "ERROR:AxisFault:" + e.getMessage();
		} catch (RemoteException e){
			e.printStackTrace();
			return "ERROR:RemoteException:" + e.getMessage();
		}
	}
}
