package com.edutech.progressive.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Patient;

public class PatientDAOImpl implements PatientDAO {

    private Connection connection;

    public PatientDAOImpl() {
        try {
            this.connection = DatabaseConnectionManager.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public int addPatient(Patient patient) {
        String sql = "Insert into patient (full_name,date_of_birth,contact_number,email,address) Values(?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, patient.getFullName());
            ps.setDate(2, new Date(patient.getDateOfBirth().getTime()));
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                patient.setPatientId(rs.getInt(1));
            }
            // return r;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
        return patient.getPatientId();

    }

    @Override
    public Patient getPatientById(int patientId) {
        String sql = "Select * from patient where patient_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Patient(patientId, rs.getString("full_name"),
                        new Date(rs.getDate("date_of_birth").getTime()), rs.getString("contact_number"),
                        rs.getString("email"), rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {
        String sql = "Update patient set full_name=?,date_of_birth=?,contact_number=?,email=?,address=? where patient_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, patient.getFullName());
            ps.setDate(2, new Date(patient.getDateOfBirth().getTime()));
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setInt(6, patient.getPatientId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void deletePatient(int patientId) {
        String sql = "Delete from patient where patient_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> p = new ArrayList<>();
        String sql = "Select * from patient";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("patient_id");
                String name = rs.getString("full_name");
                Date date = rs.getDate("date_of_birth");
                String contact = rs.getString("contact_number");
                String email = rs.getString("email");
                String address = rs.getString("address");

                Patient p1 = new Patient(id, name, new Date(date.getTime()), contact, email, address);
                p.add(p1);

            }
            return p;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

}
