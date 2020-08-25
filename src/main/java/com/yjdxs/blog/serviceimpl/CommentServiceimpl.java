package com.yjdxs.blog.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjdxs.blog.entity.Comment;
import com.yjdxs.blog.mapper.CommentMapper;
import com.yjdxs.blog.service.CommentService;
import com.yjdxs.blog.utils.Utils;
@Service
public class CommentServiceimpl implements CommentService{
@Autowired
	private CommentMapper commentMapper;
	@Override
	public boolean saveComment(String NickName, String content, String articleID) {
		// TODO Auto-generated method stub
		Comment comment = new Comment(Utils.GetUUID(), NickName, content, Utils.gryNowTime(), articleID);
		return commentMapper.InsertComment(comment) > 0 ;
	}

	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
