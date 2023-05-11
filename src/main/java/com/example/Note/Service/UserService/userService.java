package com.example.Note.Service.UserService;

import com.example.Note.Model.UserModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Note.Repository.UserRepository.interfaceUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.Note.Status.Status;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService implements interfaceUserService{
    @Autowired
    private interfaceUserRepository interfaceUserRepository;

    @Override
    public String installApplication() {
        return "Install Successfully";
    }

    @Override
    public ResponseEntity<Response> getUserList() {
        List<User> userList = interfaceUserRepository.findAll();
        if(!userList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all User", userList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public User getUserByID(int userID) {
        Optional<User> userOptional = interfaceUserRepository.findById(userID);
        return userOptional.get();
    }

    @Override
    public ResponseEntity<Response> addUser(User user) {
        if (user != null) {
            interfaceUserRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk(), user)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new Response(Status.getStatusError(), Status.getMessageError(), "")
        );
    }

    @Override
    public ResponseEntity<Response> updateUser(User user) {
        List<User> userList = interfaceUserRepository.findAll();
        if(!userList.isEmpty()){
            interfaceUserRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Updated", userList)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "Can not update User. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> deleteUser(int userID) {
        Optional<User> userOptional = interfaceUserRepository.findById(userID);
        //getAccount();
        if(userOptional.isPresent()){
            interfaceUserRepository.delete(userOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Deleted", getUserList().getBody().getData())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), getUserList().getBody().getData())
            );
        }
    }
}
