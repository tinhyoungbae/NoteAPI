package com.example.Note.Model.NewsModel;

import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsID")
    private int newsID;

    @Column(name = "newsTitle")
    private String newsTitle;

    @Column(name = "newsContent")
    private String newsContent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="news_id")
    private User user;

    public News(){

    }

    public News(int newsID, String newsTitle, String newsContent, User user) {
        this.newsID = newsID;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.user = user;
    }

    public int getNewsID() {
        return newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
