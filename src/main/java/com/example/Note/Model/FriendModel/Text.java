package com.example.Note.Model.FriendModel;

import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "text")
public class Text implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "textID")
    private int textID;

    @Column(name = "textContent")
    private String textContent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="text_id")
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
