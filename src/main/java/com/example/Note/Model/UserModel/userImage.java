package com.example.Note.Model.UserModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "userImage")
public class userImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userImageID")
    private int userImageID;

    @Column(name = "userImageFile")
    private String userImageFile;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userID")
    private User user;

    public userImage(){

    }

    public userImage(int userImageID, String userImageFile, User user) {
        this.userImageID = userImageID;
        this.userImageFile = userImageFile;
        this.user = user;
    }

    public int getUserImageID() {
        return userImageID;
    }

    public void setUserImageID(int userImageID) {
        this.userImageID = userImageID;
    }

    public String getUserImageFile() {
        return userImageFile;
    }

    public void setUserImageFile(String userImageFile) {
        this.userImageFile = userImageFile;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
