package com.yjdxs.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjdxs.blog.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService commentService;
	@PostMapping("/saveComment")
	@ResponseBody
	public boolean saveComment(String nickName,String commentText,String articleID)
	{
		return commentService.saveComment(nickName, commentText, articleID);
	}
}
