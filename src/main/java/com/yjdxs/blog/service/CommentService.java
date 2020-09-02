package com.yjdxs.blog.service;

import java.util.List;

import com.yjdxs.blog.entity.Comment;


public interface CommentService {
	/**
	 * 保存评论
	 * @param NickName
	 * @param content
	 * @param articleID
	 * @return
	 */
	boolean saveComment(String NickName,String content,String articleID);
	/**
	 * 获取页数对应的评论
	 * @param currentNum
	 * @param articleID
	 * @return
	 */
	List<Comment> getComment(int currentNum,String articleID);
	
	/**
	 * 获取当前文章下显示分页的页数
	 * @param articleID
	 * @return
	 */
	int getAllComment(String articleID);
}
