package com.example.Note.Repository.UserRepository;

import com.example.Note.Model.UserModel.userImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userImage")
public interface interfaceUserImageRepository extends JpaRepository<userImage, Integer> {
}
