/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import classes.Room;
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
public class Roomdal {
    
    
    private Connection connection;

    public Roomdal(Connection connection) {
        this.connection = connection;
        
    }
     public void AddRecord(Room r)
    {
         try
         {
           
         String query="insert into Room(Player_ID,Player_Name,Hotel_Name,Area,Room_No,Giving_date,Rent_per_night )values(?,?,?,?,?,?,?)";
          PreparedStatement ps=connection.prepareStatement(query);
          ps.setInt(1, r.getId());
          ps.setString(2, r.getPlayername());
          ps.setString(3, r.getHotelName());
          ps.setString(4, r.getArea());
          ps.setInt(5, r.getRoomno());
          ps.setDate(6, r.getDate());
          ps.setInt(7, r.getRentpernight());
          ps.executeUpdate(); 
           
          JOptionPane.showMessageDialog(null,"DATA ADDED SUCCESSFULLY");
          
           }catch(Exception e)
        {
        
          e.printStackTrace();
        }
        
       
    
    
    }
    
    public Room SearchID(int id)
    {
        try
        { 
           String query="select *from Room where Player_ID=?";
           PreparedStatement ps =connection.prepareStatement(query);
           ps.setInt(1, id);
           ResultSet object=ps.executeQuery();
           if(object!=null && object.next())
           {
             Room r=new Room(object.getInt(1),object.getString(2),object.getString(3),object.getString(4),object.getInt(5),object.getDate(6),object.getInt(7));
               return r;
           
           }
          }catch (Exception e)
        {
        
          e.printStackTrace();
        
        }
        
return null;
 }
  public Room SearchRoomNo( int number)
    {
        try
        { 
           String query="select *from Room where Room_No=?";
           PreparedStatement ps =connection.prepareStatement(query);
           ps.setInt(1, number);
           ResultSet object=ps.executeQuery();
           if(object!=null && object.next())
           {
             Room r=new Room(object.getInt(1),object.getString(2),object.getString(3),object.getString(4),object.getInt(5),object.getDate(6),object.getInt(7));
               return r;
           
           }
          }catch (Exception e)
        {
        
          e.printStackTrace();
        
        }
        
return null;
 }   
public Room DeleteID(int id)
 {
   try 
   {
       String query="delete from Room where Player_ID=?";
       PreparedStatement ps =connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted Successfully!");
   
   
   }catch(Exception e) 
   {
     e.printStackTrace();
   
   } 
        return null;
 
    
}
public Room DeleteRoomNo(int roomno)
 {
   try 
   {
       String query="delete from Room where Room_No=?";
       PreparedStatement ps =connection.prepareStatement(query);
            ps.setInt(1, roomno);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted Successfully!");
   
   
   }catch(Exception e) 
   {
     e.printStackTrace();
   
   } 
        return null;
 }
 public void Update(Room r){
        try{                
            String query="update Room set Player_Name=? ,Hotel_Name=? ,Area=? ,Room_No=? ,Giving_date=? ,Rent_per_night=? where Player_ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
           
            ps.setString(1, r.getPlayername());
            ps.setString(2, r.getHotelName());
            ps.setString(3, r.getArea());
            ps.setInt(4, r.getRoomno());
            ps.setDate(5, r.getDate());
            ps.setInt(6, r.getRentpernight());
            ps.setInt(7 ,r.getId());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Update Succesfully ");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
     public ArrayList<Room> ViewRecord()
       {
           try
           { 
               
              Statement object =connection.createStatement();
              String query="select *from Room";
              ResultSet rs=object.executeQuery(query);
               ArrayList<Room> l = new ArrayList<Room>();
               while(rs.next())
               { 
                  Room r=new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6),rs.getInt(7));
                  l.add(r);
               }
          
              
              
          return l;  
           }catch(Exception e)
           {
           
              e.printStackTrace();
           
           
           }
        return null;
           
}
}