package com.yjdxs.blog.entity;

public class Comment {
	private String id;
	private String sickName;
	private String content;
	private String createTime;
	private String articleID;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSickName() {
		return sickName;
	}
	public void setSickName(String sickName) {
		this.sickName = sickName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getArticleID() {
		return articleID;
	}
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}
	public Comment(String id, String sickName, String content, String createTime, String articleID) {
		super();
		this.id = id;
		this.sickName = sickName;
		this.content = content;
		this.createTime = createTime;
		this.articleID = articleID;
	}
	public Comment() {
		super();
	}
	
}
