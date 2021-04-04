package com.vvs.springnewsparser.api;

import java.util.List;

import com.vvs.springnewsparser.model.News;
import com.vvs.springnewsparser.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;
    
    @GetMapping(value="/news", produces = "application/json;charset=UTF-8")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
