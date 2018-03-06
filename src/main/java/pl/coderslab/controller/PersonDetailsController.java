package pl.coderslab.controller;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.dto.PersonDTO;

@Controller
public class PersonDetailsController {

	@GetMapping(path = "/persond/add")
	public String showRegistrationForm(final Model model) {
		
		final PersonDTO person = new PersonDTO();
		model.addAttribute("person", person);
		
		return "persond/add";
	}
	
	@PostMapping(path = "/persond/add")
	public String registerPerson(final @ModelAttribute("person") PersonDTO person) {
		
		return "persond/success";
	}
	
	@ModelAttribute("skills")
	public Collection<String> programmingSkills() {
		return Arrays.asList("Java", "PHP", "Python", "Ruby");
	}
	
	@ModelAttribute("hobbies")
	public Collection<String> hobbies() {
		return Arrays.asList("Piłka nożna", "Gry komuterowe", "Gotowanie");
	}
	
	@ModelAttribute("countries")
	public Collection<String> countries() {
		return Arrays.asList("Polska", "Niemcy", "Szwecja", "Wielka Brytania");
	}
}
