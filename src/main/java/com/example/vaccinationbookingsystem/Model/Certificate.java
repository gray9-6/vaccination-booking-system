package com.example.vaccinationbookingsystem.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String certificateNo;  //  generated by UUID

    String confirmationMessage;

    @OneToOne
    @JoinColumn
    Person person;
}

