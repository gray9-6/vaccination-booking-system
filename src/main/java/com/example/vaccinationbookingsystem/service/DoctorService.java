package com.example.vaccinationbookingsystem.service;

import com.example.vaccinationbookingsystem.Model.Doctor;
import com.example.vaccinationbookingsystem.Model.VaccinationCenter;
import com.example.vaccinationbookingsystem.dto.requestDto.AddDoctorRequestDto;
import com.example.vaccinationbookingsystem.dto.responseDto.DoctorResponseDto;
import com.example.vaccinationbookingsystem.dto.responseDto.VaccinationCenterResponseDto;
import com.example.vaccinationbookingsystem.exception.DoctorIsAlreadyPresent;
import com.example.vaccinationbookingsystem.exception.VaccinationCenterAlreadyExistsException;
import com.example.vaccinationbookingsystem.exception.VaccinationCenterDoesNotExists;
import com.example.vaccinationbookingsystem.repository.DoctorRepository;
import com.example.vaccinationbookingsystem.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public DoctorResponseDto addDoctor(AddDoctorRequestDto addDoctorRequestDto) {

        // first check center exists or not
        // if not , then throw  exception
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(addDoctorRequestDto.getCenterId());
        if(vaccinationCenterOptional.isEmpty()){
            throw new VaccinationCenterDoesNotExists("Vaccination center does not exists");
        }

        // if vaccination center exists, then get the vaccination center
        VaccinationCenter vaccinationCenter = vaccinationCenterOptional.get();

        // now convert the addDoctor DTO to Doctor entity
        Doctor doctor = new Doctor();
        doctor.setName(addDoctorRequestDto.getName());
        doctor.setAge(addDoctorRequestDto.getAge());
        doctor.setEmailId(addDoctorRequestDto.getEmailId());
        doctor.setGender(addDoctorRequestDto.getGender());
        doctor.setVaccinationCenter(vaccinationCenter);

        // before adding this doctor to center make sure this doctor is already not added
        // if doctor is already registered , throw exception
        Doctor DoctorPresent = doctorRepository.findByEmailId(doctor.getEmailId());
        if(DoctorPresent != null){
            throw  new DoctorIsAlreadyPresent("Doctor is already registered");
        }

        // Note :- before saving any entity to database make sure that
        //  we have set all the attributes which it required, and also
        // make sure that ,when we are setting any other entity , do we
        // need to change anything in it or not

        // if doctor is registering for first time then add doctor in vaccinationCenter's doctorList
        vaccinationCenter.getDoctorList().add(doctor);

        // now save the parent entity i.e vaccination center
        VaccinationCenter savedCenter = vaccinationCenterRepository.save(vaccinationCenter);  // this will save both center and doctor


        // Now prepare the response DTO,, convert the entity to DTO
        // i have to get the savedDoctor first
        List<Doctor> doctorList = savedCenter.getDoctorList();
        Doctor savedDoctor = doctorList.get(doctorList.size()-1);

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setName(savedDoctor.getName());
        doctorResponseDto.setMessage("Congrats !! , You have been register");

        VaccinationCenterResponseDto vaccinationCenterResponseDto = new VaccinationCenterResponseDto();
        vaccinationCenterResponseDto.setCenterName(savedCenter.getCenterName());
        vaccinationCenterResponseDto.setCenterType(savedCenter.getCenterType());
        vaccinationCenterResponseDto.setAddress(savedCenter.getAddress());
        vaccinationCenterResponseDto.setMessage("ThankYou for registering to this center !!");

        doctorResponseDto.setVaccinationCenterResponseDto(vaccinationCenterResponseDto);

        // return the prepared response DTO
        return doctorResponseDto;
    }
}
