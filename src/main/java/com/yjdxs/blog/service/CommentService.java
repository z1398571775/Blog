package com.yjdxs.blog.service;

import java.util.List;

import com.yjdxs.blog.entity.Comment;


public interface CommentService {
	boolean saveComment(String NickName,String content,String articleID);
	List<Comment> getAllComment();
}
