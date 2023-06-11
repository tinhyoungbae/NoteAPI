package com.example.Note.Service.ImageService;

import com.example.Note.Model.ImageModel.imageNote;
import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Repository.ImageRepository.interfaceImageNoteRepository;
import com.example.Note.Repository.NoteRepository.interfaceNoteRepository;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Service
public class imageNoteService implements interfaceImageNoteService{
    @Autowired
    interfaceImageNoteRepository interfaceImageNoteRepository;
    @Autowired
    interfaceNoteRepository interfaceNoteRepository;
    @Override
    public ResponseEntity<Response> getImageNoteList() {
        return null;
    }

    @Override
    public imageNote getImageNoteByID(int imageNoteID) {
        return null;
    }

    @Override
    public ResponseEntity<Response> addImageNote(int nodeID, imageNote imageNote, String imageNoteName, MultipartFile imageNotePath, String imageNoteSize, Timestamp imageNoteCreatedDate) {
        Note note = interfaceNoteRepository.findById(nodeID).get();
        imageNote.setImageNoteName(imageNotePath.getOriginalFilename());
        imageNote.setImageNotePath(imageNotePath.getName());
        imageNote.setImageNoteSize(imageNotePath.getSize());
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        imageNote.setImageNoteSizeCreatedDate(currentTimestamp);
        imageNote.setNote(note);
        interfaceImageNoteRepository.save(imageNote);
        return ResponseEntity.status(HttpStatus.OK).body(
                new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> add a file successfully", imageNote)
        );
    }

    @Override
    public ResponseEntity<Response> updateImageNote(imageNote imageNote) {
        return null;
    }

    @Override
    public ResponseEntity<Response> deleteImageNote(int imageNoteID) {
        return null;
    }
}
