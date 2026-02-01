package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.ClinicDAOImpl;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

public class ClinicServiceImplJdbc implements ClinicService {
  ClinicDAOImpl clinicDAOImpl;

  

    public ClinicServiceImplJdbc(ClinicDAOImpl clinicDAOImpl) {
    this.clinicDAOImpl = clinicDAOImpl;
  }

    @Override
    public List<Clinic> getAllClinics() {
      return clinicDAOImpl.getAllClinics();
    }

    @Override
    public Clinic getClinicById(int clinicId) {
      return clinicDAOImpl.getClinicById(clinicId);
    }

    @Override
    public Integer addClinic(Clinic clinic) {
      return clinicDAOImpl.addClinic(clinic);
    }

    @Override
    public void updateClinic(Clinic clinic) {
       clinicDAOImpl.updateClinic(clinic);
    }

    @Override
    public void deleteClinic(int clinicId) {
        clinicDAOImpl.deleteClinic(clinicId);
    }

}