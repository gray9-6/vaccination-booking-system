package com.example.vaccinationbookingsystem.dto.responseDto;

import com.example.vaccinationbookingsystem.Enum.CenterType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VaccinationCenterResponseDto {

    CenterType centerType;

    String centerName;

    String address;

    String message;
}

