package com.examples.restfulapi.service;


import com.examples.restfulapi.entity.Person;
import com.examples.restfulapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person person){
        if (personRepository.existsById(id)){
            person.setId(id);
            return personRepository.save(person);
        }
        return null;
    }


    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }



}