package com.codegym;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "ID: "+ this.id + ", tên sản phẩm: "+ this.name + ", giá: "+this.price;
    }

    @Override
    public int compareTo(Product o) {
        if (this.price > o.price) return 1;
        else if (this.price < o.price) return -1;
        else return 0;
    }
}
