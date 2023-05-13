package com.example.Note.Service.UserService;

import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Model.UserModel.User;
import com.example.Note.Model.UserModel.userImage;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Note.Repository.UserRepository.interfaceUserImageRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class userImageService implements interfaceUserImageService{
    @Autowired
    interfaceUserImageRepository interfaceUserImageRepository;
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
    public userImage getUserImageByID(int userImageID) {
        return null;
    }

    @Override
    public ResponseEntity<Response> addUserImage(userImage userImage, MultipartFile userImageFile) {
        /*
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            p.setImage(file.getOriginalFilename());
            //p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
        //p.setImage(file.getOriginalFilename());
        userImage.setUserImageFile(userImageFile.getOriginalFilename());
        interfaceUserImageRepository.save(userImage);
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
