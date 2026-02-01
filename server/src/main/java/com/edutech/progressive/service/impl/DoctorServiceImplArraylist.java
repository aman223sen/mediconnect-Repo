package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplArraylist implements DoctorService {

    private static List<Doctor>doctorList=new ArrayList<>();

    // public void emptyArrayList(){
    //     doctorList.clear();

    // }

    @Override
    public List<Doctor> getAllDoctors() {
       return doctorList;
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
    //    if(doctor==null){
    //     return -1;
    //    }
       doctorList.add(doctor);
       return doctor.getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
    //    Collections.sort(doctorList,Comparator.comparing(Doctor::getYearOfExperience));
    Collections.sort(doctorList);
       return doctorList;
    }

}