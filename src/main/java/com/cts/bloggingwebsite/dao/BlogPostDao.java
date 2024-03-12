package com.cts.bloggingwebsite.dao;

import java.util.List;

import com.cts.bloggingwebsite.entities.BlogPost;

public interface BlogPostDao {
	public boolean addBlogPost(BlogPost blogPost);
	public boolean deleteBlogPostById(int post_id);
	public boolean deleteAllBlogPost();
	public boolean updateBlogPost(BlogPost blogPost);
	public List<BlogPost> getAllPosts();
	
	
}
