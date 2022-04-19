package com.codingdojo.productsncategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsncategories.models.Category;
import com.codingdojo.productsncategories.models.Product;
import com.codingdojo.productsncategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public List<Category> allByProducts(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> allNotContains(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> oneCategory = categoryRepository.findById(id);
		if(oneCategory.isPresent()) {
			return oneCategory.get();
		} else {
			return null;
		}
	}
	
	
}
