package com.example.vaccinationbookingsystem.dto.responseDto;

import com.example.vaccinationbookingsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorResponseByAgeDto {

    String name;

    String email;

    int age;

    Gender gender;

    VaccinationCenterResponseDto vaccinationCenterResponseDto;
}
