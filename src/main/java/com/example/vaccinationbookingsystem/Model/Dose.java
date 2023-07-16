package com.example.vaccinationbookingsystem.Model;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String doseId; //  generated by UUID

    @Enumerated(value = EnumType.STRING)
    DoseType doseType;


    @CreationTimestamp // it will automatically assign the date, by picking the date from your system
    Date vaccinationDate; // util date has both date and time

    @ManyToOne    // first part represent  - current class , second part represent connecting class
    // here the current class is dose , which can be many
    // and the connecting class is person, which can only be one
    // which means one person can have many dose , but one dose is for one person only
    // means ek dose ki bottle sirf ek bande ke liye hai
    @JoinColumn // this will introduce the foreign key column in your table.
    // and by default the P.k column of the parent table will become the F.K column in the child table
    // and if you want to change it , you change it by @JoinColumn(value = yourColumnFromParentTable_which you want to make the primary key)
    Person person;

}


