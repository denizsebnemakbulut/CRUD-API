package com.phexum.restApp2;

import java.util.List;

public interface Service {

	List<Entity> getAllNameList();
	
	Entity getPerson(String id);
	
	void addPerson(Entity name);
	
	void updatePerson(Entity name);

	void deletePerson(String id);
	
	
}
