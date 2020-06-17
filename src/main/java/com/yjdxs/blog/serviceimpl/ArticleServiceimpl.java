package com.yjdxs.blog.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjdxs.blog.entity.Article;
import com.yjdxs.blog.mapper.ArticleMapper;
import com.yjdxs.blog.service.ArticalService;
import com.yjdxs.blog.utils.Utils;
@Service
public class ArticleServiceimpl implements ArticalService{
	@Autowired
	private ArticleMapper articleMapper;
	/**
	 * 往数据库里面添加文章
	 */
	@Override
	public int saveArtical(String title, String introduce, String content) {
		// TODO Auto-generated method stub
		Article article = new Article();
		article.setId(Utils.GetUUID());
		article.setTitle(title);
		article.setIntroduce(introduce);
		article.setContent(content);
		article.setCreatetime(Utils.gryNowTime());
		article.setModifytime(Utils.gryNowTime());
		return articleMapper.saveArticle(article);
	}
	/***
	 * 获取全部的文章
	 */
	@Override
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return  articleMapper.getAllArticleList();
	}
	@Override
	public Article getArticle(String id) {
		// TODO Auto-generated method stub
		Article article = articleMapper.getArticle(id);
		return article;
	}

}
