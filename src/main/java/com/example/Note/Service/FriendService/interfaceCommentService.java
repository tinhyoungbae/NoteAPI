package com.example.Note.Service.FriendService;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;

public interface interfaceCommentService {
    public ResponseEntity<Response> getCommentList();
    public ResponseEntity<Response> getCommentByID(int commentID);
    public ResponseEntity<Response> addComment(int userID, Comment comment);
    public ResponseEntity<Response> updateComment(Comment comment);
    public ResponseEntity<Response> deleteComment(int commentID);
}
