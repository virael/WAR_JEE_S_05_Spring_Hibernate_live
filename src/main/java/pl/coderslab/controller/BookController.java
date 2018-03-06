package pl.coderslab.controller;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@RestController
public class BookController {

	@Autowired
	private BookDao bookDao;

	@GetMapping(path = "/book")
	public Book findBookById() {
		
		final Book book = bookDao.findById(1);
		
		prepareBook(book);
		
		return book;
	}
	
	@GetMapping(path = "/book/{rating}")
	public Collection<Book> getRatingList(final @PathVariable("rating") byte rating) {
		
		final Collection<Book> books = bookDao.getRatingList(rating);
		
		for(final Book book : books) {
			prepareBook(book);
		}
		
		return books;
	}
	
	@PostMapping(path = "/book")
	public Book addBook() {

		final Book book = new Book();
		book.setTitle("Elementarz");
		
		final Author author = new Author();
		author.setId(1L);
		
		book.setAuthors(Arrays.asList(author));
		book.setDescription("Ala ma kota");
		
		final Publisher publisher = new Publisher();
		publisher.setId(1L);
		
		book.setPublisher(publisher);
		book.setRating((byte) 5);
		bookDao.add(book);
		
		return book;
	}

	@PutMapping(path = "/book")
	public Book editBook() {
		
		final Book book = new Book();
		book.setId(1L);
		book.setRating((byte)9);
		bookDao.edit(book);
		
		return book;
	}

	@DeleteMapping(path = "/book")
	public void removeBookById() {
		bookDao.removeById(1);
	}
	
	private void prepareBook(final Book book) {
		
		final Publisher publisher = book.getPublisher();
		
		if(publisher != null) {
			publisher.setBooks(null);
		}
		
		final Collection<Author> authors = book.getAuthors();
		
		for(final Author author : authors) {
			author.setBooks(null);
		}
	}
}
