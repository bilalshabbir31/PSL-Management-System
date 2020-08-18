/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import classes.CreateAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author MUHAMMED BILAL
 */
public class CreateAccountDal {
    private Connection Connection;

    public CreateAccountDal(Connection Connection) {
        this.Connection = Connection;
    }
    public void AddAccount(CreateAccount a){
        try{
            String Query="insert into CreateAccount(DesignationID,password,username,Emp_ID)values(?,?,?,?)";
            PreparedStatement preparedStatement=Connection.prepareStatement(Query);
            preparedStatement.setInt(1,a.getDesignation());
            preparedStatement.setString(2,a.getPassword());
            preparedStatement.setString(3,a.getUsername());
            preparedStatement.setString(4,a.getId());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Account Has Been Created! Successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean Check_ID_IS_AlReadyACcount_orNOT(String id){
        boolean flag=false;
            try{
                String Query="select * from CreateAccount where Emp_ID=?";
                PreparedStatement preparedStatement=Connection.prepareStatement(Query);
                preparedStatement.setString(1, id);
                ResultSet objResultSet = preparedStatement.executeQuery();
                if(objResultSet!=null&&objResultSet.next()){
                    flag=true;
                }else{
                    flag=false;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return flag;
    }
    public boolean Check_Username(String Name){
        boolean flag=false;
        try{
            String Query="Select * from CreateAccount where username=?";
            PreparedStatement ps=Connection.prepareStatement(Query);
            ps.setString(1,Name);
            ResultSet rs =ps.executeQuery();
            if(rs!=null && rs.next()){
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public void DeleteAccount(String id){
        try{
            String Query="DELETE FROM CreateAccount WHERE Emp_ID=?";
            PreparedStatement ps=Connection.prepareStatement(Query);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Account Successfully Deleted! ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
