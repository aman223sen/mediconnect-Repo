package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

@Service
public class PatientServiceImplJpa implements PatientService {

   
  
   

//     public PatientServiceImplJpa(PatientRepository patientRepository) {
//     this.patientRepository = patientRepository;
// }

    @Override
    public List<Patient> getAllPatients() {
       return new ArrayList<>();
    }

    @Override
    public Integer addPatient(Patient patient) {
        return -1;
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
      return new ArrayList<>();
    }

   

}