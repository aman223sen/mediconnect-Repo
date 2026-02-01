package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.PatientDAOImpl;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplJdbc implements PatientService {

  PatientDAOImpl patientDAOImpl;

  public PatientServiceImplJdbc(PatientDAOImpl patientDAOImpl) {
    this.patientDAOImpl = patientDAOImpl;
  }

  @Override
  public List<Patient> getAllPatients() {
    return patientDAOImpl.getAllPatients();
  }

  @Override
  public Integer addPatient(Patient patient) {
   
    return patientDAOImpl.addPatient(patient);
  }

  @Override
  public List<Patient> getAllPatientSortedByName() {
    List<Patient> a = patientDAOImpl.getAllPatients();
    Collections.sort(a, Comparator.comparing(Patient::getFullName));
    return a;
  }

  public void updatePatient(Patient patient) {
    patientDAOImpl.updatePatient(patient);

  }

  public void deletePatient(int patientId) {
    patientDAOImpl.deletePatient(patientId);

  }

  public Patient getPatientById(int patientId) {
    return patientDAOImpl.getPatientById(patientId);
  }

}