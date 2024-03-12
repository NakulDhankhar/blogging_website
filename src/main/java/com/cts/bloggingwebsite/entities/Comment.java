package com.cts.bloggingwebsite.entities;

public class Comment {
	private int comment_id;
	private int post_id;
	private String commenter_name;
	private String comment_content;
	
	public Comment()
	{
		super();
	}
	
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", post_id=" + post_id + ", commenter_name=" + commenter_name
				+ ", comment_content=" + comment_content + "]";
	}

	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getCommenter_name() {
		return commenter_name;
	}
	public void setCommenter_name(String commenter_name) {
		this.commenter_name = commenter_name;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	
	public Comment(int comment_id, int post_id, String commenter_name, String comment_content) {
		super();
		this.comment_id = comment_id;
		this.post_id = post_id;
		this.commenter_name = commenter_name;
		this.comment_content = comment_content;
		
	}
	
	
}
