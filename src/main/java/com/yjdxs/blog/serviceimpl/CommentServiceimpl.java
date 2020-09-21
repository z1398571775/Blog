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
	int showNum = 5;//显示几条数据
@Autowired
	private CommentMapper commentMapper;
	@Override
	public boolean saveComment(String NickName, String content, String articleID) {
		// TODO Auto-generated method stub
		Comment comment = new Comment(Utils.GetUUID(), NickName, content, Utils.gryNowTime(), articleID);
		return commentMapper.InsertComment(comment) > 0 ;
	}

	@Override
	public List<Comment> getComment(int currentNum,String articleID) {
		// TODO Auto-generated method stub
		int preNum = (currentNum-1)*showNum;
		int lastNum = currentNum*showNum;
		return commentMapper.SelectComment(preNum, lastNum,articleID);
	}

	@Override
	public int getPageCount(String articleID) {
		// TODO Auto-generated method stub
		int pageCount = Integer.valueOf(commentMapper.SelectAllComment(articleID));
		return (pageCount % showNum == 0 ? pageCount / showNum : pageCount / showNum + 1);
	}
	
}
