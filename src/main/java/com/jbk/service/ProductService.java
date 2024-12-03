package com.jbk.service;

import java.util.List;

import com.jbk.entities.Product;

public interface ProductService {

	public int createProduct(Product product);
	
	 public List<Product> getProductsByPage(int pageNumber);
	 
	 public Product updateProduct(long id,Product product);
	 
	 public Product getProductById(long id);
	 
	 public int deleteProduct(long id);

}