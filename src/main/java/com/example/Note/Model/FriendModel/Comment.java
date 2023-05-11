package com.example.Note.Model.FriendModel;

import com.example.Note.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "comment")
public class Comment implements Serializable {
    // foreign key between Comment and User
    // Column(name = "userID")
    // ManyToMany(mappedBy = "userComment")
    // Set<User> commentUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private int commentID;

    @Column(name = "commentTitle")
    private String commentTitle;

    @Column(name = "commentContent")
    private String commentContent;

    public Comment(){

    }

    public Comment(int commentID, String commentTitle, String commentContent) {
        this.commentContent = commentContent;
        this.commentID = commentID;
        this.commentContent = commentContent;
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
}
