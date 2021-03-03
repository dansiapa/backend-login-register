package com.digi.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FirstController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password) {
		return "Login Success "+email;
	}
	
	// Insert ke table tb_person
	@PostMapping("/person")
	public PersonModel createPerson(@RequestBody PersonModel personModel) {
		return personService.createPerson(personModel); 	
	}
	
	// Get person based on person_id
	@GetMapping("/person/{id}")
	public PersonModel getPerson(@PathVariable int id) {
		return personService.getPerson(id).get();
	}
	
	// get all person berupa list/iterable
	@GetMapping("/person/all")
	public Iterable<PersonModel> getAllPerson(){
		return personService.getAllPerson();
	}
	
	// get person by name
	@GetMapping("/person/name/{name}")
	public Iterable<PersonModel> getPersonByName(@PathVariable String name) {
		return personService.getPersonByName(name);
	}
	
	// delete person by id
	@DeleteMapping("/person/delete/{id}")
	public String deletePerson(@PathVariable int id) {
		if(personService.deletePerson(id)) {
			return "Success delete person with id "+id;
		}else {
			return "Person with id "+id+" not found";
		}
		
	}
	
	// upload file ke folder upload
	@PostMapping("/person/ktp")
	public String uploadKtp(@RequestParam("file") MultipartFile file) {
		personService.saveFile(file);
		return "Success upload ktp";
	}
}
