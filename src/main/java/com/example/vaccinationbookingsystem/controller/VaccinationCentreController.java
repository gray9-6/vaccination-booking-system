package com.example.vaccinationbookingsystem.controller;

import com.example.vaccinationbookingsystem.dto.requestDto.VaccinationCentreRequestDto;
import com.example.vaccinationbookingsystem.dto.responseDto.VaccinationCenterResponseDto;
import com.example.vaccinationbookingsystem.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccination_centre")
public class VaccinationCentreController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;


    // add vaccination centre
    @PostMapping("/add_vaccine_centre")
    public ResponseEntity addVaccinationCentre(@RequestBody VaccinationCentreRequestDto vaccinationCentreRequestDto){
        try{
            VaccinationCenterResponseDto vaccinationResponse = vaccinationCenterService.addVaccinationCentre(vaccinationCentreRequestDto);
            return new ResponseEntity(vaccinationResponse, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}



