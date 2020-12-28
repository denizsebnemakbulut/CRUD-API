package com.phexum.restApp2;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryInterface extends CrudRepository<Entity, Long> {

	
	Entity findById(String id);

	void save(List<Entity> nameList);

	void removeById(String id);

	@Query(value = "SELECT name FROM Entity " )
	List<String> findName();

	void deleteById(String id);
}
