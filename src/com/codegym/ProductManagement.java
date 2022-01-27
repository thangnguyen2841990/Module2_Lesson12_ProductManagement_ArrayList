package com.codegym;

import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class ProductManagement {
    private Map<String, Product> products = new HashMap<>();

    public ProductManagement(Map<String, Product> products) {
        this.products = products;
    }

    public ProductManagement() {

    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    // Thêm sản phẩm mới
    public void addProduct(String id, Product product) {
        products.put(id, product);
    }
    // Xóa sản phẩm
    public void removeProduct(String id) {
        products.remove(id);
    }
    //Cập nhật sản phẩm
    public void updateProduct(String id,Product newProduct){
        products.replace(id, newProduct);
    }
    //Kiểm tra ID có trong Map không
    public boolean findID(String id){
        if (products.containsKey(id)){
            return true;
        } else {
            return false;
        }
    }
    //Tìm sản phẩm theo ID
    public Product findProductById(String id){
        return this.products.get(id);
    }
    //Hiển thị toàn bộ sản phẩm
    public void displayAllProduct(){
        Set<Map.Entry<String, Product>> products1 = this.products.entrySet();
        for (Map.Entry<String, Product> product :products1) {
            System.out.println(product);
        }
    }
    //sắp xếp sản phẩm
    public void sortProductByPrice(){

    }

    public void writerToFile(Map<String,Product> products, String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(products);
    }
    public void readerToFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.products = (Map<String, Product>) ois.readObject();
    }
}
