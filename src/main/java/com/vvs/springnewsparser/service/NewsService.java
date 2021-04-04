package com.vvs.springnewsparser.service;

import java.util.List;

import com.vvs.springnewsparser.model.News;

public interface NewsService {
    
    public void save(News news);
    public boolean isExist(String newsTitle);
    public List<News> getAllNews();
}
