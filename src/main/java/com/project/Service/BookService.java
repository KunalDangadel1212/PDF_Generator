package com.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Entity.Book;
import com.project.Entity.Role;
import com.project.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	public List<Book> getAllBooks() {
		
		return (List<Book>) bookRepo.findAll();
	}

	public Optional<Book> getBookById(int id) {
		Optional<Book> book = bookRepo.findById(id);
		return book;
	}

	public Book insertBook(Book book) {
		Book result = bookRepo.save(book);
		return result;
	}
	
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	
	}
	public void UpdateById(Book book,int id) {
		book.setBid(id);
		bookRepo.save(book);
		
}
}