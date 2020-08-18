/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import classes.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MUHAMMED BILAL
 */
public class EmployeeDal {
    private Connection connection;

    public EmployeeDal(Connection connection) {
        this.connection = connection;
    }
    public void Add(Employee objEmployee){
        try{
            
            String query="insert into Employee(id,Name,Mail,Phone_NO,CNIC,DOB,Nationality,Designation_ID)values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, objEmployee.getId());
            preparedStatement.setString(2,objEmployee.getName());
            preparedStatement.setString(3,objEmployee.getMail());
            preparedStatement.setLong(4,objEmployee.getPhonenumber());
            preparedStatement.setLong(5,objEmployee.getCnic());
            preparedStatement.setDate(6,objEmployee.getDate());
            preparedStatement.setInt(7,objEmployee.getNationality());
            preparedStatement.setInt(8,objEmployee.getIddesignation());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Succesfully Added!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Update(Employee objEmployee){
        try{
            String query="Update Employee Set Name=? , Mail=?, Phone_NO=? , CNIC=?, DOB=?  , Nationality=?    Where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,objEmployee.getName());
            preparedStatement.setString(2,objEmployee.getMail());
            preparedStatement.setLong(3,objEmployee.getPhonenumber());
            preparedStatement.setLong(4,objEmployee.getCnic());
            preparedStatement.setDate(5, objEmployee.getDate());
            preparedStatement.setInt(6,objEmployee.getNationality());
            preparedStatement.setString(7,objEmployee.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully Update! ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Employee SearchId(String id){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select e.id,e.Name,e.mail,e.Phone_NO,e.CNIC,e.DOB,e.Nationality,d.DesignationName from Employee e join Designation d on e.Designation_ID=d.id where e.id=?");
            preparedStatement.setString(1,id);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if (objResultSet != null && objResultSet.next()) {
                Employee e= new Employee(objResultSet.getString(1),objResultSet.getString(2) , objResultSet.getString(3) , objResultSet.getLong(4) , objResultSet.getLong(5) , objResultSet.getDate(6),objResultSet.getInt(7),objResultSet.getString(8));
                return e;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void DeletebyId(String id){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM Employee WHERE id=?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Employee>viewall(){
        try{
            Statement objStatement = connection.createStatement();
            ResultSet objResultSet = objStatement.executeQuery("select e.id,e.Name,e.mail,e.Phone_NO,e.CNIC,e.DOB,e.Nationality,d.DesignationName from Employee e join Designation d on e.Designation_ID=d.id");
            ArrayList<Employee> objList = new ArrayList<Employee>();
            while(objResultSet.next()){
                Employee e=new Employee(objResultSet.getString(1) , objResultSet.getString(2) , objResultSet.getString(3) , objResultSet.getLong(4) , objResultSet.getLong(5) , objResultSet.getDate(6),objResultSet.getInt(7),objResultSet.getString(8));
                objList.add(e);
            }
            return objList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void DeletebyName(String Name){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM Employee WHERE Name=?");
            preparedStatement.setString(1, Name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Employee SearchbyName(String Name){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select e.id,e.Name,e.mail,e.Phone_NO,e.CNIC,e.DOB,e.Nationality,d.DesignationName from Employee e join Designation d on e.Designation_ID=d.id where e.Name=?");
            preparedStatement.setString(1,Name);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if (objResultSet != null && objResultSet.next()) {
                Employee e= new Employee(objResultSet.getString(1),objResultSet.getString(2) , objResultSet.getString(3) , objResultSet.getLong(4) , objResultSet.getLong(5) , objResultSet.getDate(6),objResultSet.getInt(7),objResultSet.getString(8));
                return e;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean check_EmployeeID(String id){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Employee where id= ?");
            preparedStatement.setString(1, id);
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
    
    public boolean check_EmployeeName(String Name){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Employee where Name= ?");
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
}
