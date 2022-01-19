package com.codegym;

public class ComparableProduct extends Product implements Comparable<Product> {


    public ComparableProduct(int id, String name, int price) {
        super(id, name, price);
    }

    public ComparableProduct() {
        super();
    }

    @Override
    public int compareTo(Product o) {
        if (this.getPrice() > o.getPrice()){
            return 1;
        } else if (this.getPrice() < o.getPrice()){
            return -1;
        } else {
            return 0;
        }
    }
}
