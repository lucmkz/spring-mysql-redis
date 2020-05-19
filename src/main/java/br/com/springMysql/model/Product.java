package br.com.springMysql.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

/**
 *  Created by Lucas Duarte
 * */

public class Product {
    private String name;
    private float value;
    private int quantity;
    private int code;
    private int id;
    public static List<Product> productList;
    static {
        productRepository();
    }

    public Product() {
    }

    public Product(int id, String name, float value, int quantity, int code) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.code = code;
    }

    private static void productRepository(){
        productList = new ArrayList<>(asList(new Product(1, "Lucas", 1, 2, 3), new Product(2, "Lucass", 2, 3, 4)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
