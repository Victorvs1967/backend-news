package com.vvs.springnewsparser.job;

import java.io.IOException;

import com.vvs.springnewsparser.model.News;
import com.vvs.springnewsparser.service.NewsService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class ParceNews {
    
    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 600000)
    public void parseNewNews() {
        String url = "https://vesti.ua/vse-novosti";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.2 Safari/605.1.15")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
            log.info("Getting news...");
            Elements posts = doc.getElementsByClass("post").select("div.title").select("a");
            for (Element post: posts) {
                String title = post.text();
                String href = post.attr("href");
                if (!newsService.isExist(title)) {
                    if (title.toLowerCase().contains("погод") || href.contains("pogod")) {
                        News obj = new News();
                        obj.setTitle(title);
                        obj.setUrl(href);
                        newsService.save(obj);
                        log.info(title);
                        log.info(href);
                        log.info("--------------------------------------------");
                    }
                }
            }
        } catch (IOException e) {
            log.warning(e.getMessage());
        }
    }
}
