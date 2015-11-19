package shared;

public class Article {
	public String id;
	public String name;
	public String description;
	public int quantity;
	public double price;
	
	public Article(String id, String name, String description, int quantity, double price){
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
}
