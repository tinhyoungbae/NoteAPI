package com.example.Note.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "priceID")
    private int priceID;

    @Column(name = "priceValue")
    private float priceValue;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "productID")
    private Product product;

    public Price(){

    }

    public Price(int priceID, float priceValue, Product product) {
        this.priceID = priceID;
        this.priceValue = priceValue;
        this.product = product;
    }

    public int getPriceID() {
        return priceID;
    }

    public void setPriceID(int priceID) {
        this.priceID = priceID;
    }

    public float getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(float priceValue) {
        this.priceValue = priceValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}