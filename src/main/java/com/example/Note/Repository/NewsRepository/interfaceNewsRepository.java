package com.example.Note.Repository.NewsRepository;

import com.example.Note.Model.NewsModel.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("news")
public interface interfaceNewsRepository extends JpaRepository<News, Integer> {
}
