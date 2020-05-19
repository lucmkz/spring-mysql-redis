package br.com.springMysql.Awesome.model;

import javax.persistence.Entity;

/**
 * Created by Lucas Duarte
 */

@Entity
public class Product extends AbstractEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
