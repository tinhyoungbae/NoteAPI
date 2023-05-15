package com.example.Note.Model.ImageModel;

import com.example.Note.Model.FriendModel.Comment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "imageComment")
public class imageComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageCommentID")
    private int imageCommentID;

    @Column(name = "imageCommentName")
    private String imageCommentName;

    @Column(name = "imageCommentPath")
    private String imageCommentPath;

    @Column(name = "imageCommentSize")
    private Long imageCommentSize;

    @Column(name = "imageCommentSizeCreatedDate")
    private Timestamp imageCommentSizeCreatedDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="fk_comment_image")
    private Comment comment;

    public imageComment(){

    }

    public imageComment(int imageCommentID, String imageCommentName, String imageCommentPath, Long imageCommentSize, Timestamp imageCommentSizeCreatedDate, Comment comment) {
        this.imageCommentID = imageCommentID;
        this.imageCommentName = imageCommentName;
        this.imageCommentPath = imageCommentPath;
        this.imageCommentSize = imageCommentSize;
        this.imageCommentSizeCreatedDate = imageCommentSizeCreatedDate;
        this.comment = comment;
    }

    public void setImageCommentID(int imageCommentID) {
        this.imageCommentID = imageCommentID;
    }

    public String getImageCommentName() {
        return imageCommentName;
    }

    public void setImageCommentName(String imageCommentName) {
        this.imageCommentName = imageCommentName;
    }

    public String getImageCommentPath() {
        return imageCommentPath;
    }

    public void setImageCommentPath(String imageCommentPath) {
        this.imageCommentPath = imageCommentPath;
    }

    public void setImageCommentSize(Long imageCommentSize) {
        this.imageCommentSize = imageCommentSize;
    }

    public void setImageCommentSizeCreatedDate(Timestamp imageCommentSizeCreatedDate) {
        this.imageCommentSizeCreatedDate = imageCommentSizeCreatedDate;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int getImageCommentID() {
        return imageCommentID;
    }

    public String getUserImageFile() {
        return imageCommentName;
    }

    public String getUserImagePath() {
        return imageCommentPath;
    }

    public Long getImageCommentSize() {
        return imageCommentSize;
    }

    public Timestamp getImageCommentSizeCreatedDate() {
        return imageCommentSizeCreatedDate;
    }

    @JsonBackReference
    public Comment getComment() {
        return comment;
    }
}
