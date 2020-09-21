package com.yjdxs.blog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjdxs.blog.entity.Article;
import com.yjdxs.blog.service.ArticalService;
import com.yjdxs.blog.service.CommentService;
import com.yjdxs.blog.serviceimpl.ArticleServiceimpl;

@Controller
public class TurnController {
	@RequestMapping("/editText")
	public String turnEdit() {
		return "edit";
	}
	
	@Autowired 
	ArticalService articleService;
	@Autowired
	CommentService commentService;
	@RequestMapping("/")
	public String turnindex(Model model) {
		//ArticalService articleService = new ArticleServiceimpl();
		List<Article> list = articleService.getAllArticle();
		model.addAttribute("articles", list);
		return "index";
	}
	/***
	 * 传入文章的ID，根据文章的ID查找文章对应的评论
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/content",produces = "application/json;charset=utf-8")
	public String turnShow(String id,Model model) {
		System.out.println(id);
		Article article = articleService.getArticle(id);
		model.addAttribute("article", article);
		model.addAttribute("pageCount", commentService.getPageCount(id));
		model.addAttribute("currentPage", 1);
		model.addAttribute("Comments", commentService.getComment(1, id));
		return "content";
	}
}
