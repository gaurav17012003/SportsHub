package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Category;
import com.jbk.entities.Product;
import com.jbk.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/categories")
	public String createCategory(@RequestBody Category category) {
		int status = categoryService.createCategory(category);
		switch (status) {
		case 1: {
			return "Category Added Successfully";

		}
		case 2: {
			return "Category Already Exists";

		}
		case 3: {
			return "Something went wrong";

		}
		default:
			return "";
		}
	}
	
	 @GetMapping("/categories")
	    public List<Product> getProducts(@RequestParam(defaultValue = "1") int page) {
	        return categoryService.getCategoriesByPage(page);
	    }

	@GetMapping("categories/{id}")
	public Object getCategoryById(@PathVariable long id) {
		
		Category category = categoryService.getCategoryById(id);
		return category;
	}
	

	@PutMapping("/categories/{id}")
	public Object updateCategory(@PathVariable long id, @RequestBody Category category) {

		Category updateCategory = categoryService.updateCategory(id, category);
		if (updateCategory != null) {
			return updateCategory;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/categories/{id}")
	public String deleteCategory(@PathVariable long id ) {
		
		int value = categoryService.deleteCategory(id);
		
		switch (value) {
		case 1: {
			return "Category Deleted Successfully";
			
		}
		
		case 2: {
			return "Category Not Exits";
			
		}

		case 3: {
			return "Something Went Wrong";
			
		}
		
		default:
			return "";
		}
		
	}

}