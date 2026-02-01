package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Clinic;

public class ClinicDAOImpl implements ClinicDAO{
  private Connection connection;

  

    public ClinicDAOImpl() {
      try {
        this.connection=DatabaseConnectionManager.getConnection();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
  }

    @Override
    public int addClinic(Clinic clinic) {
   String sql="Insert Into clinic (clinic_name,location,doctor_id,contact_number,established_year) values (?,?,?,?,?)";
   try(PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
    ps.setString(1, clinic.getClinicName());
    ps.setString(2, clinic.getLocation());
    ps.setInt(3, clinic.getDoctorId());
    ps.setString(4, clinic.getContactNumber());
    ps.setInt(5,clinic.getEstablishedYear());

    ps.executeUpdate();
    ResultSet rs=ps.getGeneratedKeys();
    if(rs.next()){
      clinic.setClinicId(rs.getInt(1));
    }

   }catch(SQLException e){

   }

       return clinic.getClinicId();
    }

    @Override
    public Clinic getClinicById(int clinicId) {
      Clinic c=null;
     String sql="Select * from clinic where clinic_id=?";
     try(PreparedStatement ps=connection.prepareStatement(sql)){
      ps.setInt(1,clinicId);
     

      ResultSet rs=ps.executeQuery();
      if(rs.next()){
        c= new Clinic(clinicId,rs.getString("clinic_name"),rs.getString("location"),rs.getInt("doctor_id"),rs.getString("contact_number"),rs.getInt("established_year"));
      }



     }catch(SQLException e){
      System.out.println(e);
     }
     return c;
    }

    @Override
    public void updateClinic(Clinic clinic) {
       String sql="Update clinic Set clinic_name=?,location=?,doctor_id=?,contact_number=?,established_year=? where clinic_id=?";
   try(PreparedStatement ps=connection.prepareStatement(sql)){
    ps.setString(1, clinic.getClinicName());
    ps.setString(2, clinic.getLocation());
    ps.setInt(3, clinic.getDoctorId());
    ps.setString(4, clinic.getContactNumber());
    ps.setInt(5,clinic.getEstablishedYear());
    ps.setInt(6,clinic.getClinicId());

    ps.executeUpdate();


   }catch(SQLException e){

   }

       

        
    }

    @Override
    public void deleteClinic(int clinicId) {
      String sql="Delete from clinic where clinic_id=? ";
       try(PreparedStatement ps=connection.prepareStatement(sql)){
         ps.setInt(1,clinicId);

         ps.executeUpdate();
       }catch(SQLException e){
        System.out.println(e);
       }
       
    }

    @Override
    public List<Clinic> getAllClinics() {
      List<Clinic>list=new ArrayList<>();
    String sql="Select * from clinic";
     try(PreparedStatement ps=connection.prepareStatement(sql)){
     
     

      ResultSet rs=ps.executeQuery();
      while(rs.next()){
      
        int id=  rs.getInt("clinic_id");
       String name=   rs.getString("clinic_name");
        String location=  rs.getString("location");
        int doctorid=  rs.getInt("doctor_id");
         String contact= rs.getString("contact_number");
        int year=  rs.getInt("established_year");

        Clinic clinic=new Clinic(id,name,location,doctorid,contact,year);
        list.add(clinic);
      }

return list;

     }catch(SQLException e){
      System.out.println(e);
     }
     return list;
    }
    }

