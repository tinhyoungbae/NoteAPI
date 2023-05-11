package com.example.Note.Service.NoteService;

import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.Note.Repository.NoteRepository.interfaceNoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class noteService implements interfaceNoteService{
    @Autowired
    interfaceNoteRepository interfaceNoteRepository;
    @Override
    public ResponseEntity<Response> getNoteList() {
        List<Note> noteList = interfaceNoteRepository.findAll();
        if(!noteList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all Note", noteList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> getNoteByID(int nodeID) {
        Optional<Note> noteOptional = interfaceNoteRepository.findById(nodeID);
        if(noteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got a note", noteOptional.get())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "There isn't note ID = "+nodeID +" in database. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> addNote(Note note) {
        if (note != null) {
            interfaceNoteRepository.save(note);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk(), note)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new Response(Status.getStatusError(), Status.getMessageError(), "")
        );
    }

    @Override
    public ResponseEntity<Response> updateNote(Note note) {
        List<Note> noteList = interfaceNoteRepository.findAll();
        if(!noteList.isEmpty()){
            interfaceNoteRepository.save(note);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Updated", noteList)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "Can not update Note. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> deleteNote(int noteID) {
        Optional<Note> noteOptional = interfaceNoteRepository.findById(noteID);
        //getAccount();
        if(noteOptional.isPresent()){
            interfaceNoteRepository.delete(noteOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Deleted", getNoteList().getBody().getData())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), getNoteList().getBody().getData())
            );
        }
    }
}
