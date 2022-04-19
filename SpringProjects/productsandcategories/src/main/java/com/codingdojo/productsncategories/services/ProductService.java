package com.codingdojo.productsncategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsncategories.models.Product;
import com.codingdojo.productsncategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> oneProduct = productRepository.findById(id);
		if(oneProduct.isPresent()) {
			return oneProduct.get();
		} else {
			return null;
		}
	}
}
