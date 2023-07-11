package com.example.vaccinationbookingsystem.service;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import com.example.vaccinationbookingsystem.Model.Dose;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.exception.DoseAlreadyTakenException;
import com.example.vaccinationbookingsystem.exception.PersonNotFoundException;
import com.example.vaccinationbookingsystem.repository.DoseRepository;
import com.example.vaccinationbookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    // i have to check that person exists or not so i will autowired the person repository
    @Autowired
    PersonRepository personRepository;

    public Dose getDose_1(int personId, DoseType doseType) {
        // find the person
        Optional<Person> optionalPerson = personRepository.findById(personId);

        // if that person is not in the database then throw the exception
        if(!optionalPerson.isPresent()){
            throw new PersonNotFoundException("Invalid PersonId");
        }

        //now , if that person exists , then get the person
        Person person = optionalPerson.get();

        // check whether that person has already taken dose_1 or not
        if(person.isDose1Taken()){
            throw new DoseAlreadyTakenException("You have Already taken Dose - 1");
        }

        // if the person have not taken the dose then he will take that dose
        // create a dose for him
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));  // setting dose id
        dose.setDoseType(doseType);   // setting the type of the dose
        dose.setPerson(person);   // setting the person to the dose

        // after creating and setting the dose , set that, this person has taken the dose
        person.setDose1Taken(true);
        // and save that person to the person repository  also
        personRepository.save(person);

        // now save the dose, but you don't need to do that if you have bi directional mapping
        // if you perform any operations on the parent(person)
        // it will automatically save changes to  child(dose)
        return doseRepository.save(dose);

    }
}
