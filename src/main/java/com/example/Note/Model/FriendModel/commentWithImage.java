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
@Table(name = "commentWithImage")
public class commentWithImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentWithImageID")
    private int commentWithImageID;

    @Column(name = "commentContent")
    private String commentWithImageContent;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="commentWithImage_id")
    private User user;

    public commentWithImage(){

    }

    public commentWithImage(int commentWithImageID, String commentWithImageContent, String url, User user) {
        this.commentWithImageID = commentWithImageID;
        this.commentWithImageContent = commentWithImageContent;
        this.url = url;
        this.user = user;
    }

    public int getCommentWithImageID() {
        return commentWithImageID;
    }

    public String getCommentWithImageContent() {
        return commentWithImageContent;
    }

    public String getUrl() {
        return url;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setCommentWithImageID(int commentWithImageID) {
        this.commentWithImageID = commentWithImageID;
    }

    public void setCommentWithImageContent(String commentWithImageContent) {
        this.commentWithImageContent = commentWithImageContent;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
