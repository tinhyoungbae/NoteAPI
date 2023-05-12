package com.example.Note.Model.NoteModel;

import com.example.Note.Model.UserModel.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
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
    @JoinColumn(name="note_id")
    private User user;

    public Note(){

    }

    public Note(int noteID, String noteTitle, String noteContent, User user) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.user = user;
    }

    public int getNoteID() {
        return noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
