package pl.coderslab.dao;

import java.util.Collection;

import pl.coderslab.entity.Author;

public interface AuthorDao {

	void add(Author author);
	void edit(Author author);
	Author findById(long id);
	void removeById(long id);
	
	Collection<Author> findAll();
}
