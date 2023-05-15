package com.example.Note.Controller.ImageController;

import com.example.Note.Model.ImageModel.imageNews;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.ImageService.imageNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@RestController
public class imageNewsController {
    @Autowired
    imageNewsService imageNewsService;
    @PostMapping("/imageNews")
    public ResponseEntity<Response> addImageNews(imageNews imageNews, String imageNewsName, @RequestParam(value = "file") MultipartFile imageNewsPath, String imageNewsSize, Timestamp imageNewsCreatedDate){
        return imageNewsService.addImageNews(imageNews, imageNewsName, imageNewsPath, imageNewsSize, imageNewsCreatedDate);
    }
}
