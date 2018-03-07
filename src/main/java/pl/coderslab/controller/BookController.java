package pl.coderslab.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class BookController {

	@Autowired
	private PublisherDao publisherDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private AuthorDao authorDao;
	
	@GetMapping(path = "/book/add")
	public String showAddBookForm(final Model model) {

		final Book book = new Book();
		model.addAttribute("book", book);

		return "book/add";
	}

	@PostMapping(path = "/book/add")
	public String processAddBookForm(final @Valid Book book, final BindingResult bresult) {

		if(bresult.hasErrors()) {
			return "book/add";
		}
		
		bookDao.add(book);

		return "redirect:list";
	}

	@GetMapping(path = "/book/list")
	public String showAllBooks(final Model model) {

		final Collection<Book> books = bookDao.findAll();

		model.addAttribute("books", books);
		return "book/list";
	}

	@GetMapping(path = "/book/edit")
	public String showEditForm(final @RequestParam(name = "id", required = true) long id, final Model model) {

		final Book book = bookDao.findById(id);

		model.addAttribute("book", book);
		return "book/edit";
	}

	@PostMapping(path = "/book/edit")
	public String editBook(final Book book) {
		
		bookDao.edit(book);
		
		return "redirect:list";
	}
	
	@GetMapping(path = "/book/remove")
	public String showDeleteConfirmForm(final @RequestParam(name = "id", required = true) long id, final Model model) {
		
		final Book book = bookDao.findById(id);
		model.addAttribute("book", book);

		return "book/remove";
	}
	
	@PostMapping(path = "/book/remove")
	public String deleteBook(final @RequestParam(name = "id", required = true) long id) {

		bookDao.removeById(id);
		return "redirect:list";
	}

	@ModelAttribute("publishers")
	public Collection<Publisher> publishers() {
		final Collection<Publisher> publishers = publisherDao.findAll();
		return publishers;
	}
	
	@ModelAttribute("authors")
	public Collection<Author> authors() {
		final Collection<Author> authors = authorDao.findAll();
		return authors;
	}
}
