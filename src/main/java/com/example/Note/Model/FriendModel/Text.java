package com.example.Note.Model.FriendModel;

import com.example.Note.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "text")
public class Text implements Serializable {
    // foreign key between Text and User
    @Column(name = "userID")
    @ManyToMany(mappedBy = "userText")
    Set<User> textUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "textID")
    private int textID;

    @Column(name = "textContent")
    private String textContent;

    public Text(){

    }

    public Text(Set<User> textUser, int textID, String textContent) {
        this.textUser = textUser;
        this.textID = textID;
        this.textContent = textContent;
    }

    public Set<User> getTextUser() {
        return textUser;
    }

    public void setTextUser(Set<User> textUser) {
        this.textUser = textUser;
    }

    public int getTextID() {
        return textID;
    }

    public void setTextID(int textID) {
        this.textID = textID;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
