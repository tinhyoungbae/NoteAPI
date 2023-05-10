package com.example.Note.Repository.FriendRepository;

import com.example.Note.Model.FriendModel.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("comment")
public interface interfaceCommentRepository extends JpaRepository<Comment, Integer> {
}
