package com.yjdxs.blog.serviceimpl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
public class ArticleServiceimpl implements ArticalService {
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
		article.setCreatetime(Utils.getNowTime());
		article.setModifytime(Utils.getNowTime());
		return articleMapper.saveArticle(article);
	}

	/***
	 * 获取全部的文章
	 */
	@Override
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return articleMapper.getAllArticleList();
	}

	@Override
	public Article getArticle(String id) {
		// TODO Auto-generated method stub
		Article article = articleMapper.getArticle(id);
		return article;
	}

	/***
	 * 将图片转化为二进制数据保存在数据库中
	 */
	@Override
	public void saveImage(File file) {
		// TODO Auto-generated method stub
		// 将文件转化为二进制数组
		byte[] data = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			int len;
			byte[] buffer = new byte[1024];
			while ((len = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}

			data = baos.toByteArray();
			fis.close();
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(data != null) {
			articleMapper.saveImage(file.getName(), data, Utils.getNowTime());
		}
	}

}
