package com.yjdxs.blog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.yjdxs.blog.entity.Comment;

@Mapper
public interface CommentMapper {
	@Insert(value = { "insert into comment values(#{id},#{sickName},#{content},#{createTime},#{articleID})" })
	int InsertComment(Comment comment);

}
