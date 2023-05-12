package com.example.Note.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private int productID;

    @Column(name = "productName")
    private String productName;

    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private List<Price> productPrice;

    public Product(){

    }

    public Product(int productID, String productName, List<Price> productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonManagedReference
    public List<Price> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(List<Price> productPrice) {
        this.productPrice = productPrice;
    }
}