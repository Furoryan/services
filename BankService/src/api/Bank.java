package api;

import java.util.List;

public class Bank {

	
	private List<CreditCard> creditCardList;
	
	public Bank(){
		
		
		creditCardList.add(new CreditCard("code", 123, 12, 16, 3000));
		creditCardList.add(new CreditCard("code1", 112, 12, 16, 0));
		creditCardList.add(new CreditCard("code2", 123, 11, 20, 200));
	}
	
	
	public boolean payment(String cardNumber, int cryptogram, int month, int year, double amount){
		CreditCard c = new CreditCard(cardNumber, cryptogram, month, year);
		boolean res = false;
		
		if(isCardValid(c)){
			if(hasEnoughMoney(c, amount)){
				res = true;
			}
		}
		return res;
		
	}
	
	
	public double currencyConvertor(String fromCurrency, String toCurrency){
		return 0;
	}
	
	public boolean hasEnoughMoney(CreditCard c, double amount){
		boolean res = false;
		for(int i = 0; i < creditCardList.size(); i++){
			if(creditCardList.get(i).equals(c)){
				CreditCard tmpCard = creditCardList.get(i);
				res = tmpCard.getMoney() - amount >= 0;
		
			}
		}
		return res;
	}
	
	
	private boolean isCardValid(CreditCard c){
		return creditCardList.contains(c);
	}
	
	class TransactionStatus{
		private boolean status;
		private int transactionId;
		private String description;
		
	}
	
	
	
	
}
