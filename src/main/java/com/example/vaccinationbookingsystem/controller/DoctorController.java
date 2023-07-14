package com.example.vaccinationbookingsystem.controller;

import com.example.vaccinationbookingsystem.dto.requestDto.AddDoctorRequestDto;
import com.example.vaccinationbookingsystem.dto.responseDto.AddDoctorResponseDto;
import com.example.vaccinationbookingsystem.dto.responseDto.DoctorResponseByAgeDto;
import com.example.vaccinationbookingsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;


    // add doctor with center id
    @PostMapping("/add_doctor")
    public ResponseEntity addDoctor(@RequestBody AddDoctorRequestDto addDoctorRequestDto){
        try{
            AddDoctorResponseDto doctorResponse = doctorService.addDoctor(addDoctorRequestDto);
            return  new ResponseEntity(doctorResponse,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    // get all the doctors above the particular age

    @GetMapping("/get_doctor_By_Age")
    public ResponseEntity<List<DoctorResponseByAgeDto>> getDoctorsByAgeGreaterThan(@RequestParam("age") int age){
        try{
            List<DoctorResponseByAgeDto> doctorResponseDtoList = doctorService.getDoctorsByAgeGreaterThan(age);
            return new ResponseEntity(doctorResponseDtoList,HttpStatus.FOUND);
        } catch (Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
