package com.example.Note.Service.NoteService;

import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;

public interface interfaceNoteService {
    public ResponseEntity<Response> getNoteList();
    public ResponseEntity<Response> getNoteByID(int nodeID);
    public ResponseEntity<Response> addNote(Note note);
    public ResponseEntity<Response> updateNote(Note note);
    public ResponseEntity<Response> deleteNote(int noteID);
}
