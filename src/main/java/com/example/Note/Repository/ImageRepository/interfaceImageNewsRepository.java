package com.example.Note.Repository.ImageRepository;

import com.example.Note.Model.ImageModel.imageNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface interfaceImageNewsRepository extends JpaRepository<imageNews, Integer> {
}
