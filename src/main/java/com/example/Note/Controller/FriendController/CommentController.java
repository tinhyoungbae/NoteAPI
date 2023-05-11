package com.example.Note.Controller.FriendController;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.NewsService.newsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Note.Service.FriendService.commentService;

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
    @PostMapping("/comment")
    public ResponseEntity<Response> addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
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
