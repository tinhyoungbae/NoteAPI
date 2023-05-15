package com.example.Note.Service.UserService;

import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Model.UserModel.userImage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface interfaceUserImageService {
    public ResponseEntity<Response> getUserImageList();
    public ResponseEntity<byte[]> getUserImageByID(int userImageID);
    public ResponseEntity<Response> addUserImage(userImage userImage, MultipartFile userImageFile) throws IOException;
    public ResponseEntity<Response> updateUserImage(userImage userImage);
    public ResponseEntity<Response> deleteUserImage(int userImageID);
}
