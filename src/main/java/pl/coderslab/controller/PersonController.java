package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Controller
public class PersonController {

	@Autowired
	private PersonDao personDao;

	@GetMapping(path = "/person/add")
	public String showRegistartionForm(final Model model) {
		
		final Person person = new Person();
		model.addAttribute("person", person);
		
		return "person/add";
	}

	@PostMapping(path = "/person/add")
	public String registerPerson(final @ModelAttribute("person") Person person) {
		
		final String login = person.getLogin();
		final String email = person.getEmail();
		final String password = person.getPassword();
		
		if (login != null && !login.isEmpty() && email != null && !email.isEmpty() && password != null
				&& !password.isEmpty()) {
			
			final String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
			
			person.setPassword(hashedPassword);

			personDao.add(person);
			
			return "person/success";
		}

		return "person/failure";
	}
}
