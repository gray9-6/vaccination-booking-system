package com.example.vaccinationbookingsystem.Model;


import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id  // iss se meri primary key ban gayi
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this will help us to auto generate the id , so that user can't override
    // by giving same id to create a new person
    int id;

    String name;

    int age;

    //  @Column(unique = true,nullable = false)
    @Column(unique = true)
    // now this column became unique, and user have to pass the email id ,se we set to nullable
            String emailId;

    @Enumerated(EnumType.STRING)
    // i am telling mysql that gender is enum and we are storing as string
    Gender gender;

    boolean isDose1Taken;


    boolean isDose2Taken;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    //means one person can have multiple doses
    // and if a person is having multiple doses then i need a data structure to store multiple doses, so i use list
    List<Dose> dosesTaken = new ArrayList<>(); // becoz initially person ne 0 dose lagayi hogi, isliye humne yahi initialize kar diya yaha

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    Certificate certificate;
}
