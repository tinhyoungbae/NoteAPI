package com.example.Note.Controller.ImageController;

import com.example.Note.Model.ImageModel.imageComment;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.ImageService.imageCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@RestController
public class imageCommentController {
    @Autowired
    imageCommentService imageCommentService;
    @PutMapping("/imageComment/{commentID}")
    public ResponseEntity<Response> addImageComment(@PathVariable int commentID, imageComment imageComment, String imageCommentName, @RequestParam(value = "file") MultipartFile imageCommentPath, String imageCommentSize, Timestamp imageCommentCreatedDate){
        return imageCommentService.addImageComment(commentID, imageComment, imageCommentName, imageCommentPath, imageCommentSize, imageCommentCreatedDate);
    }
}
