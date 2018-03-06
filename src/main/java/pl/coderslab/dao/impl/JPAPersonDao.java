package pl.coderslab.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Component
@Transactional
public class JPAPersonDao implements PersonDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Person person) {
		em.persist(person);
	}

	@Override
	public void edit(Person person) {
		em.merge(person);
	}

	@Override
	public Person findById(long id) {
		
		final Person person = em.find(Person.class, id);
		return person;
	}

	@Override
	public void removeById(long id) {
		
		final Person person = em.find(Person.class, id);
		if(person != null) {
			em.remove(person);
		}
	}
}
