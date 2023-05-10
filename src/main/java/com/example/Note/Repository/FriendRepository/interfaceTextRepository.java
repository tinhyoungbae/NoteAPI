package com.example.Note.Repository.FriendRepository;

import com.example.Note.Model.FriendModel.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("text")
public interface interfaceTextRepository extends JpaRepository<Text, Integer> {
}
