package com.codegym;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        ComparableProduct comparableProduct =new ComparableProduct();
        productManagement.menu();
        int choice = -1;
        while (true) {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice == 7) {
                break;
            }
            if (choice > 7) {
                System.out.println("Menu chỉ có từ 1 ==> 7");
            }
            switch (choice) {
                case 1: {
                    System.out.println("----Hiển thị toàn bộ sản phẩm----");
                    productManagement.displayAllProducts();
                    if (productManagement.getSizeProducts() == 0) {
                        System.out.println("Không có sản phẩm nào để hiển thị!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("----Thêm sản phẩm----");
                    Product newProduct = productManagement.inputNewProduct();
                    productManagement.addNewProduct(newProduct);
                    System.out.println("!Đã thêm sản phẩm thành công!");
                    break;
                }
                case 3: {
                    System.out.println("----Cập nhật sản phẩm theo ID----");
                    System.out.println("Nhập ID sản phẩm: ");
                    int id = scanner.nextInt();
                    int index = productManagement.findIdProduct(id);
                    if (index == -1) {
                        System.out.println("Không tìm thấy sản phẩm có ID: " + id + "!");
                    } else {
                        Product newProduct = productManagement.inputNewProduct();
                        productManagement.updateProduct(index, newProduct);
                        System.out.println("Đã cập nhật sản phẩm thành công!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("----Xóa sản phẩm theo ID----");
                    System.out.println("Nhập ID sản phẩm: ");
                    int id = scanner.nextInt();
                    int index = productManagement.findIdProduct(id);
                    if (index == -1) {
                        System.out.println("Không tìm thấy sản phẩm có ID: " + id + "!");
                    } else {
                        productManagement.removeProduct(index);
                        System.out.println("Đã xóa sản phẩm thành công!");
                    }
                    break;
                }
                case 5: {
                    System.out.println("----Tìm kiếm sản phẩm theo tên----");
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    int index = productManagement.findNameProduct(name);
                    if (index == -1) {
                        System.out.println("Không tìm thấy sản phẩm có tên: " + name + "!");
                    } else {
                        System.out.println(productManagement.getProducts().get(index));
                    }
                    break;
                }
                case 6: {
                    System.out.println("----Sắp xếp sản phẩm theo giá tăng dần----");
                    productManagement.sortProducts();
                    break;
                }
            }
        }

    }
}
