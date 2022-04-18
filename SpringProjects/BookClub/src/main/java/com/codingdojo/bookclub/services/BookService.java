package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	   // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
    	System.out.println(b);
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //not finished
    public Book updateBook(Long id,String title,String author_name,String thoughts) {
    	Optional<Book> new_book = bookRepository.findById(id);
    	Book book = new_book.get();
    	book.setTitle(title);
    	book.setAuthor_name(author_name);
    	book.setThoughts(thoughts);
        return bookRepository.save(book);
    }
    
    public Book updateBook2(Book book) {
    	return bookRepository.save(book);
    }
    
    public void deleteBook(Long Id) {
    	bookRepository.deleteById(Id);
    }
    
    
}
