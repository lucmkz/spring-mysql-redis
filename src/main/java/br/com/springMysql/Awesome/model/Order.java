package br.com.springMysql.Awesome.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Order extends AbstractEntity{

    @OneToMany
    private List<Product> product;
}
