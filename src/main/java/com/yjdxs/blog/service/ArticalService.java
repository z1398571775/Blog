package com.yjdxs.blog.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjdxs.blog.entity.Article;

public interface ArticalService {
	int saveArtical(String title,String introduce,String content);
	List<Article> getAllArticle();
	Article getArticle(String id);
}
