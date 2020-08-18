/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import classes.Owner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author MUHAMMED BILAL
 */
public class OwnerDal {
    private Connection connection;

    public OwnerDal(Connection connection) {
        this.connection = connection;
    }
    public void Add(Owner o){
        try{
            String query="insert into Owner(Owner_id,Name,Mail,Phone_No,CNIC,DOB,Nationality)values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, o.getId());
            preparedStatement.setString(2,o.getName());
            preparedStatement.setString(3,o.getMail());
            preparedStatement.setLong(4,o.getPhonenumber());
            preparedStatement.setLong(5,o.getCnic());
            preparedStatement.setDate(6,o.getDate());
            preparedStatement.setInt(7,o.getNationality());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Succesfully Added!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Update(Owner o){
        try{
            String query="Update Owner Set Name=? , Mail=?, Phone_No=? , CNIC=?, DOB=?  , Nationality=?    Where Owner_Id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,o.getName());
            preparedStatement.setString(2,o.getMail());
            preparedStatement.setLong(3,o.getPhonenumber());
            preparedStatement.setLong(4,o.getCnic());
            preparedStatement.setDate(5, o.getDate());
            preparedStatement.setInt(6,o.getNationality());
            preparedStatement.setInt(7, o.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Succesfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Owner SearchbyId(int id){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Owner where Owner_Id = ?");
                preparedStatement.setInt(1, id);
                ResultSet objResultSet = preparedStatement.executeQuery();
                if (objResultSet != null && objResultSet.next()) {
                    Owner o= new Owner(objResultSet.getInt(1) , objResultSet.getString(2) , objResultSet.getString(3) , objResultSet.getLong(4) , objResultSet.getLong(5) , objResultSet.getDate(6) , objResultSet.getInt(7));
                    return o;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Owner SearchbyName(String Name){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Owner where Name=?");
            preparedStatement.setString(1,Name);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if (objResultSet != null && objResultSet.next()) {
                Owner o= new Owner(objResultSet.getInt(1) , objResultSet.getString(2) , objResultSet.getString(3) , objResultSet.getLong(4) , objResultSet.getLong(5) , objResultSet.getDate(6) , objResultSet.getInt(7));
                return o;
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void DeletebyID(int id){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM Owner WHERE Owner_Id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void DeletebyName(String Name){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM Owner WHERE Name=?");
            preparedStatement.setString(1, Name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Owner>ViewAll(){
        try{               
            Statement objStatement = connection.createStatement();
            ResultSet objResultSet = objStatement.executeQuery("select * from Owner");
            ArrayList<Owner> objList = new ArrayList<Owner>();
            while(objResultSet.next()){
                Owner o=new Owner(objResultSet.getInt(1),objResultSet.getString(2),objResultSet.getString(3),objResultSet.getLong(4),objResultSet.getLong(5),objResultSet.getDate(6),objResultSet.getInt(7));
                objList.add(o);

            }
            return objList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean checkOwner_id(int id){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Owner where Owner_Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if (objResultSet != null && objResultSet.next()) {
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean check_Owner_Name(String Name){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Owner where Name= ?");
            preparedStatement.setString(1, Name);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if (objResultSet!=null&&objResultSet.next()) {
                flag=true;
            }
            else{
                flag=false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public void LoadComboxinTeam(JComboBox c){
        try{
            c.addItem("-Select-");
            String Query="Select Name from Owner";
            PreparedStatement ps=connection.prepareStatement(Query);
            ResultSet rs=ps.executeQuery();
            while(rs!=null && rs.next()){
                c.addItem(rs.getString("Name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
