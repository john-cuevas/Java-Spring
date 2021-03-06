package com.johncuevas.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.johncuevas.bookclub.models.Book;
import com.johncuevas.bookclub.models.User;
import com.johncuevas.bookclub.services.MainService;
import com.johncuevas.bookclub.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
//		Get userid from session
		
		Long userId = (Long) session.getAttribute("userId");
		
//		find user with UserService
		User user = userService.findOneUser(userId);

		model.addAttribute("books", mainService.allBooks());
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	
//	CREATE BOOK
	
	@GetMapping("/books/new")
	public String newBookForm(@ModelAttribute("book") Book book, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		return "newBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String processBookForm(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		else {
			mainService.createBook(book);
			return "redirect:/dashboard";
		}
	}
	
//	EDIT BOOK
	@GetMapping("/books/{id}/edit")
	public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		
		Book book = mainService.findOneBook(id);
		model.addAttribute("book", book);
		if( (Long) session.getAttribute("userId") == book.getReader().getId()){
			return "editBook.jsp";
			
		}
		return "redirect:/dashboard";
//		model.addAttribute("book", mainService.findOneBook(id));
//		return "editBook.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String processEditBook(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			mainService.updateBook(book);
			return "redirect:/dashboard";
		}
	}
	
//	DELETE BOOK
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		mainService.deleteBook(id);
		return "redirect:/dashboard";
	}
	
//	VIEW BOOK
	@GetMapping("/books/{id}")
	public String oneBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		model.addAttribute("book", mainService.findOneBook(id));
		return "oneBook.jsp";
	}

}
