/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import classes.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MUHAMMED BILAL
 */
public class TeamDal {
    private Connection connection;

    public TeamDal(Connection connection) {
        this.connection = connection;
    }
    public void Add(Team T){
        try{
            String query="insert into Team(TeamId,Name,founded_date,Mail,conatct,Owner_id)values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, T.getId());
            preparedStatement.setString(2,T.getName());
            preparedStatement.setDate(3, T.getDate());
            preparedStatement.setString(4, T.getMail());
            preparedStatement.setLong(5, T.getOffice_Contact());
            preparedStatement.setInt(6,T.getOwner_id());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Succesfully Added!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Update(Team T){
        try{                
            String query="update Team set Name=? ,Mail=? ,conatct=? ,founded_date=? ,Owner_id=? where TeamId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,T.getName());
            preparedStatement.setString(2, T.getMail());
            preparedStatement.setLong(3, T.getOffice_Contact());
            preparedStatement.setDate(4, T.getDate());
            preparedStatement.setInt(5,T.getOwner_id());
            preparedStatement.setString(6, T.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Update Succesfully Added!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Team SearchbyID(String id){
        try{                
            PreparedStatement preparedStatement =connection.prepareStatement("select t.TeamId,t.Name,t.mail,t.conatct,t.founded_date,o.Name from Team t join Owner o on t.Owner_id=o.Owner_Id where t.TeamId=?;");
            preparedStatement.setString(1,id);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if (objResultSet != null && objResultSet.next()) {
                Team T= new Team(objResultSet.getString(1) , objResultSet.getString(2) , objResultSet.getString(3) , objResultSet.getLong(4) , objResultSet.getDate(5) , objResultSet.getString(6));
                return T;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Team SearchbyName(String Name){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select t.TeamId,t.Name,t.mail,t.conatct,t.founded_date,o.Name from Team t join Owner o on t.Owner_id=o.Owner_Id where t.Name=?;");
            preparedStatement.setString(1,Name);
            ResultSet objResultSet = preparedStatement.executeQuery();
            if (objResultSet != null && objResultSet.next()) {
                Team T= new Team(objResultSet.getString(1) , objResultSet.getString(2) , objResultSet.getString(3) , objResultSet.getLong(4) , objResultSet.getDate(5) , objResultSet.getString(6));
                return T;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void DeletebyID(String id){
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM Team WHERE TeamId=?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void DeletebyName(String Name){
        try{
                                
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM Team WHERE Name=?");
            preparedStatement.setString(1, Name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Succefully Deleted!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean check_Team_id(String id){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Team where TeamId = ?");
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
    public boolean check_Team_Name(String Name){
        boolean flag=false;
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Team where Name= ?");
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
    public ArrayList<Team>ViewAll(){
        try{
            Statement objStatement = connection.createStatement();
            ResultSet objResultSet = objStatement.executeQuery("select t.TeamId,t.Name,t.mail,t.conatct,t.founded_date,o.Name from Team t join Owner o on t.Owner_id=o.Owner_Id");
            ArrayList<Team> objList = new ArrayList<Team>();
            while(objResultSet.next()){
                Team T=new Team(objResultSet.getString(1),objResultSet.getString(2),objResultSet.getString(3),objResultSet.getLong(4),objResultSet.getDate(5),objResultSet.getString(6));
                objList.add(T);
            }
            return objList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
