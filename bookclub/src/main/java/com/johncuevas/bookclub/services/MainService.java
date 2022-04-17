package com.johncuevas.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johncuevas.bookclub.models.Book;
import com.johncuevas.bookclub.repositories.BookRepository;

@Service
public class MainService {
	
	@Autowired 
	private BookRepository bookRepo;
	
//	FIND ALL BOOKS
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
//	FIND ONE BOOK USING ID
	public Book findOneBook( Long id) {
		Optional <Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
//	CREATE ONE BOOK
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
//	UPDATE GIFT USING ID
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
//	DELETE GIFT USING ID
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	

}
