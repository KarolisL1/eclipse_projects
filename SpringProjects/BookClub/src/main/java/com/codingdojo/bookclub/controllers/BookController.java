package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String allBooks(Model model) {
		model.addAttribute("book", bookService.allBooks());
		return "books";
	}
	
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "new_book";
	}
	
	@PostMapping("/books/new")
	public String create(@Valid @ModelAttribute("book") Book book,BindingResult result, Model model, HttpSession session) 
	{
		if (result.hasErrors()) {
			return "new_book";
		}	
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@RequestMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId, HttpSession session) {
		
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("booktest", book);
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "oneBook";
	}
	
	@RequestMapping("/books/{bookId}/edit")
	public String editBook(
			@PathVariable("bookId") Long bookId,
			Model model
			) {
		
//		bookService.updateBook(bookId);
		model.addAttribute("booktest", bookService.findBook(bookId));
//		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "editBook";
	}
	
	@PostMapping("/books/{bookId}/update")
	public String updateBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			@PathVariable("bookId") Long id
			)
	{
//		if (result.hasErrors()) return "editBook";
		book.setId(id);
		bookService.updateBook2(book);
		return "redirect:/books";
	}
}









