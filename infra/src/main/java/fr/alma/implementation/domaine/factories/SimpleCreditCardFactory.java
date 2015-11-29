package fr.alma.implementation.domaine.factories;

import fr.alma.domaine.factories.CreditCardFactory;
import fr.alma.domaine.valueobject.impl.CreditCard;

public class SimpleCreditCardFactory implements CreditCardFactory {
	public CreditCard getCreditCard(String cardNumber, int cryptogram, int expirationMonth, int expirationYear){
		return new CreditCard(cardNumber, cryptogram, expirationMonth, expirationYear);
	}

}
