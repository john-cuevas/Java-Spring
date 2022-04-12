package com.johncuevas.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johncuevas.booksapi.models.BookModel;
import com.johncuevas.booksapi.services.BookService;

@RestController
public class APIController {
	
	private final BookService bookService;

	public APIController(BookService bookService) {
		this.bookService = bookService;
	}
	
//	FIND ALL BOOKS
	
	@GetMapping("/api/books")
	public List <BookModel> index(){
		return bookService.allBooks();
	}
	
//	CREATE A BOOK
	
	@PostMapping("/api/books")
	public BookModel createBook(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages
			) {
		BookModel newBook = new BookModel(title, description, language, numberOfPages);
		return bookService.createBook(newBook);
	}
	
//	UPDATE A BOOK
	
//	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
	
	@PutMapping("/api/books/{id}")
	public BookModel update(
			@PathVariable("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages
			) {
		
		BookModel book = new BookModel(title, description, language, numberOfPages);
		book.setId(id);
		return bookService.updateBook(book);
	}
	
//	FIND ONE BOOK
	
//	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
	
	@GetMapping("/api/books/{id}")
	public BookModel getOne(@PathVariable("id") Long id) {
		return bookService.findBook(id);
	}
	
//	DELETE ONE BOOK
	
//	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
	
	@DeleteMapping("/api/books/{id}")
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
	public BookService getBookService() {
		return bookService;
	}
	
	
	
	
	
	

}
