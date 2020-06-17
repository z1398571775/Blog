package com.yjdxs.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.yjdxs.blog.entity.Article;


@Mapper
public interface ArticleMapper {
	@Insert("insert into article values(#{id},#{title},#{introduce},#{content},#{createtime},#{modifytime})")
	int saveArticle(Article article);
	
	@Select("select * from article")
	List<Article> getAllArticleList();
	
	@Select("select * from article where id = #{id}")
	Article getArticle(String id);
}
