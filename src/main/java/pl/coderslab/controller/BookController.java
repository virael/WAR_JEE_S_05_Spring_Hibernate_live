package pl.coderslab.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class BookController {
	
	@Autowired
	private PublisherDao publisherDao;
	
	@Autowired
	private BookDao bookDao;
	
	@GetMapping(path = "/book/add")
	public String showAddBookForm(final Model model) {
		
		final Book book = new Book();
		model.addAttribute("book", book);
		
		return "book/add";		
	}
	
	@PostMapping(path = "/book/add")
	public String processAddBookForm(final Book book) {
			
		bookDao.add(book);
		
		return "book/success";
	}
	
	@ModelAttribute("publishers")
	public Collection<Publisher> publishers() {
		final Collection<Publisher> publishers = publisherDao.findAll();
		return publishers;
	}
}
