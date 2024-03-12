package com.cts.bloggingwebsite.serviceDaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bloggingwebsite.dao.CategoryDao;
import com.cts.bloggingwebsite.entities.Category;
import com.cts.bloggingwebsite.serviceDao.CategoryServiceDao;

@Service
public class CategoryServiceDaoImpl implements CategoryServiceDao{
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}
	@Override
	public boolean deleteCategory(int category_id) {
		return categoryDao.deleteCategory(category_id);
	}

	@Override
	public boolean updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

}
