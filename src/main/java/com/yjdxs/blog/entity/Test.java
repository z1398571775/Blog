package com.yjdxs.blog.entity;

import java.util.UUID;

public class Test {
	public String id;
	public String name;
	public String getId() {
		return UUID.randomUUID().toString();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
