package com.example.vaccinationbookingsystem.dto.responseDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorResponseDto {

    String name;

    String message;

    VaccinationCenterResponseDto vaccinationCenterResponseDto;

}
