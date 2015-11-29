package fr.alma.domaine.factories;

import fr.alma.domaine.valueobject.ICreditCard;

public interface CreditCardFactory {
	public ICreditCard getCreditCard(String cardNumber, int cryptogram, int expirationMonth, int expirationYear);
}
