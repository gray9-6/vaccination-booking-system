package com.example.vaccinationbookingsystem.service;

import com.example.vaccinationbookingsystem.Model.VaccinationCenter;
import com.example.vaccinationbookingsystem.dto.requestDto.VaccinationCentreRequestDto;
import com.example.vaccinationbookingsystem.dto.responseDto.VaccinationCenterResponseDto;
import com.example.vaccinationbookingsystem.exception.FillAllDetailsException;
import com.example.vaccinationbookingsystem.exception.VaccinationCenterAlreadyExistsException;
import com.example.vaccinationbookingsystem.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenterResponseDto addVaccinationCentre(VaccinationCentreRequestDto vaccinationCentreRequestDto) {

        // checks for filling all the required details
        if(vaccinationCentreRequestDto.getAddress() == null || vaccinationCentreRequestDto.getCenterName() == null
                || vaccinationCentreRequestDto.getCenterType() == null){
            throw new FillAllDetailsException("Please fill all the details of center");
        }


        // convert DTO ---> entity
        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.setCenterType(vaccinationCentreRequestDto.getCenterType());
        vaccinationCenter.setCenterName(vaccinationCentreRequestDto.getCenterName());
        vaccinationCenter.setAddress(vaccinationCentreRequestDto.getAddress());


        // Before adding the vaccination center, check if it is already present or not
        // if it is already present throw new exception
        List<VaccinationCenter> vaccinationCenterList = vaccinationCenterRepository.findByCenterName(vaccinationCenter.getCenterName());
        for(VaccinationCenter center : vaccinationCenterList){
            if(center.getCenterName().equals(vaccinationCenter.getCenterName())){
                throw new VaccinationCenterAlreadyExistsException("vaccination center already exists");
            }
        }


        // now save the vaccination centre to database, if it is not exists already
        VaccinationCenter savedCenter =  vaccinationCenterRepository.save(vaccinationCenter);


        // convert Entity to Response DTO  for making  response DTO
        VaccinationCenterResponseDto vaccinationCenterResponseDto = new VaccinationCenterResponseDto();
        vaccinationCenterResponseDto.setCenterType(savedCenter.getCenterType());
        vaccinationCenterResponseDto.setCenterName(savedCenter.getCenterName());
        vaccinationCenterResponseDto.setAddress(savedCenter.getAddress());
        vaccinationCenterResponseDto.setMessage("You have Successfully added the centre !!");

        // return the response
        return  vaccinationCenterResponseDto;
    }
}

