package com.example.Note.Repository.ImageRepository;

import com.example.Note.Model.ImageModel.imageNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface interfaceImageNoteRepository extends JpaRepository<imageNote, Integer> {
}
