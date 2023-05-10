package com.example.Note.Model.NewsModel;

import com.example.Note.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "news")
public class News implements Serializable {
    // foreign key between News and User
    @Column(name = "userID")
    @ManyToMany(mappedBy = "userNews")
    Set<User> newsUser;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsID")
    private int noteID;

    @Column(name = "newsTitle")
    private String newsTitle;

    @Column(name = "newsContent")
    private String newsContent;

    public News(){

    }

    public News(Set<User> newsUser, int noteID, String newsTitle, String newsContent) {
        this.newsUser = newsUser;
        this.noteID = noteID;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public Set<User> getNewsUser() {
        return newsUser;
    }

    public void setNewsUser(Set<User> newsUser) {
        this.newsUser = newsUser;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
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
}
