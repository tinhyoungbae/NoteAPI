package com.example.Note.Repository.FriendRepository;

import com.example.Note.Model.FriendModel.isFriend;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("isFriend")
public interface interfaceIsFriendRepository extends JpaRepository<isFriend, Integer> {
}
