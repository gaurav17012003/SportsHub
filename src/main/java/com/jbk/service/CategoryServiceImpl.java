package com.jbk.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jbk.dao.CategoryDao;
import com.jbk.entities.Category;
import com.jbk.entities.Product;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public int createCategory(Category category) {
		int status = categoryDao.createCategory(category);
		return status;
	}

	@Override
	public Category updateCategory(long id, Category category) {

		return categoryDao.updateCategory(id, category);
	}
	
	
	@Override
	public int deleteCategory(long cId) {
		
		int value = categoryDao.deleteCategory(cId);
		return value;
	}



	@Override
	public Category getCategoryById(long id) {
		Category category = categoryDao.getCategoryById(id);
		return category;
	}

	@Override
	public List<Product> getCategoriesByPage(int page) {
		return categoryDao.getCategoriesByPage(page);
		
	}


}