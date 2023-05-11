package com.example.Note.Controller.NewsController;

import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.NoteModel.Note;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Note.Service.NewsService.newsService;

@RestController
public class NewsController {
    @Autowired
    newsService newsService;

    // return list news
    @GetMapping("/news")
    public ResponseEntity<Response> getNewsList(){
        return newsService.getNewsList();
    }

    // add a news
    @PostMapping("/news")
    public ResponseEntity<Response> addNews(@RequestBody News news){
        return newsService.addNews(news);
    }

    // find a news
    @GetMapping("/news/{newsID}")
    public ResponseEntity<Response> getNewsByID(@PathVariable int newsID){
        return newsService.getNewsByID(newsID);
    }

    // update a news
    @PutMapping("/news")
    public ResponseEntity<Response> updateNews(@RequestBody News news){
        return newsService.updateNews(news);
    }

    // delete a news
    @DeleteMapping("/news/{newsID}")
    public ResponseEntity<Response> deleteNews(@PathVariable int newsID) {
        return newsService.deleteNews(newsID);
    }
}
