package com.example.Note.Model.FriendModel;

import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import com.example.Note.Model.ImageModel.imageComment;

import java.io.Serializable;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private int commentID;

    @Column(name = "commentTitle")
    private String commentTitle;

    @Column(name = "commentContent")
    private String commentContent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userID")
    private User user;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "imageCommentID", referencedColumnName = "imageCommentID")
    private imageComment imageComment;

    public Comment(){

    }

    public Comment(int commentID, String commentTitle, String commentContent, User user, com.example.Note.Model.ImageModel.imageComment imageComment) {
        this.commentID = commentID;
        this.commentTitle = commentTitle;
        this.commentContent = commentContent;
        this.user = user;
        this.imageComment = imageComment;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public imageComment getImageComment() {
        return imageComment;
    }

    public void setImageComment(imageComment imageComment) {
        this.imageComment = imageComment;
    }
}
