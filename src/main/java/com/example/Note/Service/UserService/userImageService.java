package com.example.Note.Service.UserService;

import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Model.UserModel.userImage;
import com.example.Note.Repository.UserRepository.interfaceUserImageRepository;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class userImageService implements interfaceUserImageService{
    @Autowired
    interfaceUserImageRepository interfaceUserImageRepository;

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
    @Override
    public ResponseEntity<Response> getUserImageList() {
        List<userImage> userImageList = interfaceUserImageRepository.findAll();
        if(!userImageList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all User Image", userImageList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public ResponseEntity<byte[]> getUserImageByID(@PathVariable int userImageID) {;
            try {
                HttpHeaders headers = new HttpHeaders();
                Optional<userImage> userImage = interfaceUserImageRepository.findById(userImageID);
                ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(
                        userImage.get().getUserImageFile().getBytes(), headers, HttpStatus.OK);
                return responseEntity;
            }catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
    }

    @Override
    public ResponseEntity<Response> addUserImage(userImage userImage, MultipartFile userImageFile) throws IOException {
        String filePath = Paths.get(uploadDirectory, userImageFile.getOriginalFilename()).toString();
        userImage.setUserImageFile(filePath);
        interfaceUserImageRepository.save(userImage);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
        stream.write(userImageFile.getBytes());
        stream.close();
        return ResponseEntity.status(HttpStatus.OK).body(
                new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> add a file successfully", userImage)
        );
    }

    @Override
    public ResponseEntity<Response> updateUserImage(userImage userImage) {
        return null;
    }

    @Override
    public ResponseEntity<Response> deleteUserImage(int userImageID) {
        return null;
    }
}
