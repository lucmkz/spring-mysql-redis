package br.com.springMysql.model;

/**
 *  Created by Lucas Duarte
 * */

public class Product {
    private String name;
    private float value;
    private int quanity;
    private int code;

    public Product(String name, float value, int quanity, int code) {
        this.name = name;
        this.value = value;
        this.quanity = quanity;
        this.code = code;
    }

    public Product() {
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

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
