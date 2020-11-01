package com.yjdxs.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjdxs.blog.entity.Article;
import com.yjdxs.blog.entity.Comment;
import com.yjdxs.blog.service.ArticalService;
import com.yjdxs.blog.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService commentService;
	@Autowired
	ArticalService articleService;
	@PostMapping("/saveComment")
	@ResponseBody
	/***
	 * 保存评论的Markdown数据
	 * @param nickName
	 * @param commentText
	 * @param articleID
	 * @return
	 */
	public boolean saveComment(String nickName,String commentText,String articleID)
	{
		return commentService.saveComment(nickName, commentText, articleID);
	}
	/***
	 * 更新评论
	 * @param CurrentPage
	 * @param articleID
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateComment")
	public String updateComment(int CurrentPage,String articleID,Model model) {
		Article article = articleService.getArticle(articleID);
		model.addAttribute("article", article);
		model.addAttribute("pageCount", commentService.getPageCount(articleID));
		model.addAttribute("currentPage", CurrentPage);
		model.addAttribute("Comments", commentService.getComment(CurrentPage, articleID));
		return "content::commentFragment";
	}
}
