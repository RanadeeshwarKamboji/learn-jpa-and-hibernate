package com.rana.groceries.learn_jpa_and_hibernate.Jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "PRODUCTS")
public class Product {

    @Id
    private long id;
    private String name;
    private int price;
    private int quantity;

    public Product(){

    }

    public Product(long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Product[Id: " + this.id+", Name: "+this.name+ " ,Price: "+ price + ", Quantity: " + quantity +"]";
    }
}
