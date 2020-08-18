/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Psl_Classes.Category;
import Psl_Classes.Season;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class SeasonDal {
    private Connection objConnection;

    public SeasonDal(Connection objConnection) {
        this.objConnection = objConnection;
    }
    
     public void Create_Season(Season objSeason){
         try{
             
            String query=("Insert into Season(seasonId,seasonName,seasonYear) values(?,?,?)");
            PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
     
            objPrepareStatement.setString(1, objSeason.getSeasonId());
            objPrepareStatement.setString(2,objSeason.getSeasonName());
            objPrepareStatement.setString(3,objSeason.getSeasonYear());
            objPrepareStatement.executeUpdate();
      
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      public void View(ArrayList<Season>userList){
        try{
           
            String query="select *from Season";
            PreparedStatement objStatement=objConnection.prepareStatement(query);
            ResultSet objResult=objStatement.executeQuery();
             while(objResult.next()){
                Season  objSeason=new Season();
                objSeason.setSeasonId(objResult.getString("seasonId"));
                objSeason.setSeasonName(objResult.getString("seasonName"));
                objSeason.setSeasonYear(objResult.getString("seasonYear"));
                
                userList.add(objSeason);
                
        }
        }catch(Exception e){
            
        
    }
      }
         public  void Fill_Season_Combo(ArrayList<Season> objList){
        try{
           String query="select seasonName from Season";
           PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
           ResultSet objResult= objPrepareStatement.executeQuery();
           while(objResult.next()){
               Season objSeason=new Season();
               objSeason.setSeasonName(objResult.getString("SeasonName"));
                objList.add(objSeason);
            
                   }
              
        }catch(Exception e){
            e.printStackTrace();
        }
      
    }
    public String FindId_Season(String seasonName){
        try{
        String query="select seasonId from Season where seasonName= ? ";
        PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
        Season objSeason=new Season();
        objSeason.setSeasonName(seasonName);
        objPrepareStatement.setString(1, objSeason.getSeasonName());
        ResultSet objResult=objPrepareStatement.executeQuery();
        String season_id;
        if(objResult.next()){
            objSeason.setSeasonId(objResult.getString("seasonId"));
            season_id=objSeason.getSeasonId();
            return season_id;
                   }else{
            
        }
             }catch(Exception e){
                    e.printStackTrace();
                }
        return null;
    }
    public void Fill_Fields(String Find_Id_Season,ArrayList<Season> userList){
         try{
         
           String query=("select  seasonName,seasonYear from Season where seasonId=? ");
           PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
           Season objSeason=new Season();
           objSeason.setSeasonId(Find_Id_Season);
           objPrepareStatement.setString(1,objSeason.getSeasonId());
           ResultSet objResult=objPrepareStatement.executeQuery();
           if(objResult.next()){
           objSeason.setSeasonName(objResult.getString("seasonName"));
           objSeason.setSeasonYear((objResult.getString("seasonYear")));
           
           userList.add(objSeason);
               
           }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      
    public void Update( Season objSeason){
    try{
           
            String query=("Update Season set seasonName = ?,seasonYear = ? where SeasonId = ? ");
            PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
          
          //  System.out.println(objSeason.getSeasonName()+objSeason.getSeasonYear());
            objPrepareStatement.setString(1,objSeason.getSeasonName());
            objPrepareStatement.setString(2,objSeason.getSeasonYear());
            objPrepareStatement.setString(3,objSeason.getSeasonId());
            objPrepareStatement.executeUpdate();
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
  
}

