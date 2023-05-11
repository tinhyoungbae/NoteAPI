package com.example.Note.Controller.FriendController;

import com.example.Note.Model.FriendModel.commentWithImage;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Note.Service.FriendService.commentWithImageService;

@RestController
public class commentWithImageController {
    @Autowired
    commentWithImageService commentWithImageService;

    // return list comment with image
    @GetMapping("/commentWithImage")
    public ResponseEntity<Response> getCommentWithImageList(){
        return commentWithImageService.getCommentWithImageList();
    }

    // add a comment with image
    @PostMapping("/commentWithImage")
    public ResponseEntity<Response> addCommentWithImage(@RequestBody commentWithImage commentWithImage){
        return commentWithImageService.addCommentWithImage(commentWithImage);
    }

    // find a comment with image
    @GetMapping("/commentWithImage/{commentWithImageID}")
    public ResponseEntity<Response> getCommentWithImageByID(@PathVariable int commentWithImageID){
        return commentWithImageService.getCommentWithImageByID(commentWithImageID);
    }

    // update a comment with image
    @PutMapping("/commentWithImage")
    public ResponseEntity<Response> updateCommentWithImage(@RequestBody commentWithImage commentWithImage){
        return commentWithImageService.updateCommentWithImage(commentWithImage);
    }

    // delete a comment with image
    @DeleteMapping("/commentWithImage/{commentWithImageID}")
    public ResponseEntity<Response> deleteCommentWithImage(@PathVariable int commentWithImageID) {
        return commentWithImageService.deleteCommentWithImage(commentWithImageID);
    }
}
