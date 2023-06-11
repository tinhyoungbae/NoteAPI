package com.example.Note.Model.NewsModel;

import com.example.Note.Model.ImageModel.imageNews;
import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "news")
public class News {
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
    @JoinColumn(name="userID")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy="imageNewsID", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<imageNews> imageNews;

    public News(){

    }

    public News(int newsID, String newsTitle, String newsContent, User user, List<com.example.Note.Model.ImageModel.imageNews> imageNews) {
        this.newsID = newsID;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.user = user;
        this.imageNews = imageNews;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonManagedReference
    public List<imageNews> getImageNews() {
        return imageNews;
    }

    public void setImageNews(List<imageNews> imageNews) {
        this.imageNews = imageNews;
    }
}
