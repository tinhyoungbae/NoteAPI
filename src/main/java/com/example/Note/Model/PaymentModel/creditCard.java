package com.example.Note.Model.PaymentModel;

import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "creditCard")
public class creditCard implements Serializable {
    // foreign key between creditCard and User
    //@ManyToMany(mappedBy = "userCreditCard")
    //Set<User> creditCardUser;

    @Id
    @Column(name = "creditCardNumber")
    private String creditCardNumber;

    @Column(name = "creditCardName")
    private String creditCardName;

    @Column(name = "creditCardExpired")
    private String creditCardExpired;

    public creditCard(){

    }

    public creditCard(String creditCardNumber, String creditCardName, String creditCardExpired) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.creditCardExpired = creditCardExpired;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCreditCardExpired() {
        return creditCardExpired;
    }

    public void setCreditCardExpired(String creditCardExpired) {
        this.creditCardExpired = creditCardExpired;
    }
}
