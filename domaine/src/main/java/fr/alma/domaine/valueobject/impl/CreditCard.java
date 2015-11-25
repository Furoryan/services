package fr.alma.domaine.valueObject.impl;

import fr.alma.domaine.valueObject.ICreditCard;

public class CreditCard {

	private int id;
	private double money;
	private String cardNumber;
	private int cardCryptogram;
	private int expirationMonth;
	private int expirationYear;	
	
	public CreditCard(String cardNumber, int cardCryptogram, int expirationMonth, int expirationYear, double money) {
		this.money = money;
		this.cardNumber = cardNumber;
		this.cardCryptogram = cardCryptogram;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}
	

	
	
	public CreditCard(String cardNumber, int cardCryptogram, int expirationMonth, int expirationYear) {
		this.cardNumber = cardNumber;
		this.cardCryptogram = cardCryptogram;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}




	public boolean hasEnoughMoney(double amount){
		return money - amount >= 0;
	}
	
	public boolean isCardValid(CreditCard c){
		return this.equals(c);
	}
	
	public int getId() {
		return id;
	}
	
	public double getMoney() {
		return money;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public int getCardCryptogram() {
		return cardCryptogram;
	}
	
	public int getExpirationMonth() {
		return expirationMonth;
	}
	
	public int getExpirationYear() {
		return expirationYear;
	}
	
	public boolean equals(CreditCard c){
		return cardNumber == c.getCardNumber() && 
		   cardCryptogram == c.getCardCryptogram() && 
		   expirationMonth == c.getExpirationMonth() && 
		   expirationYear == c.getExpirationYear();
	} 
}