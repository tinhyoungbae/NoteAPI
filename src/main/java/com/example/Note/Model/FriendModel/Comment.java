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
    @Column(name = "userID")
    @ManyToMany(mappedBy = "userComment")
    Set<User> commentUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private int commentID;

    @Column(name = "commentContent")
    private String commentContent;

    public Comment(){

    }

    public Comment(Set<User> commentUser, int commentID, String commentContent) {
        this.commentUser = commentUser;
        this.commentID = commentID;
        this.commentContent = commentContent;
    }

    public Set<User> getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(Set<User> commentUser) {
        this.commentUser = commentUser;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
