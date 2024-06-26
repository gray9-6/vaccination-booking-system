package com.example.vaccinationbookingsystem.controller;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import com.example.vaccinationbookingsystem.Model.Dose;
import com.example.vaccinationbookingsystem.dto.requestDto.BookDose1RequestDto;
import com.example.vaccinationbookingsystem.dto.responseDto.BookDose1ResponseDto;
import com.example.vaccinationbookingsystem.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    // get dose-1

    // Bt taking Request param as input
    /*
    @PostMapping("/get_dose_1")
    public ResponseEntity getDose_1(@RequestParam("personId") int personId, @RequestParam("doseType") DoseType doseType){
        try{
            Dose doseTake = doseService.getDose_1(personId, doseType);
            return new ResponseEntity(doseTake,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }    */


    // By Taking Request DTO's as input
    @PostMapping("/get_dose_1")
    public ResponseEntity getDose_1(@RequestBody BookDose1RequestDto bookDose1RequestDto){
        try{
            BookDose1ResponseDto doseTake = doseService.getDose_1(bookDose1RequestDto);
            return new ResponseEntity(doseTake,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Add Dose -2
}

