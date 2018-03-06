package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@RestController
@RequestMapping(path = "/rest")
public class RestPersonController {
	
	@Autowired
	private PersonDao personDao;
	
	@GetMapping(path = "/person")
	public Person findPersonById() {
		
		final Person person = personDao.findById(1);
		return person;
	}
	
	@PostMapping(path = "/person")
	public Person addPerson() {

		final Person person = new Person();
		person.setLogin("test login");
		person.setPassword("test password");
		person.setEmail("mail@mail");
		
		final PersonDetails personDetails = new PersonDetails();
		personDetails.setCity("Warszawa");
		personDetails.setFirstName("Jan");
		personDetails.setLastName("Nowak");
		personDetails.setStreet("Polna");
		personDetails.setStreetNumber((byte)2);
		
		person.setPersonDetails(personDetails);
		
		personDao.add(person);
		
		return person;
	}

	@PutMapping(path = "/person")
	public Person editPerson() {
		
		final Person person = new Person();
		person.setId(1L);
		person.setEmail("new_mail@mail");
		
		personDao.edit(person);
		
		return person;
	}

	@DeleteMapping(path = "/person")
	public void removePersonById() {
		personDao.removeById(1);
	}
}
