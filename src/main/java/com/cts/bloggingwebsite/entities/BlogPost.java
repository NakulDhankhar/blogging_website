package com.cts.bloggingwebsite.entities;


public class BlogPost {
	private int post_id;
	private String title;
	private String content;
	private String publication_date;
	private int category_id;
	private int user_id;
	
	public BlogPost()
	{
		super();
	}
	
	@Override
	public String toString() {
		return "BlogPost [post_id=" + post_id + ", title=" + title + ", content=" + content + ", publication_date="
				+ publication_date + ", category_id=" + category_id + ", user_id=" + user_id + "]";
	}

	public int getPost_id() {
		return post_id;
	}
	
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public BlogPost(int post_id, String title, String content, String publication_date, int category_id,int user_id) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.content = content;
		this.publication_date = publication_date;
		this.category_id = category_id;
		this.user_id=user_id;
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


}
 