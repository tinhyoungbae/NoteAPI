package com.example.Note.Repository.NoteRepository;

import com.example.Note.Model.NoteModel.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("note")
public interface interfaceNoteRepository extends JpaRepository<Note, Integer> {
}
