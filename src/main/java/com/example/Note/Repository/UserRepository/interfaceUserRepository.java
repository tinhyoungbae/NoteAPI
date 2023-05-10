package com.example.Note.Repository.UserRepository;

import com.example.Note.Model.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("user")
public interface interfaceUserRepository extends JpaRepository<User, Integer> {
}
