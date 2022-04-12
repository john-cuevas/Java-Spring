package com.johncuevas.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johncuevas.booksapi.models.BookModel;
import com.johncuevas.booksapi.repositories.BookRepository;

@Service
public class BookService {
	
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // returns all the books
    public List<BookModel> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public BookModel createBook(BookModel book) {
        return bookRepository.save(book);
    }
    
    // retrieves a book
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } 
        else {
            return null;
        }
    }
    
//    updates a book
    public BookModel updateBook(BookModel book) {
    	return bookRepository.save(book);
    }
    
//    deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
