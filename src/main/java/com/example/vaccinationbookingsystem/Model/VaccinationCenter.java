package com.example.vaccinationbookingsystem.Model;

import com.example.vaccinationbookingsystem.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    CenterType centerType;

    String centerName;

    String address;

    @OneToMany(mappedBy = "vaccinationCenter",cascade = CascadeType.ALL)
    List<Doctor> doctorList;
}


