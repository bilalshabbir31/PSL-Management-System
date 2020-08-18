/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import classes.Designation;
import classes.Nationality;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MUHAMMED BILAL
 */
public class NationalityDal {
    private Connection connection;

    public NationalityDal(Connection connection) {
        this.connection = connection;
    }
    public int getIDNationality(String Name){
        int id=0;
        try{
            String Query="Select id from Nationality where Name=?";
            PreparedStatement ps=connection.prepareStatement(Query);
            ps.setString(1,Name);
            ResultSet rs=ps.executeQuery();
            if(rs!=null && rs.next()){
                id=rs.getInt("id");
            }
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    public String getNameNationality(int id){
        String Name="";
        try{
            String Query="Select Name from Nationality where id=?";
            PreparedStatement ps=connection.prepareStatement(Query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs!=null && rs.next()){
                Name=rs.getString("Name");
            }
            return Name;
        }catch(Exception e){
            e.printStackTrace();
        }
        return Name;
    }
    public ArrayList<String>Combox(){
        try{
        String Query="Select Name from Nationality";
        PreparedStatement preparedStatement=connection.prepareStatement(Query);
        ResultSet objResult=preparedStatement.executeQuery();
        int i=0;
        ArrayList<String>List=new ArrayList<String>();
        while(objResult.next()){
            String Name=objResult.getString("Name");
            Nationality n=new Nationality(i, Name);
            List.add(n.getName());
        }
        return List;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
