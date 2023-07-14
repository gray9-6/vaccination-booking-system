package com.example.vaccinationbookingsystem.controller;

import com.example.vaccinationbookingsystem.dto.requestDto.AddDoctorRequestDto;
import com.example.vaccinationbookingsystem.dto.responseDto.DoctorResponseDto;
import com.example.vaccinationbookingsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;


    // add doctor with center id
    @PostMapping("/add_doctor")
    public ResponseEntity addDoctor(@RequestBody AddDoctorRequestDto addDoctorRequestDto){
        try{
            DoctorResponseDto doctorResponse = doctorService.addDoctor(addDoctorRequestDto);
            return  new ResponseEntity(doctorResponse,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
