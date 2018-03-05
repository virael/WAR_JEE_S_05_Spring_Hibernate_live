package pl.coderslab.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

@Component
@Transactional
public class JPABookDao implements BookDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(final Book book) {
		em.persist(book);
	}

	@Override
	public void edit(final Book book) {
		em.merge(book);
	}

	@Override
	public Book findById(final long id) {
		final Book book = em.find(Book.class, id);
		
		return book;
	}

	@Override
	public void removeById(final long id) {
		final Book book = em.find(Book.class, id);
		if(book != null) {
			em.remove(book);
		}
	}
}
