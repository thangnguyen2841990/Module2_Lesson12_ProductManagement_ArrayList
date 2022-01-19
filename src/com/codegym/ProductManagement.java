package com.codegym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Collections.sort;

public class ProductManagement {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> products = new ArrayList<>();

    public ProductManagement(ArrayList<Product> products) {
        this.products = products;
    }

    public ProductManagement() {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void displayAllProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    public void addNewProduct(Product newProduct) {
        products.add(newProduct);
    }

    public int findIdProduct(int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }

    public void removeProduct(int index) {
        products.remove(index);
    }

    public void updateProduct(int index, Product newProduct) {
        products.set(index, newProduct);
    }

    public int findNameProduct(String name) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public int getSizeProducts() {
        return this.products.size();
    }

    public void menu() {
        System.out.println("----MENU QUẢN LÝ SẢN PHẨM----");
        System.out.println("1. Hiển thị toàn bộ sản phẩm.");
        System.out.println("2. Thêm sản phẩm mới.");
        System.out.println("3. Cập nhật sản phẩm theo ID.");
        System.out.println("4, Xóa sản phảm theo ID.");
        System.out.println("5. Tìm kiếm sản phẩm theo tên:. ");
        System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần.");
        System.out.println("7. Thoát.");
    }

    public Product inputNewProduct() {
        System.out.println("Nhập ID sản phẩm: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int price = scanner.nextInt();
        return new Product(id, name, price);
    }

    public void sortProducts() {
        Collections.sort(products);
    }


}
