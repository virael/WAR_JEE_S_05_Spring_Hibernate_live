package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

@RestController
public class BookController {

	@Autowired
	private BookDao bookDao;

	@GetMapping(path = "/book")
	public Book findBookById() {
		
		final Book book = bookDao.findById(1);
		
		return book;
	}
	
	@PostMapping(path = "/book")
	public Book addBook() {

		final Book book = new Book();
		book.setTitle("Elementarz");
		book.setAuthor("Jan Kowalski");
		book.setDescription("Ala ma kota");
		book.setPublisher("Helion");
		book.setRating((byte) 5);
		bookDao.add(book);
		
		return book;
	}

	@PutMapping(path = "/book")
	public Book editBook() {
		
		final Book book = new Book();
		book.setId(1L);
		book.setAuthor("Jan Nowak");
		bookDao.edit(book);
		
		return book;
	}

	@DeleteMapping(path = "/book")
	public void removeBookById() {
		bookDao.removeById(1);
	}
}
