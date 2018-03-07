package pl.coderslab.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public Collection<Book> getRatingList(final byte rating) {
		
		final Query query = em.createQuery("select b from Book b where b.rating = :rating");
		query.setParameter("rating", rating);
		
		final List<Book> books = query.getResultList();
		return books;
	}
	
	@Override
	public Collection<Book> findAll() {
		
		final Query query = em.createQuery("select b from Book b");
		
		final List<Book> books = query.getResultList();
		return books;
	}
}
