package com.example.Note.Model.UserModel;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.FriendModel.Text;
import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.PaymentModel.creditCard;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "userID")
    private int userID;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "userFullName")
    private String userFullName;


    @Column(name = "userDate")
    private String userDate;


    @Column(name = "userSex")
    private String userSex;


    @Column(name = "userAddress")
    private String userAddress;



    // relationship: User --> Note
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> userNote = new ArrayList<>();

    // relationship: User --> CreditCard
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<creditCard> userCreditCard = new ArrayList<>();

    // relationship: User --> News
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<News> userNews = new ArrayList<>();

    // relationship: User --> Text
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Text> userText = new ArrayList<>();

    // relationship: User --> Comment
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> userComment = new ArrayList<>();

    // relationship: User --> Comment with image file
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<userImage> userImage = new ArrayList<>();


    public User(){

    }

    public User(int userID, String userPassword, String userFullName, String userDate, String userSex, String userAddress, List<Note> userNote, List<creditCard> userCreditCard, List<News> userNews, List<Text> userText, List<Comment> userComment, List<com.example.Note.Model.UserModel.userImage> userImage) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.userDate = userDate;
        this.userSex = userSex;
        this.userAddress = userAddress;
        this.userNote = userNote;
        this.userCreditCard = userCreditCard;
        this.userNews = userNews;
        this.userText = userText;
        this.userComment = userComment;
        this.userImage = userImage;
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


    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSex() {
        return userSex;
    }

    @JsonManagedReference
    public List<Note> getUserNote() {
        return userNote;
    }

    @JsonManagedReference
    public List<creditCard> getUserCreditCard() {
        return userCreditCard;
    }

    @JsonManagedReference
    public List<News> getUserNews() {
        return userNews;
    }

    @JsonManagedReference
    public List<Text> getUserText() {
        return userText;
    }

    @JsonManagedReference
    public List<Comment> getUserComment() {
        return userComment;
    }

    public void setUserNote(List<Note> userNote) {
        this.userNote = userNote;
    }

    public void setUserCreditCard(List<creditCard> userCreditCard) {
        this.userCreditCard = userCreditCard;
    }

    public void setUserNews(List<News> userNews) {
        this.userNews = userNews;
    }

    public void setUserText(List<Text> userText) {
        this.userText = userText;
    }

    public void setUserComment(List<Comment> userComment) {
        this.userComment = userComment;
    }


    @JsonManagedReference
    public List<userImage> getUserImage() {
        return userImage;
    }

    public void setUserImage(List<userImage> userImage) {
        this.userImage = userImage;
    }
}
