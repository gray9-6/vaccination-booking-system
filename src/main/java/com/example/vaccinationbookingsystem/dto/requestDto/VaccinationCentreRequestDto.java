package com.example.vaccinationbookingsystem.dto.requestDto;

import com.example.vaccinationbookingsystem.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VaccinationCentreRequestDto {
    CenterType centerType;

    String centerName;

    String address;
}
