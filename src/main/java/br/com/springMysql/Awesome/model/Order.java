package br.com.springMysql.Awesome.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Objects;

@Entity
public class Order extends AbstractEntity{


    @OneToMany
    private List<Product> product;


    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product);
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Order(List<Product> product) {
        this.product = product;
    }

    public Order() {
    }
}