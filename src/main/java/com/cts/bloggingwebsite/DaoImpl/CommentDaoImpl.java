package com.cts.bloggingwebsite.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.bloggingwebsite.dao.CommentDao;
import com.cts.bloggingwebsite.entities.Comment;

@Component
public class CommentDaoImpl implements CommentDao{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
//	public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
	

	@Override
	public void addComment(Comment comment) {
		String sql = "INSERT INTO Comment (commenter_name, comment_content) VALUES (?, ?)";
        jdbcTemplate.update(sql , comment.getCommenter_name(), comment.getComment_content());
		
	}

	@Override
	public boolean deleteComment(int comment_id) {
		String sql = "DELETE FROM Comment WHERE comment_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, comment_id);
        return rowsAffected > 0;
	}

	@Override
	public Comment getCommentById(int comment_id) {
		String sql = "SELECT * FROM Comment WHERE comment_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Comment.class), comment_id);
	}

	@Override
	public List<Comment> getAllCommentsOnSinglePost(int post_id) {
		String sql = "SELECT * FROM Comment where post id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class),post_id);
	}

}
