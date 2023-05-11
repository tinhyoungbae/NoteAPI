package com.example.Note.Controller.UserController;

import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Model.UserModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Note.Service.UserService.userService;

@RestController
public class userController {
    @Autowired
    userService userService;

    @GetMapping("/")
    public String ins(){
        return "hello";
    }

    // return list User account
    @GetMapping("/user")
    public ResponseEntity<Response> getUserList(){
        return userService.getUserList();
    }

    // add an user
    @PostMapping("/user")
    public ResponseEntity<Response> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    // find an user
    @GetMapping("/user/{userID}")
    public User getUserByID(@PathVariable int userID){
        return userService.getUserByID(userID);
    }

    // update an user
    @PutMapping("/user")
    public ResponseEntity<Response> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    // delete an user
    @DeleteMapping("/user/{userID}")
    public ResponseEntity<Response> deleteUser(@PathVariable int userID) {
        return userService.deleteUser(userID);
    }
}
