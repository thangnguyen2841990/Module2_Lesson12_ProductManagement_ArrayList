package com.codegym;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        int choice = -1;
        try {
            productManagement.readerToFile("product.txt");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            menu();
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice > 6) {
                System.out.println("Menu chỉ có từ 1 ==> 7");
            }
            switch (choice) {
                case 1: {
                    System.out.println("----Hiển thị toàn bộ sản phẩm----");
                    productManagement.displayAllProduct();

                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("----Thêm sản phẩm----");
                    System.out.println("Nhập mã sản phẩm: ");
                    String id = scanner.nextLine();
                    Product newProduct = inputNewProductInfo();
                    productManagement.addProduct(id, newProduct);
                    System.out.println("!Đã thêm sản phẩm thành công!");
                    break;
                }
                case 3: {
                    scanner.nextLine();
                    System.out.println("----Cập nhật sản phẩm theo ID----");
                    System.out.println("Nhập ID sản phẩm: ");
                    String id = scanner.nextLine();
                    if (productManagement.findID(id)) {
                        Product newProduct = inputNewProductInfo();
                        productManagement.updateProduct(id, newProduct);
                        System.out.println("Đã cập nhật sản phẩm thành công!");
                    } else {
                        System.out.println("Mã sản phẩm không tồn tại!");
                    }
                    break;
                }
                case 4: {
                    scanner.nextLine();
                    System.out.println("----Xóa sản phẩm theo ID----");
                    System.out.println("Nhập ID sản phẩm: ");
                    String id = scanner.nextLine();
                    if (productManagement.findID(id)) {
                        productManagement.removeProduct(id);
                        System.out.println("Đã xóa sản phẩm thành công!");
                    } else {
                        System.out.println("Mã sản phẩm không tồn tại!");
                    }
                    break;
                }
                case 5: {
                    scanner.nextLine();
                    System.out.println("----Tìm kiếm sản phẩm theo ID----");
                    System.out.println("Nhập ID sản phẩm: ");
                    String id = scanner.nextLine();
                    if (productManagement.findID(id)) {
                  Product product =  productManagement.findProductById(id);
                    System.out.println(product);
                    } else {
                        System.out.println("Mã sản phẩm không tồn tại!");
                    }
                    break;
                }
                case 6: {
                    System.out.println("----Sắp xếp sản phẩm theo giá tăng dần----");
//                    productManagement.sortProducts();
                    break;
                }
            }
            try {
                productManagement.writerToFile(productManagement.getProducts(),"product.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void menu() {
        System.out.println("----MENU QUẢN LÝ SẢN PHẨM----");
        System.out.println("1. Hiển thị danh sách sản phẩm.");
        System.out.println("2. Thêm sản phẩm mới.");
        System.out.println("3. Cập nhật sản phẩm theo ID.");
        System.out.println("4. Xóa sản phẩm theo ID.");
        System.out.println("5. Tìm kiếm sản phẩm theo ID.");
        System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần.");
        System.out.println("0. Thoát.");

    }

    public static Product inputNewProductInfo() {
        System.out.println("Nhập thông tin sản phẩm: ");
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int price = scanner.nextInt();
        return new Product(name, price);
    }
}
