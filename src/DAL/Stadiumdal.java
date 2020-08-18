/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;
import classes.Stadium;
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
public class Stadiumdal {
    
    private Connection connection;

    public Stadiumdal(Connection connection) {
        this.connection = connection;
    }
     public void AddRecord(Stadium s)
    {
         try
         {
           
         String query="insert into Stadiums(S_id,Stadium_Name,Stadium_Area,Stadium_Address,Stadium_Capacity,Stadium_Opened,Stadium_Owner,Phone_Number )values(?,?,?,?,?,?,?,?)";
          PreparedStatement ps=connection.prepareStatement(query);
          ps.setInt(1, s.getId());
          ps.setString(2, s.getName());
          ps.setString(3, s.getArea());
           ps.setString(4, s.getAddress());
           ps.setInt(5, s.getCapacity());
           ps.setDate(6, s.getOpened());
           ps.setString(7, s.getOwner());
           ps.setLong(8, s.getPhoneno());
         
          ps.executeUpdate(); 
           
          JOptionPane.showMessageDialog(null,"data added successfully");
          
           }catch(Exception e)
        {
        
          e.printStackTrace();
        }
        
       
    
    
    }
    
    public Stadium Search(int sid)
    {
        try
        { 
           String query="select *from Stadiums where S_id=?";
           PreparedStatement ps =connection.prepareStatement(query);
          ps.setInt(1, sid);
           ResultSet object=ps.executeQuery();
           if(object!=null && object.next())
           {
             Stadium s=new Stadium(object.getInt(1),object.getString(2),object.getString(3),object.getString(4),object.getInt(5),object.getDate(6),object.getString(7),object.getLong(8));
               return s;
           
           }
          }catch (Exception e)
        {
        
          e.printStackTrace();
        
        }
        
return null;
 }
 
 public Stadium Delete(int stid)
 {
   try 
   {
       String query="delete from Stadiums where S_id=?";
       PreparedStatement ps =connection.prepareStatement(query);
            ps.setInt(1, stid);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfuly deleted");
   
   
   }catch(Exception e) 
   {
     e.printStackTrace();
   
   } 
        return null;
 
    
}
  public void Update(Stadium s){
        try{                
            String query="Update Stadiums set Stadium_Name=? ,Stadium_Area=? ,Stadium_Address=?,Stadium_Capacity=? ,Stadium_Opened=? ,Stadium_Owner=?,Phone_Number=? where S_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
           ps.setString(1, s.getName());
           ps.setString(2, s.getArea());
           ps.setString(3, s.getAddress());
           ps.setInt(4, s.getCapacity());
           ps.setDate(5, s.getOpened());
           ps.setString(6, s.getOwner());
           ps.setLong(7, s.getPhoneno());
           ps.setInt(8, s.getId());
           ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null," Update Succesfully");
        }catch(Exception e){
            e.printStackTrace();
        }
        
   }
  
   public ArrayList<Stadium> ViewRecord()
       {
           try
           { 
               
              Statement object =connection.createStatement();
              String query="select *from Stadiums";
              ResultSet rs=object.executeQuery(query);
               ArrayList<Stadium> l = new ArrayList<Stadium>();
               while(rs.next())
               { 
                   Stadium s=new Stadium(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6),rs.getString(7),rs.getLong(8));
                   l.add(s);
               
               
               }
          
              
              
          return l;  
           }catch(Exception e)
           {
           
              e.printStackTrace();
           
           
           }
           
           
           
           
           
           
        return null;
       
       
       
       
       }
  
  
  
}