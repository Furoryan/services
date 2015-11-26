package fr.alma.domaine.valueobject;

public interface ICreditCard {
	public boolean hasEnoughMoney(double amount);
	
	public boolean isCardValid(ICreditCard c);
	
	public int getId();
	
	public double getMoney();
	
	public String getCardNumber();
	
	public int getCardCryptogram();
	
	public int getExpirationMonth();
	
	public int getExpirationYear();
}