package pl.coderslab.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class JPAPublisherDao implements PublisherDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(final Publisher publisher) {
		em.persist(publisher);
	}

	@Override
	public void edit(final Publisher publisher) {
		em.merge(publisher);
	}

	@Override
	public Publisher findById(final long id) {
		final Publisher publisher = em.find(Publisher.class, id);
		return publisher;
	}

	@Override
	public void removeById(final long id) {
		final Publisher publisher = em.find(Publisher.class, id);
		if(publisher != null) {
			em.remove(publisher);
		}
	}
	
	@Override
	public Collection<Publisher> findAll() {
		final Query query = em.createQuery("select p from Publisher p");
		final List<Publisher> publishers = query.getResultList();
		return publishers;
	}
}
