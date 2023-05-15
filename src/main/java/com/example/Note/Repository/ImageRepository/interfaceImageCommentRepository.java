package com.example.Note.Repository.ImageRepository;

import com.example.Note.Model.ImageModel.imageComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface interfaceImageCommentRepository extends JpaRepository<imageComment, Integer> {
}
