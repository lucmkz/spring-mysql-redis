package br.com.springMysql.awesome.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "order_product")
@Table(name = "order_product")
public class Order extends AbstractEntity{


    @ManyToMany
    private List<Product> product;

    @OneToOne
    private Costumer costumer;

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

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
