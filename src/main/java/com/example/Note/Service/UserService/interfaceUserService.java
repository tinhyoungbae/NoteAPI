package com.example.Note.Service.UserService;

import com.example.Note.Model.UserModel.User;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface interfaceUserService {
    public String installApplication();
    public ResponseEntity<Response> getUserList();
    public User getUserByID(int userID);
    public ResponseEntity<Response> addUser(User user);
    public ResponseEntity<Response> updateUser(User user);
    public ResponseEntity<Response> deleteUser(int userID);
}
