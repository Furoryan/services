package fr.alma.domaine.valueobject.impl;

import fr.alma.domaine.valueobject.IArticle;

public class Article implements IArticle {
	private String id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public Article(String id, String name, String description, double price, int quantity){
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity(){
		return quantity;
	}
}
