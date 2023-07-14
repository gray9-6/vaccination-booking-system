package com.example.vaccinationbookingsystem.dto.requestDto;

import com.example.vaccinationbookingsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddDoctorRequestDto {

    Integer centerId;

    String name;

    int age;

    String emailId;

    Gender gender;
}
