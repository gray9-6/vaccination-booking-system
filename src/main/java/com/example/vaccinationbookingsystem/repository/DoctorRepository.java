package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    Doctor findByEmailId(String emailId);
}
