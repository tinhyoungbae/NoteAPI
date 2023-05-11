package com.example.Note.Service.NewsService;

import com.example.Note.Model.NewsModel.News;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Repository.NewsRepository.interfaceNewsRepository;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class newsService implements interfaceNewsService{
    @Autowired
    interfaceNewsRepository interfaceNewsRepository;

    @Override
    public ResponseEntity<Response> getNewsList() {
        List<News> newsList = interfaceNewsRepository.findAll();
        if(!newsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all News", newsList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> getNewsByID(int newsID) {
        Optional<News> newsOptional = interfaceNewsRepository.findById(newsID);
        if(newsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got a news", newsOptional.get())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "There isn't news ID = "+newsID +" in database. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> addNews(News news) {
        if (news != null) {
            interfaceNewsRepository.save(news);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk(), news)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new Response(Status.getStatusError(), Status.getMessageError(), "")
        );
    }

    @Override
    public ResponseEntity<Response> updateNews(News news) {
        List<News> newsList = interfaceNewsRepository.findAll();
        if(!newsList.isEmpty()){
            interfaceNewsRepository.save(news);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Updated", news)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "Can not update News. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> deleteNews(int newsID) {
        Optional<News> newsOptional = interfaceNewsRepository.findById(newsID);
        //getAccount();
        if(newsOptional.isPresent()){
            interfaceNewsRepository.delete(newsOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Deleted", getNewsList().getBody().getData())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), getNewsList().getBody().getData())
            );
        }
    }
}
