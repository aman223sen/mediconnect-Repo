package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplArraylist implements PatientService {

   private  static List<Patient>patientList=new ArrayList<>();

    @Override
    public List<Patient> getAllPatients() {
        return patientList;
    }

    @Override
    public Integer addPatient(Patient patient) {
        // if(patient!=null){
        // patientList.add(patient);
        // return 1;
        // }
        patientList.add(patient);
        return patient.getPatientId();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
    //    Collections.sort(patientList,Comparator.comparing(Patient::getFullName));
    Collections.sort(patientList);
       return patientList;
       
    }
//    public void emptyArrayList(){
//      patientList.clear();
//    }
}