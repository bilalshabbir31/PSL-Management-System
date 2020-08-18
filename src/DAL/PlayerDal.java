/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Psl_Classes.BidSold;
import Psl_Classes.Category;
import Psl_Classes.Player1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
 
public class PlayerDal{
   private Connection objConnection;

    public PlayerDal(Connection objConnection) {
        this.objConnection=objConnection;
    }
    public void save(Player1 objPlayer1){
    try{
        java.util.Date utilStartDate = objPlayer1.getDob();
        java.sql.Date d = new java.sql.Date(utilStartDate.getTime());
    
            String query="insert into Player(playerid,  Name, mail,Dob, contact,  nationality,Category,Status)values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement=objConnection.prepareStatement(query);                                    
            preparedStatement.setString(1,objPlayer1.getId());
            preparedStatement.setString(2, objPlayer1.getPlayerName());
            preparedStatement.setString(3,objPlayer1.getMail());
            preparedStatement.setDate(4,d);
            preparedStatement.setString(5,objPlayer1.getPhoneNumber());
            preparedStatement.setString(6,objPlayer1.getNationality());
            preparedStatement.setString(7,objPlayer1.getPcategory());
            preparedStatement.setString(8,objPlayer1.getStatus());
            
            preparedStatement.executeUpdate ();    
        }catch(Exception e){
            e.printStackTrace();    
        }
    }
    
    public void Update_Player(Player1 objPlayer1){    
        try{
            
        java.util.Date utilStartDate = objPlayer1.getDob();
        java.sql.Date d = new java.sql.Date(utilStartDate.getTime());
            String query="Update  Player set  Name=?,mail=?,Dob=?,contact=?,nationality=?,category=?,status=? where playerId=? ";
            PreparedStatement preparedStatement=objConnection.prepareStatement(query);                               
            preparedStatement.setString(1,objPlayer1.getPlayerName());
            preparedStatement.setString(2,objPlayer1.getMail());
            preparedStatement.setDate(3,d);
            preparedStatement.setString(4,objPlayer1.getPhoneNumber());
            preparedStatement.setString(5,objPlayer1.getNationality());
            preparedStatement.setString(6,objPlayer1.getPcategory());
            preparedStatement.setString(7,objPlayer1.getStatus());
            preparedStatement.setString(8,objPlayer1.getId());
            preparedStatement.executeUpdate();
             
        }catch(Exception e){
            e.printStackTrace();   
        }
    }
    
public void delete(String id){
       try{
           String query=("delete from Player where Playerid= ? " );
           PreparedStatement preparedStatement=objConnection.prepareStatement(query);
           preparedStatement.setString(1,id);
           preparedStatement.executeUpdate();
           JOptionPane.showMessageDialog(null,"Player deleted");
               }catch(Exception e){
              e.printStackTrace();        
               }
}
      
  
  public void ComboBoxCategory(ArrayList<Category>userList){
        try{
           //String query="select c.categoryName from Category c join Player p on p.Category=c.categoryId";
           String query="select * from Category";
           PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
           ResultSet objResult= objPrepareStatement.executeQuery();
           while(objResult.next()&&objResult!=null){
               Category objCategory=new Category();
               objCategory.setCategoryName(objResult.getString("categoryName"));
                userList.add(objCategory);
                   }
        }catch(Exception e){
            e.printStackTrace();
        }
    } 


      public void FillFields( ArrayList<Player1> userList,String Search){
           try{
        String query="( Select p.playerId,p.Name,p.Nationality,p.Mail,p.Contact,p.dob, C.categoryName from Player P join Category c on c.categoryId=p.Category where p.name= ? )";
        PreparedStatement objPreparedStatement=objConnection.prepareStatement(query);
        objPreparedStatement.setString(1,Search);
        ResultSet objResultSet;  objResultSet = objPreparedStatement.executeQuery();
        if(objResultSet.next()){
        Player1  objplayer=new Player1();
        objplayer.setId(objResultSet.getString("playerId"));
        objplayer.setPlayerName(objResultSet.getString("Name"));
        objplayer.setNationality(objResultSet.getString("Nationality"));
        objplayer.setMail(objResultSet.getString("Mail"));
        objplayer.setPhoneNumber(objResultSet.getString("Contact"));
        objplayer.setDob(objResultSet.getDate("dob"));
        objplayer.setPcategory(objResultSet.getString("categoryName"));
        
        userList.add(objplayer);
        
       }
       
     }catch(Exception e){
         e.printStackTrace();
         
     }
      }
      
      
      
      
       public void view( ArrayList<Player1>userList){
       try{    
         String query="(select p.playerid,p.name,p.mail,p.dob,p.contact,p.nationality,c.CategoryName,p.status\n" +
                        "from Player p \n" +
                        "left join category c\n" +
                        "on p.Category=c.categoryId)";
         PreparedStatement preparedStatement=objConnection.prepareStatement(query);
         ResultSet objResultSet= preparedStatement.executeQuery();
     // ArrayList<Player1>userList=new ArrayList<Player1>();
        while(objResultSet.next()){
         Player1   player=new Player1(objResultSet.getString(1),objResultSet.getString(2),objResultSet.getString(3),objResultSet.getString(5),objResultSet.getString(6),objResultSet.getString(7)); 
      //   player.setDob( objResultSet.getDate("dob"));
          player.setStatus( objResultSet.getString("Status"));
          player.setDob(objResultSet.getDate("dob"));
           userList.add(player);
             
        }
       }catch(Exception e){
            e.printStackTrace();
        }
    }
      
}