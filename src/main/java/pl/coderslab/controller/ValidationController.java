package pl.coderslab.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.entity.Book;

@Controller
public class ValidationController {
	
	@Autowired
	private Validator validator;
	
	@GetMapping(path = "/validate")
	public String validate(final Book book, final Model model) {
		
		final Set<ConstraintViolation<Book>> violations = 
				validator.validate(book);
		
		if(violations.isEmpty()) {
			return "validate/success";
		} else {
			
			model.addAttribute("violations", violations);
			
			return "validate/failure";
		}
	}
}
