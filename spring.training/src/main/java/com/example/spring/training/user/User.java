package com.example.spring.training.user;

import java.util.Date;
import java.util.List;
import java.util.List;

public class User {
	private int id;
	private String name;
	private Date date;
	private List<String> post;
	
	public User(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	public User(int id, String name, Date date, List<String> post) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.post = post;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public List<String> getPost() {
		return post;
	}

	public void setPost(List<String> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + ", post=" + post + "]";
	}
}
