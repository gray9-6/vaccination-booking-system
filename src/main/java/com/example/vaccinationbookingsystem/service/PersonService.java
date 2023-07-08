package com.example.vaccinationbookingsystem.service;

import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person addPerson(Person person) {

        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }
}
