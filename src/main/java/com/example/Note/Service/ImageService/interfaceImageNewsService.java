package com.example.Note.Service.ImageService;

import com.example.Note.Model.ImageModel.imageNews;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

public interface interfaceImageNewsService {
    public ResponseEntity<Response> getImageNewsList();
    public imageNews getImageNewsByID(int imageNewsID);
    public ResponseEntity<Response> addImageNews(imageNews imageNews, String imageNewsName, MultipartFile imageNewsPath, String imageNewsSize, Timestamp imageNewsCreatedDate);
    public ResponseEntity<Response> updateImageNews(imageNews imageNews);
    public ResponseEntity<Response> deleteImageNews(int imageNewsID);
}
