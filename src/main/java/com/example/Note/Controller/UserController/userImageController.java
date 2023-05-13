package com.example.Note.Controller.UserController;

import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Model.UserModel.User;
import com.example.Note.Model.UserModel.userImage;
import com.example.Note.Service.UserService.userImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class userImageController {
    @Autowired
    userImageService userImageService;

    // return list User Image account
    @GetMapping("/userImage")
    public ResponseEntity<Response> getUserImageList(){
        return userImageService.getUserImageList();
    }

    // add an user Image
    @PostMapping("/userImage")
    public ResponseEntity<Response> addUserImage(userImage userImage, @RequestParam(value = "file") MultipartFile userImageFile){
        return userImageService.addUserImage(userImage, userImageFile);
    }

}
