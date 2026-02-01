package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.DoctorDAOImpl;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplJdbc  implements DoctorService{
   DoctorDAOImpl doctorDAOImpl;
   

    public DoctorServiceImplJdbc(DoctorDAOImpl doctorDAOImpl) {
      this.doctorDAOImpl = doctorDAOImpl;
   }
  
    @Override
    public List<Doctor> getAllDoctors() {
       return doctorDAOImpl.getAllDoctors();
    }
public Doctor getDoctorById(int doctorId){
    return doctorDAOImpl.getDoctorById(doctorId);
}
    @Override
    public Integer addDoctor(Doctor doctor) {
       return doctorDAOImpl.addDoctor(doctor);
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
       List<Doctor>dd= doctorDAOImpl.getAllDoctors();
       Collections.sort(dd,Comparator.comparing(Doctor::getYearsOfExperience));
       return dd;
    }

    public void updateDoctor(Doctor doctor){
     doctorDAOImpl.updateDoctor(doctor);
    }

    public void deleteDoctor(int doctorId){
      doctorDAOImpl.deleteDoctor(doctorId);

    }

}