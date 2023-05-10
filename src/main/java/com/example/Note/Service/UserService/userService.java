package com.example.Note.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.Note.Repository.UserRepository.interfaceUserRepository;

public class userService implements interfaceUserService{
    @Autowired
    private interfaceUserRepository interfaceUserRepository;

    @Override
    public String installApplication() {
        return "Install Successfully";
    }
}
