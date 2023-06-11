package com.example.Note.Controller.FriendController;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.FriendService.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    commentService commentService;

    // return list comment
    @GetMapping("/comment")
    public ResponseEntity<Response> getCommentList(){
        return commentService.getCommentList();
    }

    // add a comment
    @PutMapping("/comment/{userID}")
    public ResponseEntity<Response> addComment(@PathVariable int userID, @RequestBody Comment comment){
        return commentService.addComment(userID, comment);
    }

    // find a comment
    @GetMapping("/comment/{commentID}")
    public ResponseEntity<Response> getCommentByID(@PathVariable int commentID){
        return commentService.getCommentByID(commentID);
    }

    // update a comment
    @PutMapping("/comment")
    public ResponseEntity<Response> updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    // delete a comment
    @DeleteMapping("/comment/{commentID}")
    public ResponseEntity<Response> deleteComment(@PathVariable int commentID) {
        return commentService.deleteComment(commentID);
    }
}
