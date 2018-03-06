package pl.coderslab.dao;

import java.util.Collection;

import pl.coderslab.entity.Publisher;

public interface PublisherDao {

	void add(Publisher publisher);
	void edit(Publisher publisher);
	Publisher findById(long id);
	void removeById(long id);
	
	Collection<Publisher> findAll();
}
