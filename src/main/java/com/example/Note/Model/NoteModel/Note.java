package com.example.Note.Model.NoteModel;

import com.example.Note.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "note")
public class Note implements Serializable {
    // foreign key between Note and User
    // Column(name = "userID")
    // ManyToMany(mappedBy = "userNote")
    //Set<User> noteUser;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noteID")
    private int noteID;

    @Column(name = "noteTitle")
    private String noteTitle;

    @Column(name = "noteContent")
    private String noteContent;

    public Note(){

    }

    public Note(int noteID, String noteTitle, String noteContent) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
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
}
