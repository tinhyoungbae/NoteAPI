package com.example.Note.Service.NewsService;

import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;

public interface interfaceNewsService {
    public ResponseEntity<Response> getNewsList();
    public ResponseEntity<Response> getNewsByID(int newsID);
    public ResponseEntity<Response> addNews(News news);
    public ResponseEntity<Response> updateNews(News news);
    public ResponseEntity<Response> deleteNews(int newsID);
}
