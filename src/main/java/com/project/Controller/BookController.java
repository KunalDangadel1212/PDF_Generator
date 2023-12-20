package com.project.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.project.Entity.Book;
import com.project.Entity.Role;
import com.project.Service.BookPDFExporter;
import com.project.Service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
//shri
	
	public List<Book> getAllBooks() {

		List<Book> list = bookService.getAllBooks();
		return list;
	}

	
@GetMapping("/getAllBooks")
public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
     
    List<Book> listBook= bookService.getAllBooks();
     
    BookPDFExporter exporter = new BookPDFExporter(listBook);
    exporter.export(response);

}


@GetMapping("/getBookById/{id}")
public void exportBookByIdToPDF(@PathVariable Integer id, HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=book_" + id + "_" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
     
    Optional<Book> optionalBook = bookService.getBookById(id);
    
    if (optionalBook.isPresent()) {
        Book book = optionalBook.get();
        List<Book> singleBookList = Collections.singletonList(book);
        BookPDFExporter exporter = new BookPDFExporter(singleBookList);
        exporter.export(response);
    } else {
        // Handle the case where the book with the specified ID is not found
        // You can send an error response or handle it as needed
    }
}



@PostMapping("/insert")
public Book insertBook(@RequestBody Book book,Role author) {

	book = bookService.insertBook(book);
	return book;
}

@DeleteMapping("/deleteById/{id}")
public void deleteBookById(@PathVariable("id") int id) {
	bookService.deleteById(id);

}

@PutMapping("/updateById/{id}")
public void updateBookById(@RequestBody Book book ,@PathVariable("id") int id) {
	bookService.UpdateById(book, id);

}

}






