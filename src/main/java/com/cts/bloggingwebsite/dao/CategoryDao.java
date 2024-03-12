package com.cts.bloggingwebsite.dao;

import java.util.List;

import com.cts.bloggingwebsite.entities.Category;

public interface CategoryDao {
	public void addCategory(Category category);
	public boolean deleteCategory(int category_id);
	public boolean updateCategory(Category category);
	public List<Category> getAllCategories();
	

}
