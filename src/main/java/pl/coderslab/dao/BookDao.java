package pl.coderslab.dao;

import java.util.Collection;

import pl.coderslab.entity.Book;

public interface BookDao {

	void add(Book book);
	void edit(Book book);
	Book findById(long id);
	void removeById(long id);
	
	Collection<Book> getRatingList(byte rating);
	
	Collection<Book> findAll();
}
