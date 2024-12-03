package com.jbk.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.Category;
import com.jbk.entities.Product;
import com.jbk.exceptions.ResourceNotFoundException;

@Repository
public class ProductDaoImpl implements ProductDao {

	private static final int PAGE_SIZE = 5;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@Override
	public int createProduct(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Product dbProduct = session.get(Product.class, product.getpId());
			if (dbProduct == null) {
				try {
					Category category = categoryDao.getCategoryById(product.getCategory().getcId());
					product.setCategory(category);
					session.save(product);
					session.beginTransaction().commit();
					return 1;
				} catch (ResourceNotFoundException e) {
					return 4;
				}	
			} 
			else {
				return 2;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public List<Product> getProductsByPage(int pageNumber) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Product p ORDER BY p.pId"; 

			Query<Product> query = session.createQuery(hql, Product.class);

			int firstResult = (pageNumber - 1) * PAGE_SIZE;
			query.setFirstResult(firstResult);
			query.setMaxResults(PAGE_SIZE);

			
			return query.list();
		} finally {
			session.close();

		}

	}
	
	@Override
	public Product updateProduct(long id, Product product) {

		try {
			Session session = sessionFactory.openSession();
			Product dbProduct = session.get(Product.class, id);
			if(dbProduct!=null) {
				
				dbProduct.setpName(product.getpName());
				session.update(dbProduct);
				session.beginTransaction().commit();
				return dbProduct;
				
			}
			else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
		
	}

	@Override
	public Product getProductById(long id) {
		Product product = null;
		try {
			Session session = sessionFactory.openSession();
			product=session.get(Product.class, id);
			if(product!=null) {
				return product;
			}else {
				throw new ResourceNotFoundException("Category not exists for id = " +id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("Category not exists for id = " +id);
		}

	}
	
	@Override
	public int deleteProduct(long id) {
		
		try {
			
			Session session = sessionFactory.openSession();
			
			Product dbProduct = session.get(Product.class, id);
			
			if(dbProduct!=null) {
				session.delete(dbProduct);
				session.beginTransaction().commit();
				return 1;	
			}
			
			else {
				return 2;
			}
			
		}
		catch (Exception e ){
			e.printStackTrace();
			return 3;
			
		}
		
	}

}