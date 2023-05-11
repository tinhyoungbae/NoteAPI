package com.example.Note.Model.FriendModel;

import com.example.Note.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "commentWithImage")
public class commentWithImage implements Serializable {
    // foreign key between Comment With Image and User
    // Column(name = "userID")
    // ManyToMany(mappedBy = "userCommentWithImage")
    // Set<User> commentWithImageUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentWithImageID")
    private int commentWithImageID;

    @Column(name = "commentContent")
    private String commentWithImageContent;

    @Column(name = "url")
    private String url;

    public commentWithImage(){

    }

    public commentWithImage(int commentWithImageID, String commentWithImageContent, String url) {
        this.commentWithImageID = commentWithImageID;
        this.commentWithImageContent = commentWithImageContent;
        this.url = url;
    }

    public int getCommentWithImageID() {
        return commentWithImageID;
    }

    public void setCommentWithImageID(int commentWithImageID) {
        this.commentWithImageID = commentWithImageID;
    }

    public String getCommentWithImageContent() {
        return commentWithImageContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentWithImageContent = commentWithImageContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
