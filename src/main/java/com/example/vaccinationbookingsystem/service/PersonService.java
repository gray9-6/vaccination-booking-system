package com.example.vaccinationbookingsystem.service;

import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.dto.requestDto.AddPersonRequestDto;
import com.example.vaccinationbookingsystem.dto.responseDto.AddPersonResponseDto;
import com.example.vaccinationbookingsystem.exception.PersonNotFoundException;
import com.example.vaccinationbookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;



/*
    // the person object which we are passing will not have the id, becoz it will be autogenerated
    // after this object (person) got save into repository(database)
    public Person addPerson(Person person) {

//        person.setDose1Taken(false);
//        person.setDose2Taken(false);
        person.setCertificate(null);

        // the person1 object will have the id, becoz after saving the person object to database
        // it will auto increment the id and the save method will return us the object of person with id.
        // it is not necessary that it will always save the person , it might throw an error
        // in the case when email id is same,, becoz we have set the email id to be unique
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }    */

    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {

        // Before saving the AddPersonRequestDto to database
        // we first have to convert the Request dto to entity

        // convert AddPersonRequestDto to ---> person entity

        // make a new class and set the parameter which needed to be set
        // just see that the parameter of person class will come from where,
        // and which parameter,i will have to set
        Person person = new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmailId(addPersonRequestDto.getEmailId());
        person.setGender(addPersonRequestDto.getGender());
        person.setDose1Taken(false);
        person.setDose2Taken(false);
        person.setCertificate(null);

        // save the person to database
        Person savedPerson = personRepository.save(person);

        // Now we have the return the AddPersonResponse DTO
        // Convert Entity to ---> DTO
        AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();
        addPersonResponseDto.setName(person.getName());
        addPersonResponseDto.setMessage("Congrats you have registered successfully !!");

        // now return the DTO
        return addPersonResponseDto;


    }

    public AddPersonResponseDto updateEmail(String oldEmail, String newEmail) {
        // get the person , by using custom method findByEMailId()
        Person person  = personRepository.findByEmailId(oldEmail);

        // if that person does not exists then return null
        if(person == null){
            throw new PersonNotFoundException("Sorry this email id does not exists ");
        }

        // if that person exists then set the new email id for that person
        person.setEmailId(newEmail);

        // now save the person
        Person savedPerson = personRepository.save(person);

        // prepare response dto for updateEmail
        AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();
        addPersonResponseDto.setName(savedPerson.getName());
        addPersonResponseDto.setMessage("email updated successfully !!");

        // return the response dto
        return addPersonResponseDto;
//        return "email updated successfully";
    }
}



