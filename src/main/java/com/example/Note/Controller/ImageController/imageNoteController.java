package com.example.Note.Controller.ImageController;

import com.example.Note.Model.ImageModel.imageNote;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.ImageService.imageNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@RestController
public class imageNoteController {
    @Autowired
    imageNoteService imageNoteService;
    @PostMapping("/imageNote")
    public ResponseEntity<Response> imageNoteNews(imageNote imageNote, String imageNoteName, @RequestParam(value = "file") MultipartFile imageNotePath, String imageNoteSize, Timestamp imageNoteCreatedDate){
        return imageNoteService.addImageNote(imageNote, imageNoteName, imageNotePath, imageNoteSize, imageNoteCreatedDate);
    }
}
