package com.jbk.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.entities.Category;
import com.jbk.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public int createProduct(Product product) {
		int status = productDao.createProduct(product);
		return status;

	}

	@Override
	public List<Product> getProductsByPage(int pageNumber) {

		return productDao.getProductsByPage(pageNumber);
	}
	
	@Override
	public Product updateProduct(long id, Product product) {

		return productDao.updateProduct(id, product);
	}

	@Override
	public Product getProductById(long id) {
		Product product = productDao.getProductById(id);
		return product;
		
	}
	
	@Override
	public int deleteProduct(long id) {
		
		int value = productDao.deleteProduct(id);
		return value;
	}


}