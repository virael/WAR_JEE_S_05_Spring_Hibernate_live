package pl.coderslab.dao;

import pl.coderslab.entity.Person;

public interface PersonDao {

	void add(Person person);
	void edit(Person person);
	Person findById(long id);
	void removeById(long id);
}
