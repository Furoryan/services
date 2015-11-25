package fr.alma.services.actions.data;

/**
 * Created by nicolas on 11/22/15.
 */
public class Article {


    private static int id;
    private String name;
    private String description;
    private double price;
    private int quantity;


    public Article(){
        this.id = id++;
    }


    public Article(String name, String description, double price, int quantity){
        this.id = id++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public static int getId() {
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
}
