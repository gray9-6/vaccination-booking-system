package com.example.vaccinationbookingsystem.dto.requestDto;


import com.example.vaccinationbookingsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPersonRequestDto {

    String name;

    int age;

    String emailId;

    Gender gender;
}

