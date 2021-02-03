package de.neuefische.productservice.model;

import java.util.ArrayList;


public class Order {
    private String id;
    private ArrayList<String> orderedProducts;

    public Order(String id, ArrayList<String> orderedProducts) {
        this.id = id;
        this.orderedProducts = orderedProducts;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(ArrayList<String> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
}
