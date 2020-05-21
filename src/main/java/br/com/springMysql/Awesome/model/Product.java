package br.com.springMysql.Awesome.model;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Created by Lucas Duarte
 */

@Entity
public class Product extends AbstractEntity{
    private String name;
    private String code;
    private int quantity;
    private float value;

    public Product() {
    }

    public Product(String name, String code, int quantity, float value) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Float.compare(product.value, value) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, code, quantity, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
