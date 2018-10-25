package com.User;


import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private String id;
	private String name;
	@JSONField(format="yyyy-MM-dd")
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getId() {
		return id;
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
