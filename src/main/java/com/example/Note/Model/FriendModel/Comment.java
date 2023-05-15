package com.example.Note.Model.FriendModel;

import com.example.Note.Model.ImageModel.imageComment;
import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "Comment")
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
    @JoinColumn(name="fk_user_comment")
    private User user;

    @OneToMany(mappedBy="imageCommentID", cascade = CascadeType.ALL)
    private List<imageComment> imageComment;

    public Comment(){

    }

    public Comment(int commentID, String commentTitle, String commentContent, User user, List<imageComment> imageComment) {
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

    @JsonManagedReference
    public List<imageComment> getImageComment() {
        return imageComment;
    }

    public void setImageComment(List<imageComment> imageComment) {
        this.imageComment = imageComment;
    }
}
