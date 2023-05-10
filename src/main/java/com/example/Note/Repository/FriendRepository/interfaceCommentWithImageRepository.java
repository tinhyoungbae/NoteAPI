package com.example.Note.Repository.FriendRepository;

import com.example.Note.Model.FriendModel.commentWithImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("commentWithImage")
public interface interfaceCommentWithImageRepository extends JpaRepository<commentWithImage, Integer> {
}
