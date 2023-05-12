package com.example.Note.Model.PaymentModel;

import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "creditCard")
public class creditCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creditCardID")
    private int creditCardID;

    @Column(name = "creditCardName")
    private String creditCardName;

    @Column(name = "creditCardExpired")
    private String creditCardExpired;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="credit_card_id")
    private User user;

    public creditCard(){

    }

    public creditCard(int creditCardID, String creditCardName, String creditCardExpired, User user) {
        this.creditCardID = creditCardID;
        this.creditCardName = creditCardName;
        this.creditCardExpired = creditCardExpired;
        this.user = user;
    }

    public int getCreditCardID() {
        return creditCardID;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public String getCreditCardExpired() {
        return creditCardExpired;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setCreditCardID(int creditCardID) {
        this.creditCardID = creditCardID;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public void setCreditCardExpired(String creditCardExpired) {
        this.creditCardExpired = creditCardExpired;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
