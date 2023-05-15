package com.example.Note.Model.ImageModel;

import com.example.Note.Model.NoteModel.Note;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "imageNote")
public class imageNote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageNoteID")
    private int imageNoteID;

    @Column(name = "imageNoteName")
    private String imageNoteName;

    @Column(name = "imageNotePath")
    private String imageNotePath;

    @Column(name = "imageNoteSize")
    private Long imageNoteSize;

    @Column(name = "imageNoteSizeCreatedDate")
    private Timestamp imageNoteSizeCreatedDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="fk_note_image")
    private Note note;

    public imageNote(){

    }

    public imageNote(int imageNoteID, String imageNoteName, String imageNotePath, Long imageNoteSize, Timestamp imageNoteSizeCreatedDate, Note note) {
        this.imageNoteID = imageNoteID;
        this.imageNoteName = imageNoteName;
        this.imageNotePath = imageNotePath;
        this.imageNoteSize = imageNoteSize;
        this.imageNoteSizeCreatedDate = imageNoteSizeCreatedDate;
        this.note = note;
    }

    public int getImageNoteID() {
        return imageNoteID;
    }

    public void setImageNoteID(int imageNoteID) {
        this.imageNoteID = imageNoteID;
    }

    public String getImageNoteName() {
        return imageNoteName;
    }

    public void setImageNoteName(String imageNoteName) {
        this.imageNoteName = imageNoteName;
    }

    public String getImageNotePath() {
        return imageNotePath;
    }

    public void setImageNotePath(String imageNotePath) {
        this.imageNotePath = imageNotePath;
    }

    public Long getImageNoteSize() {
        return imageNoteSize;
    }

    public void setImageNoteSize(Long imageNoteSize) {
        this.imageNoteSize = imageNoteSize;
    }

    public Timestamp getImageNoteSizeCreatedDate() {
        return imageNoteSizeCreatedDate;
    }

    public void setImageNoteSizeCreatedDate(Timestamp imageNoteSizeCreatedDate) {
        this.imageNoteSizeCreatedDate = imageNoteSizeCreatedDate;
    }

    @JsonBackReference
    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
