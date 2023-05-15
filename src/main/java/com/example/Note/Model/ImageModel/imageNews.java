package com.example.Note.Model.ImageModel;

import com.example.Note.Model.NewsModel.News;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "imageNews")
public class imageNews implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageNewsID")
    private int imageNewsID;

    @Column(name = "imageNewsName")
    private String imageNewsName;

    @Column(name = "imageNewsPath")
    private String imageNewsPath;

    @Column(name = "imageNewsSize")
    private Long imageNewsSize;

    @Column(name = "imageNewsSizeCreatedDate")
    private Timestamp imageNewsSizeCreatedDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="fk_news_image")
    private News news;

    public imageNews(){

    }

    public imageNews(int imageNewsID, String imageNewsName, String imageNewsPath, Long imageNewsSize, Timestamp imageNewsSizeCreatedDate, News news) {
        this.imageNewsID = imageNewsID;
        this.imageNewsName = imageNewsName;
        this.imageNewsPath = imageNewsPath;
        this.imageNewsSize = imageNewsSize;
        this.imageNewsSizeCreatedDate = imageNewsSizeCreatedDate;
        this.news = news;
    }

    public int getImageNewsID() {
        return imageNewsID;
    }

    public void setImageNewsID(int imageNewsID) {
        this.imageNewsID = imageNewsID;
    }

    public String getImageNewsName() {
        return imageNewsName;
    }

    public void setImageNewsName(String imageNewsName) {
        this.imageNewsName = imageNewsName;
    }

    public String getImageNewsPath() {
        return imageNewsPath;
    }

    public void setImageNewsPath(String imageNewsPath) {
        this.imageNewsPath = imageNewsPath;
    }

    public Long getImageNewsSize() {
        return imageNewsSize;
    }

    public void setImageNewsSize(Long imageNewsSize) {
        this.imageNewsSize = imageNewsSize;
    }

    public Timestamp getImageNewsSizeCreatedDate() {
        return imageNewsSizeCreatedDate;
    }

    public void setImageNewsSizeCreatedDate(Timestamp imageNewsSizeCreatedDate) {
        this.imageNewsSizeCreatedDate = imageNewsSizeCreatedDate;
    }

    @JsonBackReference
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
