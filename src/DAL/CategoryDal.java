/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Psl_Classes.BidSold;
import Psl_Classes.Category;
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
public class CategoryDal {
    private Connection objConnection;

    public CategoryDal(Connection objConnection) {
        this.objConnection = objConnection;
    }
    public void Create_Category(Category objCategory){
         try{
             
            String query=("Insert into Category(categoryId,categoryName,price,year) values(?,?,?,?)");
            PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
            objPrepareStatement.setString(1,objCategory.getCategoryId());
            objPrepareStatement.setString(2,objCategory.getCategoryName());
            objPrepareStatement.setLong(3,objCategory.getCategoryPrice());
            objPrepareStatement.setString(4,objCategory.getYear());
            objPrepareStatement.executeUpdate();
            
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
public  ArrayList<Category>FillFields(String Find_Id_Category){
         try{
            ArrayList<Category> objList=new ArrayList<Category>();
            String query=("select categoryId,categoryName,price,year from Category where categoryId=? ");
            PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
            Category objCategory=new Category();
           objCategory.setCategoryId(Find_Id_Category);
           objPrepareStatement.setString(1,objCategory.getCategoryId());
           ResultSet objResult=objPrepareStatement.executeQuery();
           if(objResult.next()){
           objCategory.setCategoryName(objResult.getString("categoryName"));
           objCategory.setCategoryPrice(Integer.parseInt(objResult.getString("price")));
           objCategory.setYear(objResult.getString("Year"));
           objCategory.setCategoryId(objResult.getString("categoryId"));
        
            objList.add(objCategory);
              }
           return objList;
        }catch(Exception e){
            e.printStackTrace();
        }
         return null;
    }
  public  void CategoryComoBox(ArrayList<Category> objList){
        try{
           String query="select categoryName from Category";
           PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
           ResultSet objResult= objPrepareStatement.executeQuery();
        
           while(objResult.next()){
               Category objCategory=new Category();
               objCategory.setCategoryName(objResult.getString("categoryName"));
             
               
                objList.add(objCategory);
            
                   }
              
        }catch(Exception e){
            e.printStackTrace();
        }
      
    } 
  
    public String FindId_Category(String categoryName){
        try{
         
        String query="select categoryId from Category where categoryName=?";
        PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
        
        objPrepareStatement.setString(1,categoryName);
        ResultSet objResult=objPrepareStatement.executeQuery();
        String id;
        if(objResult.next()){
      
            id=objResult.getString("categoryId");
     
            return id;
                   }
       
             }catch(Exception e){
                    e.printStackTrace();
                }
        return null;
          
    }
    
    public void Fill_Fields( ArrayList<Category> objList,String Find_Id_Category){
         try{
             
           
            String query=("select categoryId,categoryName,price,year from Category where categoryId=? ");
            PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
           objPrepareStatement.setString(1,Find_Id_Category);
           ResultSet objResult=objPrepareStatement.executeQuery();
           if(objResult.next()){
               Category objCategory=new Category();
           objCategory.setCategoryName(objResult.getString("categoryName"));
           objCategory.setCategoryPrice(Integer.parseInt(objResult.getString("price")));
           objCategory.setYear(objResult.getString("Year"));
          objCategory.setCategoryId(objResult.getString("categoryId"));
         
          objList.add(objCategory);
          
            
              }
        }catch(Exception e){
            e.printStackTrace();
        }
    }  
     
      public void Update(Category objCategory){
    try{
           
            String query=("Update Category  set price = ? ,year=? where categoryName = ? ");
            PreparedStatement objPrepareStatement=objConnection.prepareStatement(query);
        
            objPrepareStatement.setLong(1,objCategory.getCategoryPrice());
            objPrepareStatement.setString(2,objCategory.getYear());
            objPrepareStatement.setString(3,objCategory.getCategoryName());
            objPrepareStatement.executeUpdate();
   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      
         public void delete(String categoryId){
        try{
       Category objCategory=new Category();
        objCategory.setCategoryId(categoryId);
        String query="delete from Category where categoryId=?";
        PreparedStatement objStatement=objConnection.prepareStatement(query);
        objStatement.setString(1,objCategory.getCategoryId());
        objStatement.executeUpdate();
     
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
         
    public void View(ArrayList<Category>userList){
        try{
           
            String query="select *from Category";
            PreparedStatement objStatement=objConnection.prepareStatement(query);
            ResultSet objResult=objStatement.executeQuery();
            
             while(objResult.next()){
                Category  objCategory=new Category();
                objCategory.setCategoryId(objResult.getString("categoryId"));
                objCategory.setCategoryName(objResult.getString("categoryname"));
                objCategory.setCategoryPrice(Integer.parseInt(objResult.getString("price")));
                objCategory.setYear(objResult.getString("year"));
                
                userList.add(objCategory);
             }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    
     
}

