package com.codingdojo.productsncategories.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsncategories.models.Category;
import com.codingdojo.productsncategories.models.Product;
import com.codingdojo.productsncategories.services.CategoryService;
import com.codingdojo.productsncategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;
	private ProductService productService;
	
	public MainController(CategoryService categoryService,ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@GetMapping("products/new")
	public String new_product(@ModelAttribute("product") Product product, Model model) {
//		model.addAttribute("product", productService.allProducts());
		return "new_product";
	}
	
	@PostMapping("/products/new")
	public String create(@ModelAttribute("product") Product product,BindingResult result, Model model, HttpSession session) 
	{
		if (result.hasErrors()) {
			return "new_product";
		}	
		productService.createProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping("/products/{productId}")
	public String oneProduct(
			Model model,
			@PathVariable("productId") Long productId
	) 
	{
		Product product = productService.findProduct(productId);
		
		model.addAttribute("product", product);
		model.addAttribute("Categories", categoryService.allCategories());
//		model.addAttribute("categoriesIN", categoryService.allByProducts(product));
//		model.addAttribute("categoriesOut", categoryService.allNotContains(product));
		return "one_product";
	}
	
	@PostMapping("/products/{productId}/withCategory")
	public String create2(
			Model model,
			@PathVariable("productId") Long productId,
			@RequestParam("category_id") Long categoryId
	) 
	{
		Product product = productService.findProduct(productId);
		Category category = categoryService.findCategory(categoryId);
		List<Category> categoryList = product.getCategories();
		categoryList.add(category);
		productService.createProduct(product);
//		LocalTime myObj = LocalTime.now();
//		model.addAttribute("time", myObj);
		return "redirect:/";
	}
	
	@GetMapping("/categories/new")
	public String new_product(@ModelAttribute("category") Category category, Model model) {
//		model.addAttribute("category", categoryService.allCategories());
		return "new_category";
	}
	
	@PostMapping("/categories/new")
	public String create(@ModelAttribute("category") Category category,BindingResult result) 
	{
		if (result.hasErrors()) {
			return "new_product";
		}	
		categoryService.createCategory(category);
		return "redirect:/";
	}
}
