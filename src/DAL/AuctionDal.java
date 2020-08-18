/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Psl_Classes.BidSold;
import Psl_Classes.Player1;
import Psl_Classes.Season;
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
public class AuctionDal {
    private Connection objConnection;

    public AuctionDal(Connection objConnection) {
        this.objConnection = objConnection;
    }
     public void playerCombo(ArrayList<Player1>userList){
        try{
        String query="Select name from player";
       
        PreparedStatement objPreparedStatement= objConnection.prepareStatement(query);
        ResultSet objResultSet= objPreparedStatement.executeQuery();
         while(objResultSet.next()){
             String name=objResultSet.getString("name");
             Player1 objPlayer=new Player1();
             objPlayer.setPlayerName(name);
             System.out.print(objPlayer.getPlayerName());
             userList.add(objPlayer);
             
        }
         } catch(SQLException e){
        e.printStackTrace();
    }
    }
      public String get_Selected_Id_Player(String selectedCombo){
          try{
              
            String query=" Select PlayerId from Player where name=?";
            PreparedStatement objPreparedStatement=objConnection.prepareStatement(query);
            objPreparedStatement.setString(1,selectedCombo);
            ResultSet objResult=objPreparedStatement.executeQuery();
            if( objResult.next()){
                selectedCombo=(objResult.getString("PlayerId")); 
                System.out.println(selectedCombo);
                return selectedCombo;
            }
        }catch(SQLException e){   
            e.printStackTrace();
        }
          return null;
           
    }
      
    public void Combo_Box_Iem_State_Player(String CategoryName,ArrayList<BidSold> userList){  
        try{
        
       
        String query="Select C.categoryName,p.Category,p.Status\n" +
                     "from Player p\n" + 
                     "join Category c\n" +
                     "on\n" +
                     "c.categoryId=p.Category\n" +
                     "where name=? ";
        PreparedStatement objPreparedStatement=objConnection.prepareStatement(query); 
        objPreparedStatement.setString(1,CategoryName);   
        ResultSet objResult=objPreparedStatement.executeQuery();
        userList.clear();
        if(objResult.next()){
         BidSold objSold=new BidSold();
          objSold.setCategory(objResult.getString("category"));
          objSold.setStatus(objResult.getString("Status"));
          objSold.setCategoryName(objResult.getString("CategoryName"));
            userList.add(objSold);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
         }
    public void Sold(BidSold objAuction,Player1 objPlayer){
        try{
          
          
          String query=("Insert into BidSold(Season_Id,Team_Id,Player_Id,Category) values(?,?,?,?)");
          PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
          objPrepareStatement.setString(1,objAuction.getSeasonId());
          objPrepareStatement.setString(2,objAuction.getTeamId());
          objPrepareStatement.setString(3,objAuction.getPlayerId());
          objPrepareStatement.setString(4,objAuction.getCategory());
          objPrepareStatement.executeUpdate();
          
          String queryPlayerStatus="Update player set Status=? where playerId=?";
          objPrepareStatement=objConnection.prepareStatement(queryPlayerStatus);
          objPrepareStatement.setString(1,objPlayer.getStatus());
          objPrepareStatement.setString(2,objPlayer.getId());
          objPrepareStatement.executeUpdate();
         // ArrayList<BidSold> userList=new ArrayList<BidSold>();
         // userList.add(objAuction);
          
     
          
         ;
      }catch(Exception e){
                 e.printStackTrace();
                  }
}
    public void player_ComboFor_Update(String SeasonName,ArrayList<Player1>userList){
        try{
        String query="select   p.Name,s.seasonName\n" +
                     "  from player p \n" +
                     "  join BidSold B \n" +
                     "  on p.playerId=B.Player_Id \n" +
                     "  join Season s \n" +
                     "  on s.seasonId=B.Season_Id \n" +
                     "  where seasonName=?";
        Season objSeason=new Season();
        objSeason.setSeasonId(SeasonName);
        PreparedStatement objPreparedStatement= objConnection.prepareStatement(query);
        objPreparedStatement.setString(1,objSeason.getSeasonId());
        ResultSet objResultSet= objPreparedStatement.executeQuery();
         while(objResultSet.next()){
             String name=objResultSet.getString("name");
             Player1 objPlayer=new Player1();
             objPlayer.setPlayerName(name);
             System.out.print(objPlayer.getPlayerName());
             userList.add(objPlayer);
             
        }
         } catch(SQLException e){
        e.printStackTrace();
    }
    }
    public void Player_State_Change_Update(String PlayerName,String SeasonName,ArrayList<BidSold>userList){
        try{
        String query="select   c.categoryName,p.Name,s.seasonName,T.Name,T.TeamId\n" +
"                       from player p \n" +
"                       join BidSold B \n" +
"                       on p.playerId=B.Player_Id \n" +
"                       join Season s \n" +
"                       on s.seasonId=B.Season_Id \n" +
"                       join Team T \n" +
"                       on T.teamId=B.team_Id\n" +
"                       join Category c                    \n" +
"                       on c.categoryId=B.Category\n" +
"	                where s.seasonName=? and P.Name=?";
       
   
        BidSold objSold=new BidSold();
        objSold.setPlayerName(PlayerName);
        objSold.setSeasonName(SeasonName);
        PreparedStatement objPreparedStatement= objConnection.prepareStatement(query);
        objPreparedStatement.setString(2,objSold.getPlayerName());
         objPreparedStatement.setString(1,objSold.getSeasonName());
        ResultSet objResultSet= objPreparedStatement.executeQuery();
        userList.clear();
         if(objResultSet.next()){
             BidSold objSold2=new BidSold();
             objSold2.setTeamName(objResultSet.getString(4));
             objSold2.setCategoryName(objResultSet.getString(1));
             userList.add(objSold2);
             
        }
         } catch(SQLException e){
        e.printStackTrace();
    }
    }
    public void Update( BidSold objAuction){
          try{
         
          String query=("update BidSold Set Season_Id=?,Team_Id=? where Player_Id=?");
          PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
          objPrepareStatement.setString(1,objAuction.getSeasonId());
          objPrepareStatement.setString(2,objAuction.getTeamId());
          objPrepareStatement.setString(3,objAuction.getPlayerId());
          objPrepareStatement.executeUpdate();
          
      }catch(Exception e){
                 e.printStackTrace();
                  }
       }
     public void view( ArrayList<BidSold>userList){
         try{
             String query="select  s.seasonname,t.name,p.name,c.CategoryName   from Season s join BidSold  b   on s.SeasonId=b.Season_Id   join Team t  on T.TeamId=b.Team_Id  join player p  on p.playerid=b.player_id join Category C on c.categoryId=B.category";
             PreparedStatement objStatement=objConnection.prepareStatement(query);
             ResultSet objResultSet= objStatement.executeQuery();
             while(objResultSet.next()&&objResultSet!=null){
                 BidSold   objBid=new BidSold(objResultSet.getString(1),objResultSet.getString(2),objResultSet.getString(3),objResultSet.getString(4));
                 userList.add(objBid);
             }  
        }catch(Exception e){
            e.printStackTrace();
        }
     }
     public void delete(BidSold objAuction){
          try{
           
           
           String query=" delete from BidSold   where player_Id=? and season_Id=?";
           PreparedStatement objPreparedStatement=objConnection.prepareStatement(query);
      

           objPreparedStatement.setString(1,objAuction.getPlayerId());
           objPreparedStatement.setString(2,objAuction.getSeasonId());
           objPreparedStatement.executeUpdate();
           String queryPlayerStatus="Update player set Status=? where playerId=?";
       
           objPreparedStatement=objConnection.prepareStatement(queryPlayerStatus);
           objPreparedStatement.setString(1,objAuction.getStatus());
           objPreparedStatement.setString(2,objAuction.getPlayerId());
           objPreparedStatement.executeUpdate();
           
        }catch(SQLException e){   
            e.printStackTrace();
        }           
    }
   
}
