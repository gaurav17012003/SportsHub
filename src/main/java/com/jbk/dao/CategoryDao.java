package com.jbk.dao;

import java.util.List;

import com.jbk.entities.Category;
import com.jbk.entities.Product;

public interface CategoryDao {
	public int createCategory(Category category);
	
	public Category getCategoryById(long id);
	
	public Category updateCategory(long id,Category category);

	public int deleteCategory(long cId);

	public List<Product> getCategoriesByPage(int page);

}