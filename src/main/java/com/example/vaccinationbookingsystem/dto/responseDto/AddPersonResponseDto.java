package com.example.vaccinationbookingsystem.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPersonResponseDto {
    String name;

    String message;
}


