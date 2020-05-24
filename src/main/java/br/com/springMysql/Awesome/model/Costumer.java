package br.com.springMysql.Awesome.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Costumer extends AbstractEntity{
    private String name;
    private String nationality;
    private String deliveryAddress;
    private String houseAddress;
    private int documentId;

    @OneToOne
    private Order order;

    public Costumer() {
    }

    public Costumer(String name, String nationality, String deliveryAddress, String houseAddress, int documentId) {
        this.name = name;
        this.nationality = nationality;
        this.deliveryAddress = deliveryAddress;
        this.houseAddress = houseAddress;
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costumer that = (Costumer) o;
        return documentId == that.documentId &&
                Objects.equals(name, that.name) &&
                Objects.equals(nationality, that.nationality) &&
                Objects.equals(deliveryAddress, that.deliveryAddress) &&
                Objects.equals(houseAddress, that.houseAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality, deliveryAddress, houseAddress, documentId);
    }

    @Override
    public String toString() {
        return "CostumerModel{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                ", documentId=" + documentId +
                '}';
    }
}
