package com.example.Note.Controller.NoteController;

import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Note.Service.NoteService.noteService;

@RestController
public class NoteController {
    @Autowired
    noteService noteService;

    // return list note
    @GetMapping("/note")
    public ResponseEntity<Response> getNoteList(){
        return noteService.getNoteList();
    }

    // add a note
    @PostMapping("/note")
    public ResponseEntity<Response> addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

    // find a note
    @GetMapping("/note/{noteID}")
    public ResponseEntity<Response> getNoteByID(@PathVariable int noteID){
        return noteService.getNoteByID(noteID);
    }

    // update a note
    @PutMapping("/note")
    public ResponseEntity<Response> updateNote(@RequestBody Note note){
        return noteService.updateNote(note);
    }

    // delete a note
    @DeleteMapping("/note/{noteID}")
    public ResponseEntity<Response> deleteNote(@PathVariable int noteID) {
        return noteService.deleteNote(noteID);
    }
}
