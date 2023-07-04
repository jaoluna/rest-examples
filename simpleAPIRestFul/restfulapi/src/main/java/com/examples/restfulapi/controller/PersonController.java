package com.examples.restfulapi.controller;

import com.examples.restfulapi.entity.Person;
import com.examples.restfulapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable("id") Long id){
        var response = personService.getPersonById(id);
        if (response != null){
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/create")
    public ResponseEntity<?> createPerson(@RequestBody Person personRequest){
        var response = personService.createPerson(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/update")
    public ResponseEntity<?> updatePerson(@RequestBody Person personRequest){
        var response = personService.updatePerson(personRequest.getId(), personRequest);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
