package com.example.Note.Service.ImageService;

import com.example.Note.Model.ImageModel.imageNote;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

public interface interfaceImageNoteService {
    public ResponseEntity<Response> getImageNoteList();
    public imageNote getImageNoteByID(int imageNoteID);
    public ResponseEntity<Response> addImageNote(int noteID, imageNote imageNote, String imageNoteName, MultipartFile imageNotePath, String imageNoteSize, Timestamp imageNoteCreatedDate);
    public ResponseEntity<Response> updateImageNote(imageNote imageNote);
    public ResponseEntity<Response> deleteImageNote(int imageNoteID);
}
