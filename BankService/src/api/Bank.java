package api;

import java.util.List;

public class Bank {

	
	private List<Client> clientList;
	
	public TransactionStatus payment(String creditCardNumber, int cryptogram, int month, int year){
		return null;
		
	}
	
	public double currencyConvertor(String fromCurrency, String toCurrency){
		return 0;
	}
	
	public boolean hasEnoughMoney(Client c, double amount){
		return c.getMoney()-amount >= 0;
	}
	
	
	class TransactionStatus{
		private boolean status;
		private int transactionId;
		
	}
	
	
	
	
	
}
