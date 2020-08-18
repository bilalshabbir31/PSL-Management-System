/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import classes.AirLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hamza
 */
public class AirLinedal {
    
    private Connection connection;

    public AirLinedal(Connection connection) {
        this.connection = connection;
    }
     public void AddRecord(AirLine al)
    {
         try
         {
           
         String query="insert into AirLine(Seat_No,Player_Name,Phone_No,AirPort_Name_City,AirLine_Company_Name,_From,_To,Flight_Date,Departure_Time,Arrival_Time )values(?,?,?,?,?,?,?,?,?,?)";
          PreparedStatement ps=connection.prepareStatement(query);
                  ps.setInt(1, al.getSeatno());
                  ps.setString(2, al.getPname());
                  ps.setLong(3, al.getPhonenum());
                  ps.setString(4, al.getAirportname());
                  ps.setString(5, al.getAirlinecompany());
                  ps.setString(6, al.getFrom());
                  ps.setString(7, al.getTo());
                  ps.setDate(8, al.getFlightdate());
                  ps.setString(9, al.getDeparturetime());
                  ps.setString(10, al.getArrivaltime());
         
          ps.executeUpdate(); 
           
          JOptionPane.showMessageDialog(null,"DATA ADDED SUCCESSFULLY");
          
           }catch(Exception e)
        {
        
          e.printStackTrace();
        }
        
   }
    
    public AirLine DeleteSno(int seatno)
 {
   try 
   {
       String query="delete from AirLine where Seat_No=?";
       PreparedStatement ps =connection.prepareStatement(query);
            ps.setInt(1, seatno);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted Successfully!");
   
   
   }catch(Exception e) 
   {
     e.printStackTrace();
   
   } 
        return null;
 
    
 
    
}
 public AirLine DeleteName(String name)
 {
   try 
   {
       String query="delete from AirLine where Player_Name=?";
       PreparedStatement ps =connection.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted Successfully!");
   
   
   }catch(Exception e) 
   {
     e.printStackTrace();
   
   } 
        return null;
 
    
    
}

 public ArrayList<AirLine> ViewRecord()
       {
           try
           { 
               
              Statement object =connection.createStatement();
              String query="select *from AirLine";
              ResultSet rs=object.executeQuery(query);
               ArrayList<AirLine> l = new ArrayList<AirLine>();
               while(rs.next())
               { 
                   
                   
                
                   AirLine a=new AirLine(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9),rs.getString(10));
                    l.add(a);
               }
          
              
              
          return l;  
           }catch(Exception e)
           {
           
              e.printStackTrace();
           
           
           }
        return null;
           
}
public AirLine Search(int no)
{ 
    
    try{
        String query="select *from AirLine where Seat_No=?";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1, no);
        ResultSet r=ps.executeQuery();
        if(r!=null && r.next())
         {
          AirLine a=new AirLine(r.getInt(1),r.getString(2),r.getLong(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getDate(8),r.getString(9),r.getString(10));
        return a;
        }
    
    
    
    
    }catch(Exception e)
    {
    
       e.printStackTrace();
    }
    
    
    
    
    
        return null;
   
  





}
public void UpdateFlight(AirLine airl)
{
try{                
            String query="Update AirLine set Player_Name=? ,Phone_No=? ,AirPort_Name_City=?,AirLine_Company_Name=? ,_From=? ,_To=?,Flight_Date=?,Departure_Time=?,Arrival_Time=? where Seat_No=?";
            PreparedStatement ps = connection.prepareStatement(query);
          ps.setString(1, airl.getPname());
          ps.setLong(2, airl.getPhonenum());
          ps.setString(3, airl.getAirportname());
          ps.setString(4, airl.getAirlinecompany());
          ps.setString(5, airl.getFrom());
          ps.setString(6, airl.getTo());
          ps.setDate(7, airl.getFlightdate());
          ps.setString(8, airl.getDeparturetime());
          ps.setString(9, airl.getArrivaltime());
          ps.setInt(10, airl.getSeatno());
           ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null," Update Succesfully");
        }catch(Exception e){
            e.printStackTrace();
        }
        



}
}
