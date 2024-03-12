package com.cts.bloggingwebsite.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.bloggingwebsite.dao.CategoryDao;
import com.cts.bloggingwebsite.entities.Category;


@Component
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	

	@Override
	public void addCategory(Category category) {
		String sql = "INSERT INTO Category (category_name) VALUES (?)";
        jdbcTemplate.update(sql,category.getCategory_name());
		
	}

	@Override
	public boolean deleteCategory(int category_id) {
		String sql = "DELETE FROM Category WHERE category_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, category_id);
        return rowsAffected > 0;
	}

	@Override
	public boolean updateCategory(Category category) {
		String sql = "UPDATE Category SET category_name = ? WHERE category_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, category.getCategory_name(), category.getCategory_id());
        return rowsAffected > 0;
	}

	@Override
	public List<Category> getAllCategories() {
		String sql = "SELECT * FROM Category";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
	}

}
