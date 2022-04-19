package com.codingdojo.productsncategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productsncategories.models.Category;
import com.codingdojo.productsncategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    // Retrieves a list of all categories for a particular product
	List<Category> findAll();
	
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
}
