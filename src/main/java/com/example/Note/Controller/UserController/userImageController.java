package com.example.Note.Controller.UserController;

import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Model.UserModel.userImage;
import com.example.Note.Service.UserService.userImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class userImageController {
    @Autowired
    userImageService userImageService;

    // return list User Image account
    @GetMapping("/userImage")
    public ResponseEntity<Response> getUserImageList(){
        return userImageService.getUserImageList();
    }

    @GetMapping(value = "/userImage/{userImageID}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getUserImageByID(@PathVariable int userImageID){
        return userImageService.getUserImageByID(userImageID);
    }

    // add an user Image
    @PutMapping("/userImage/{userID}")
    public ResponseEntity<Response> addUserImage(@PathVariable int userID, userImage userImage, @RequestParam(value = "file") MultipartFile userImageFile) throws IOException {
        return userImageService.addUserImage(userID, userImage, userImageFile);
    }

}
