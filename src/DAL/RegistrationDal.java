/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Psl_Classes.Player1;
import Psl_Classes.PointsTable;
import Psl_Classes.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class RegistrationDal {
    private Connection objConnection;

    public RegistrationDal(Connection objConnection) {
        this.objConnection = objConnection;
    }
    public void ComboBoxTeam(ArrayList<Team> userList){
        try{
            String query="select  name from team ";
            
            PreparedStatement objPreparedStatement=objConnection.prepareStatement(query);
            ResultSet objResultSet= objPreparedStatement.executeQuery();
            while(objResultSet.next()){
                Team objTeam=new Team();
                objTeam.setName(objResultSet.getString("name"));
                userList.add(objTeam);
            
            }
              
        }catch(SQLException e){ 
             e.printStackTrace();
        }
        
        
      
        
    }
    
     public String get_Selected_Id_Team(String Selected){
          try{
             
            String query="Select TeamId from Team where name=?";
            PreparedStatement objPreparedStatement=objConnection.prepareStatement(query);
            objPreparedStatement.setString(1,Selected);
            ResultSet objResult=objPreparedStatement.executeQuery();
            Team objTeam=new Team();
           
            if(objResult.next()){
            objTeam.setTeamId(objResult.getString("TeamId"));  
            return objTeam.getTeamId();
            
            }
        }catch(SQLException e){   
            e.printStackTrace();
        }
           return null;
    }
      public void Save_To_Points_Table(PointsTable objTable){
            try{
                String query="Insert into PointsTable(TeamId,SeasonId)values(?,?) ";
                PreparedStatement objStatement=objConnection.prepareStatement(query);
                objStatement.setString(1,objTable.getTeamId());
                objStatement.setString(2,objTable.getSeasonId());
               
                objStatement.executeUpdate();
                   
            }catch(Exception e){
                e.printStackTrace();
            }
        }
      public void delete_From_Points_Table(PointsTable objTable){
            try{
           
                String query="delete from PointsTable where SeasonId=? and TeamId=?  ";
                PreparedStatement objStatement=objConnection.prepareStatement(query);
                objStatement.setString(1,objTable.getSeasonId());
                objStatement.setString(2,objTable.getTeamId());
                objStatement.executeUpdate();
             
               
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
      public void view( ArrayList<PointsTable>userList){
         try{
         
        String query="select t.name ,s.seasonYear, P.NumberWins,p.NumberLoss,p.points,p.drawn,p.NoResult,P.NetRunRate\n" +
                        "from team t\n" +
                        "join PointsTable P\n" +
                        "on t.TeamId= P.TeamId\n" +
                        "join Season s\n" +
                        "on s.seasonId=p.seasonId";
  
        PreparedStatement objStatement=objConnection.prepareStatement(query);
        ResultSet objResult= objStatement.executeQuery();
       
        while(objResult.next()){
         PointsTable   objTable=new PointsTable();
         objTable.setTeamId(objResult.getString("name"));
         objTable.setNumberWins(objResult.getInt("NumberWins"));
         objTable.setNumberLoss(objResult.getInt("NumberLoss"));
         objTable.setPoints(objResult.getInt("Points"));
      
    
        
         objTable.setSeasonId(objResult.getString("seasonYear"));
          userList.add(objTable);
        }
     
        }catch(Exception e){
            e.printStackTrace();
        }
        
     }
}

