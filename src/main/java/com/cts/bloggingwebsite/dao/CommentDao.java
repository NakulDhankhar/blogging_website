package com.cts.bloggingwebsite.dao;

import java.util.List;

import com.cts.bloggingwebsite.entities.Comment;

public interface CommentDao {
	public void addComment(Comment comment);
	public boolean deleteComment(int comment_id);
	public Comment getCommentById(int comment_id);
	public List<Comment> getAllCommentsOnSinglePost(int post_id);
	
}
