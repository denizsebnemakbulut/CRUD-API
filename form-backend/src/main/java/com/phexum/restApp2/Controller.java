package com.phexum.restApp2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller {
	
	@Autowired
	private Service entityService;
		
	
	@GetMapping("/person/{id}")
	public Entity getPerson(@PathVariable("id") String id){
		return entityService.getPerson(id);
	}
	
	@GetMapping("/person")
	public List<Entity>  allList(){
		return entityService.getAllNameList();
	}
	
	
	@PostMapping("/person")
	public void addPerson(@RequestBody Entity name) {
		entityService.addPerson(name);
		
	}

	@PutMapping("/person")
	public void updatePerson(@RequestBody Entity name) {
		entityService.updatePerson(name);
	}
	
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") String id) {
		entityService.deletePerson(id);
	}
	

}
