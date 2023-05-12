package com.example.Note.Model.UserModel;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.FriendModel.Text;
import com.example.Note.Model.FriendModel.commentWithImage;
import com.example.Note.Model.FriendModel.isFriend;
import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.PaymentModel.creditCard;
import com.example.Note.Model.Price;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
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
    private String userSex;


    @Column(name = "userAddress")
    private String userAddress;



    // relationship: User --> Note
    @OneToMany(mappedBy="noteID", cascade = CascadeType.ALL)
    private List<Note> userNote;

    // relationship: User --> CreditCard
    @OneToMany(mappedBy="creditCardID", cascade = CascadeType.ALL)
    private List<creditCard> userCreditCard;

    // relationship: User --> News
    @OneToMany(mappedBy="newsID", cascade = CascadeType.ALL)
    private List<News> userNews;

    // relationship: User --> Text
    @OneToMany(mappedBy="textID", cascade = CascadeType.ALL)
    private List<Text> userText;

    // relationship: User --> Comment
    @OneToMany(mappedBy="commentID", cascade = CascadeType.ALL)
    private List<Comment> userComment;

    // relationship: User --> Comment with image
    @OneToMany(mappedBy="commentWithImageID", cascade = CascadeType.ALL)
    private List<commentWithImage> userCommentWithImage;



    public User(){

    }

    public User(int userID, String userPassword, String userFullName, String userDate, String userSex, String userAddress, List<Note> userNote, List<creditCard> userCreditCard, List<News> userNews, List<Text> userText, List<Comment> userComment, List<commentWithImage> userCommentWithImage) {
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
        this.userCommentWithImage = userCommentWithImage;
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

    @JsonManagedReference
    public List<commentWithImage> getUserCommentWithImage() {
        return userCommentWithImage;
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

    public void setUserCommentWithImage(List<commentWithImage> userCommentWithImage) {
        this.userCommentWithImage = userCommentWithImage;
    }
}
