package com.example.vaccinationbookingsystem.service;

import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    // the person object which we are passing will not have the id, becoz it will be autogenerated
    // after this object (person) got save into repository(database)
    public Person addPerson(Person person) {
        // the person1 object will have the id, becoz after saving the person object to database
        // it will auto increment the id and the save method will return us the object of person with id.
        // it is not necessary that it will always save the person , it might throw an error
        // in the case when email id is same,, becoz we have set the email id to be unique
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }
}
