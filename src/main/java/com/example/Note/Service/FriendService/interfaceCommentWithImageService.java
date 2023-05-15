package com.example.Note.Service.FriendService;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.FriendModel.commentWithImage;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface interfaceCommentWithImageService {
    public ResponseEntity<Response> getCommentWithImageList();
    public ResponseEntity<Response> getCommentWithImageByID(int commentWithImageID);
    public ResponseEntity<Response> addCommentWithImage(String commentWithImageContent, MultipartFile url);
    public ResponseEntity<Response> updateCommentWithImage(commentWithImage commentWithImage);
    public ResponseEntity<Response> deleteCommentWithImage(int commentWithImageID);
}
