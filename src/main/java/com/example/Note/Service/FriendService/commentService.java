package com.example.Note.Service.FriendService;

import com.example.Note.Model.FriendModel.Comment;
import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Note.Repository.FriendRepository.interfaceCommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class commentService implements interfaceCommentService{
    @Autowired
    interfaceCommentRepository interfaceCommentRepository;
    @Override
    public ResponseEntity<Response> getCommentList() {
        List<Comment> commentList = interfaceCommentRepository.findAll();
        if(!commentList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all Comment", commentList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> getCommentByID(int commentID) {
        Optional<Comment> commentOptional = interfaceCommentRepository.findById(commentID);
        if(commentOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got a comment", commentOptional.get())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "There isn't comment ID = "+commentID +" in database. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> addComment(Comment comment) {
        if (comment != null) {
            interfaceCommentRepository.save(comment);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk(), comment)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new Response(Status.getStatusError(), Status.getMessageError(), "")
        );
    }

    @Override
    public ResponseEntity<Response> updateComment(Comment comment) {
        List<Comment> commentList = interfaceCommentRepository.findAll();
        if(!commentList.isEmpty()){
            interfaceCommentRepository.save(comment);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Updated", comment)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "Can not update comment. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> deleteComment(int commentID) {
        Optional<Comment> commentOptional = interfaceCommentRepository.findById(commentID);
        //getAccount();
        if(commentOptional.isPresent()){
            interfaceCommentRepository.delete(commentOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Deleted", getCommentList().getBody().getData())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), getCommentList().getBody().getData())
            );
        }
    }
}
