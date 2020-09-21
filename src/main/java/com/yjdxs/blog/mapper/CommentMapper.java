package com.yjdxs.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yjdxs.blog.entity.Comment;

@Mapper
public interface CommentMapper {
	@Insert(value = { "insert into comment values(#{id},#{sickName},#{content},#{createTime},#{articleID})" })
	int InsertComment(Comment comment);
	/**
	 * 根据页面传过来的页数，获取对应页数的评论
	 * @param preNum
	 * @param lastNum
	 * @return
	 */
	@Select("select id,sickName,convert(content using utf8) content,createTime,articleID from comment where articleID = #{articleID} order by createTime desc limit #{preNum},#{lastNum} ")
	List<Comment> SelectComment(int preNum,int lastNum,String articleID);
	/**
	 * 获取全部的评论
	 * @return
	 */
	@Select("select count(*) from comment where articleID = #{articleID}")
	String SelectAllComment(String articleID);
}
