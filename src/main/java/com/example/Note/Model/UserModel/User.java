package com.example.Note.Model.UserModel;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.FriendModel.Text;
import com.example.Note.Model.FriendModel.commentWithImage;
import com.example.Note.Model.FriendModel.isFriend;
import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.PaymentModel.creditCard;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")

    private int userID;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "userFullName")
    private String userFullName;


    @Column(name = "userDate")
    private String userDate;


    @Column(name = "userSex")
    private boolean userSex;


    @Column(name = "userAddress")
    private String userAddress;

    // relationship: User --> Note
    @ManyToMany
    Set<Note> userNote;

    // relationship: User --> CreditCard
    @ManyToMany
    Set<creditCard> userCreditCard;

    // relationship: User --> News
    @ManyToMany
    Set<News> userNews;

    // relationship: User --> Text
    @ManyToMany
    Set<Text> userText;

    // relationship: User1 --> Friend
    @ManyToMany
    Set<isFriend> user1IsFriend;

    // relationship: User2 --> Friend
    @ManyToMany
    Set<isFriend> user2IsFriend;

    // relationship: User --> Comment with Text
    @ManyToMany
    Set<Comment> userComment;

    // relationship: User --> Comment with Image
    @ManyToMany
    Set<commentWithImage> userCommentWithImage;

    public User(){

    }

    public User(int userID, String userPassword, String userFullName, String userDate, boolean userSex, String userAddress) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.userDate = userDate;
        this.userSex = userSex;
        this.userAddress = userAddress;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public boolean isUserSex() {
        return userSex;
    }

    public void setUserSex(boolean userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
