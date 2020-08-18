/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import classes.Designation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MUHAMMED BILAL
 */
public class DesignationDal {
    private Connection Connection;

    public DesignationDal(Connection Connection) {
        this.Connection = Connection;
    }
    public void AddDesignation(Designation d){
        try{
            String Query="insert into Designation(id,DesignationName)values(?,?)";
            PreparedStatement preparedStatement=Connection.prepareStatement(Query);
            preparedStatement.setInt(1, d.getId());
            preparedStatement.setString(2,d.getDName());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Designation Successfully Added! ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void DeleteDesignationbyId(int id){
        try{
            PreparedStatement preparedStatement =Connection.prepareStatement("DELETE FROM Designation WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void DeleteDesignationbyName(String Name){
        try{
            PreparedStatement preparedStatement =Connection.prepareStatement("DELETE FROM Designation WHERE DesignationName=?");
            preparedStatement.setString(1, Name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean check_Designation_byID(int id){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =Connection.prepareStatement("select * from Designation where id= ?");
            preparedStatement.setInt(1, id);
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
    public boolean check_Designation_byName(String Name){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =Connection.prepareStatement("select * from Designation where DesignationName= ?");
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
    public ArrayList<String>Combox(){
        try{
        String Query="Select DesignationName from Designation";
        PreparedStatement preparedStatement=Connection.prepareStatement(Query);
        ResultSet objResult=preparedStatement.executeQuery();
        int i=0;
        ArrayList<String>List=new ArrayList<String>();
        while(objResult.next()){
            String Name=objResult.getString("DesignationName");
            Designation dobj=new Designation(i, Name);
            List.add(dobj.getDName());
        }
        return List;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void Update(Designation d){
        try{
            String Query="update Designation set DesignationName=? where id=?";
            PreparedStatement preparedStatement=Connection.prepareStatement(Query);
            preparedStatement.setString(1,d.getDName());
            preparedStatement.setInt(2,d.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Designation Successfully Update! ");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public int getIDby_DesignationName(String Designation){
        int id=0;
        try{
            PreparedStatement preparedStatement =Connection.prepareStatement("select id from Designation where DesignationName= ?");
            preparedStatement.setString(1,Designation);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if(objResultSet!=null&&objResultSet.next()){
                id=objResultSet.getInt("Id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
}
