package com.example.Note.Model.NoteModel;

import com.example.Note.Model.ImageModel.imageNote;
import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "note")
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noteID")
    private int noteID;

    @Column(name = "noteTitle")
    private String noteTitle;

    @Column(name = "noteContent")
    private String noteContent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userID")
    private User user;

    @OneToMany(mappedBy="imageNoteID", cascade = CascadeType.ALL)
    private List<imageNote> imageNote;

    public Note(){

    }

    public Note(int noteID, String noteTitle, String noteContent, User user, List<com.example.Note.Model.ImageModel.imageNote> imageNote) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.user = user;
        this.imageNote = imageNote;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonManagedReference
    public List<imageNote> getImageNote() {
        return imageNote;
    }

    public void setImageNote(List<imageNote> imageNote) {
        this.imageNote = imageNote;
    }
}