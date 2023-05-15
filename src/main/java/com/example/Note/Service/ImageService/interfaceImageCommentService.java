package com.example.Note.Service.ImageService;

import com.example.Note.Model.ImageModel.imageComment;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

public interface interfaceImageCommentService {
    public ResponseEntity<Response> getImageCommentList();
    public imageComment getImageCommentByID(int imageCommentID);
    public ResponseEntity<Response> addImageComment(imageComment imageComment, String imageCommentName, MultipartFile imageCommentPath, String imageCommentSize, Timestamp imageCommentCreatedDate);
    public ResponseEntity<Response> updateImageComment(imageComment imageComment);
    public ResponseEntity<Response> deleteImageComment(int imageCommentID);
}
