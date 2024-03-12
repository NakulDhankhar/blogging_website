package com.cts.bloggingwebsite.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.bloggingwebsite.dao.BlogPostDao;
import com.cts.bloggingwebsite.entities.BlogPost;

@Component
public class BlogPostDaoImpl implements BlogPostDao{
	
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;

 


	@Override
	public boolean addBlogPost(BlogPost blogPost) {
		String sql = "INSERT INTO BlogPost (title, content, publication_date, category_id, user_id) VALUES (?, ?, ?, ?, ?)";
        int count= jdbcTemplate.update(sql, blogPost.getTitle(), blogPost.getContent(), blogPost.getPublication_date(), blogPost.getCategory_id(), blogPost.getUser_id());
		return count>0;
	}

	@Override
	public boolean deleteBlogPostById(int post_id) {
		String sql = "DELETE FROM BlogPost WHERE post_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, post_id);
        return rowsAffected > 0;
	}

	@Override
	public boolean deleteAllBlogPost() {
		String sql = "DELETE FROM BlogPost";
        int rowsAffected = jdbcTemplate.update(sql);
        return rowsAffected > 0;
	}

	@Override
	public boolean updateBlogPost(BlogPost blogPost) {
		String sql = "UPDATE BlogPost SET title = ?, content = ?, publication_date = ?, category_id = ?, user_id = ? WHERE post_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, blogPost.getTitle(), blogPost.getContent(), blogPost.getPublication_date(), blogPost.getCategory_id(), blogPost.getUser_id(), blogPost.getPost_id());
        return rowsAffected > 0;
	}

	@Override
	public List<BlogPost> getAllPosts() {
		String sql = "SELECT * FROM BlogPost";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BlogPost.class));
	}

}
