package com.phexum.restApp2;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;



@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
	
	private RepositoryInterface repo;
	
	List<Entity> nameList =  new ArrayList<>();
	
	@Autowired
	public ServiceImpl(RepositoryInterface repo) {
		this.repo = repo;
	}
	
	@Override
	public List<Entity> getAllNameList(){
		
		return (List<Entity>) repo.findAll();
	}
	
	
	@Override
	public Entity getPerson(String id) {
		return repo.findById(id);
	}
	
	@Override
	public void addPerson(Entity name) {
		repo.save(name).toString();
	}
	
	@Override
	public void updatePerson(Entity name) {
		
		repo.save(name);
		
	}
	
	@Override
	@Transactional
	public void deletePerson(String id) {
		repo.deleteById(id);
	}

}
