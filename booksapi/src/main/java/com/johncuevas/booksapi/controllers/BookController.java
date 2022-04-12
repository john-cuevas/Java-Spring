package com.johncuevas.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.johncuevas.booksapi.models.BookModel;
import com.johncuevas.booksapi.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public String oneBook(Model model, @PathVariable("id") Long id) {
		
		BookModel book = bookService.findBook(id);
		model.addAttribute("book", book);
		
		return "book.jsp";
	}
	
	@GetMapping("/books")
	public String allMovies(Model model) {
		List<BookModel> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "dashboard.jsp";
	}

}
