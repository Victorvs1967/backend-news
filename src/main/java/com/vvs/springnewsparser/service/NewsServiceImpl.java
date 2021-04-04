package com.vvs.springnewsparser.service;

import java.util.List;

import com.vvs.springnewsparser.model.News;
import com.vvs.springnewsparser.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> news = newsRepository.findAll();
        for (News n: news) {
            if (n.getTitle().equals(newsTitle)) return true;
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
    
}
