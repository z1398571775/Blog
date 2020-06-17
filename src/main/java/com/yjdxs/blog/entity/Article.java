package com.yjdxs.blog.entity;

import java.util.Date;
import java.util.UUID;

public class Article {
	public String id;
	public String title;
	public String introduce;
	public String content;
	public String createtime;
	public String modifytime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	public Article(String id, String title, String introduce, String content, String createtime, String modifytime) {
		super();
		this.id = id;
		this.title = title;
		this.introduce = introduce;
		this.content = content;
		this.createtime = createtime;
		this.modifytime = modifytime;
	}
	public Article() {
		super();
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", introduce=" + introduce + ", content=" + content
				+ ", createtime=" + createtime + ", modifytime=" + modifytime + "]";
	}
	
	
	

}
