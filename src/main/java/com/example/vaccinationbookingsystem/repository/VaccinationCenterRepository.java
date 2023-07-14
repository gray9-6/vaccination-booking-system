package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

    List<VaccinationCenter> findByCenterName(String centerName);
}
