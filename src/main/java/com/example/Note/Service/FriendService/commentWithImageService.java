package com.example.Note.Service.FriendService;

import com.example.Note.Model.FriendModel.commentWithImage;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Note.Repository.FriendRepository.interfaceCommentWithImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class commentWithImageService implements interfaceCommentWithImageService{
    @Autowired
    interfaceCommentWithImageRepository interfaceCommentWithImageRepository;
    @Override
    public ResponseEntity<Response> getCommentWithImageList() {
        List<commentWithImage> commentWithImageList = interfaceCommentWithImageRepository.findAll();
        if(!commentWithImageList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all Comment with image", commentWithImageList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> getCommentWithImageByID(int commentWithImageID) {
        Optional<commentWithImage> commentWithImageOptional = interfaceCommentWithImageRepository.findById(commentWithImageID);
        if(commentWithImageOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got a comment with image", commentWithImageOptional.get())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "There isn't comment with image ID = "+commentWithImageID +" in database. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> addCommentWithImage(commentWithImage commentWithImage) {
        if (commentWithImage != null) {
            interfaceCommentWithImageRepository.save(commentWithImage);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk(), commentWithImage)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new Response(Status.getStatusError(), Status.getMessageError(), "")
        );
    }

    @Override
    public ResponseEntity<Response> updateCommentWithImage(commentWithImage commentWithImage) {
        List<commentWithImage> commentWithImageList = interfaceCommentWithImageRepository.findAll();
        if(!commentWithImageList.isEmpty()){
            interfaceCommentWithImageRepository.save(commentWithImage);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Updated", commentWithImage)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "Can not update comment with image. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> deleteCommentWithImage(int commentWithImageID) {
        Optional<commentWithImage> commentWithImageOptional = interfaceCommentWithImageRepository.findById(commentWithImageID);
        //getAccount();
        if(commentWithImageOptional.isPresent()){
            interfaceCommentWithImageRepository.delete(commentWithImageOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Deleted", getCommentWithImageList().getBody().getData())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), getCommentWithImageList().getBody().getData())
            );
        }
    }
}
