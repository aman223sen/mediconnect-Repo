package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    // @Autowired
    // @Qualifier("patientjpa")

    // @Autowired
    // @Qualifier("patientArray")
     PatientServiceImplJpa patientServiceImplJpa;
     PatientServiceImplArraylist patientServiceImplArraylist;
   

   

    public PatientController(PatientServiceImplJpa patientServiceImplJpa,
            PatientServiceImplArraylist patientServiceImplArraylist) {
        this.patientServiceImplJpa = patientServiceImplJpa;
        this.patientServiceImplArraylist = patientServiceImplArraylist;
    }

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatients() {
      
        return ResponseEntity.status(200).body(patientServiceImplJpa.getAllPatients());
    }

    @GetMapping("/{patientID}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientID) {
        return ResponseEntity.status(200).body(patientServiceImplJpa.getPatientById(patientID));
    }

    @PostMapping()
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        // Integer val=Integer(patientServiceImplJpa.addPatient(patient));
        return ResponseEntity.status(200).body(patientServiceImplJpa.addPatient(patient));
    }

    @PutMapping("/{patientID}")
    public ResponseEntity<Void> updatePatient(@PathVariable("patientID") int patientId, @RequestBody Patient patient) {
        patient.setPatientId(patientId);
        patientServiceImplJpa.updatePatient(patient);
        // return ResponseEntity.status(200).body(null);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable("patientID") int patientId) {
        patientServiceImplJpa.deletePatient(patientId);
        // return ResponseEntity.status(200).build();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        return ResponseEntity.status(200).body(patientServiceImplArraylist.getAllPatients());
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList() {
        // patientServiceImplArraylist.addPatient(null);
        return ResponseEntity.status(201).body(null);
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        return ResponseEntity.status(200).body(patientServiceImplArraylist.getAllPatientSortedByName());
    }
}