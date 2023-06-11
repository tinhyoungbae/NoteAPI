package com.example.Note.Model.FriendModel;

import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "text")
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "textID")
    private int textID;

    @Column(name = "textContent")
    private String textContent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userID")
    private User user;

    public Text(){

    }

    public Text(int textID, String textContent, User user) {
        this.textID = textID;
        this.textContent = textContent;
        this.user = user;
    }

    public int getTextID() {
        return textID;
    }

    public String getTextContent() {
        return textContent;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setTextID(int textID) {
        this.textID = textID;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
