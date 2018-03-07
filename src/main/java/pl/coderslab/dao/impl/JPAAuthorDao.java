package pl.coderslab.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

@Component
@Transactional
public class JPAAuthorDao implements AuthorDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(final Author author) {
		em.persist(author);
	}

	@Override
	public void edit(final Author author) {
		em.merge(author);
	}

	@Override
	public Author findById(final long id) {
		final Author author = em.find(Author.class, id);
		return author;
	}

	@Override
	public void removeById(final long id) {
		final Author author = em.find(Author.class, id);
		if(author != null) {
			em.remove(author);
		}
	}
	
	@Override
	public Collection<Author> findAll() {
		
		final Query query = em.createQuery("select a from Author a");
		final List<Author> authors = query.getResultList();
		
		return authors;
	}
}
