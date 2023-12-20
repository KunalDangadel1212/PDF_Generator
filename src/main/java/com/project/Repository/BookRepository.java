package com.project.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.Entity.Book;

public interface BookRepository  extends CrudRepository<Book , Integer> {

	
}
