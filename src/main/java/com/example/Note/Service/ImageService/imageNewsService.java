package com.example.Note.Service.ImageService;

import com.example.Note.Model.ImageModel.imageNews;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Repository.ImageRepository.interfaceImageNewsRepository;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Service
public class imageNewsService implements interfaceImageNewsService{
    @Autowired
    interfaceImageNewsRepository interfaceImageNewsRepository;
    @Override
    public ResponseEntity<Response> getImageNewsList() {
        return null;
    }

    @Override
    public imageNews getImageNewsByID(int imageNewsID) {
        return null;
    }

    @Override
    public ResponseEntity<Response> addImageNews(imageNews imageNews, String imageNewsName, MultipartFile imageNewsPath, String imageNewsSize, Timestamp imageNewsCreatedDate) {
        imageNews.setImageNewsName(imageNewsPath.getOriginalFilename());
        imageNews.setImageNewsPath(imageNewsPath.getName());
        imageNews.setImageNewsSize(imageNewsPath.getSize());
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        imageNews.setImageNewsSizeCreatedDate(currentTimestamp);
        interfaceImageNewsRepository.save(imageNews);
        return ResponseEntity.status(HttpStatus.OK).body(
                new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> add a file successfully", imageNews)
        );
    }

    @Override
    public ResponseEntity<Response> updateImageNews(imageNews imageNews) {
        return null;
    }

    @Override
    public ResponseEntity<Response> deleteImageNews(int imageNewsID) {
        return null;
    }
}
