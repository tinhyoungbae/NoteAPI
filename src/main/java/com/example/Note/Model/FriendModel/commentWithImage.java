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
    @Column(name = "userID")
    @ManyToMany(mappedBy = "userCommentWithImage")
    Set<User> commentWithImageUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentWithImageID")
    private int commentWithImageID;

    @Column(name = "url")
    private String url;

    public commentWithImage(){

    }

    public commentWithImage(Set<User> commentWithImageUser, int commentWithImageID, String url) {
        this.commentWithImageUser = commentWithImageUser;
        this.commentWithImageID = commentWithImageID;
        this.url = url;
    }

    public Set<User> getCommentWithImageUser() {
        return commentWithImageUser;
    }

    public void setCommentWithImageUser(Set<User> commentWithImageUser) {
        this.commentWithImageUser = commentWithImageUser;
    }

    public int getCommentWithImageID() {
        return commentWithImageID;
    }

    public void setCommentWithImageID(int commentWithImageID) {
        this.commentWithImageID = commentWithImageID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
