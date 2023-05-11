package com.example.Note.Service.FriendService;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.FriendModel.commentWithImage;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;

public interface interfaceCommentWithImageService {
    public ResponseEntity<Response> getCommentWithImageList();
    public ResponseEntity<Response> getCommentWithImageByID(int commentWithImageID);
    public ResponseEntity<Response> addCommentWithImage(commentWithImage commentWithImage);
    public ResponseEntity<Response> updateCommentWithImage(commentWithImage commentWithImage);
    public ResponseEntity<Response> deleteCommentWithImage(int commentWithImageID);
}
