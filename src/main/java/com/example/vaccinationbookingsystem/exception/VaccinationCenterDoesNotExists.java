package com.example.vaccinationbookingsystem.exception;

public class VaccinationCenterDoesNotExists extends RuntimeException{
    public VaccinationCenterDoesNotExists(String message) {
        super(message);
    }
}
