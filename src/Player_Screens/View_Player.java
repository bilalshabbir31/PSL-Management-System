package Player_Screens;


import Dal.PlayerDal;
import DatabaseConnectivity.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Psl_Classes.Player1;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class View_Player extends javax.swing.JFrame {

    /**
     * Creates new form View_Player
     */
    DatabaseConnectivity objConnection;
    private Connection Connection;
  

    public View_Player() {
        initComponents();
        objConnection=new DatabaseConnectivity();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
     
    }
    public void View_All(  ){
        
    try{    
      
       ArrayList<Player1>  userList=new ArrayList<Player1>();
       PlayerDal objDal=new PlayerDal(objConnection.getConnection());
       objDal.view(userList);
       int i=0;
        while(i<userList.size()){
         
             DefaultTableModel model;
             String[] columnsName ={" id" ,"playerName","mail","Dob"," phone",  "nationality","Category","Status"};
            model = (DefaultTableModel) tbl_Data.getModel();
            Object[] tableLines=new Object[8];
            model.setColumnIdentifiers(columnsName);
      
                
                    tableLines[0]=userList.get(i).getId();
                    tableLines[1]=userList.get(i).getPlayerName();
                    tableLines[2]=userList.get(i).getMail();
                    tableLines[3]=userList.get(i).getDob();
                    tableLines[4]=userList.get(i).getPhoneNumber();
                    tableLines[5]=userList.get(i).getNationality();
                    tableLines[6]=userList.get(i).getPcategory();
                    tableLines[7]=userList.get(i).getStatus();
                    model.addRow(tableLines);
                
      i++;
    }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
  /*  public void View_Name(){
                   try{    
        Connection=objConnection.getConnection();
        String query="(Select *from Player)";
        Statement statement= Connection.createStatement();
        ResultSet objResultSet= statement.executeQuery(query);
      //  ArrayList<Player1>userList=new ArrayList<Player1>();
        while(objResultSet.next()){
         Player1   player=new Player1(objResultSet.getString(2)); 
       //     userList.add(player);
             DefaultTableModel model;
              String[] columnsName = {"Name"};
            model = (DefaultTableModel) tbl_Data.getModel();
            Object[] tableLines=new Object[8];
            model.setColumnIdentifiers(columnsName);
      for(int i=0;i<1;i++)
                {
                    tableLines[0]=player.getPlayerName();
                    model.addRow(tableLines);
                }
    }
        }catch(Exception e){
        }
    }    */
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        view_One_Record = new javax.swing.JButton();
        view_All = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Data = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        view_One_Record.setText("View Name");
        view_One_Record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_One_RecordActionPerformed(evt);
            }
        });
        getContentPane().add(view_One_Record);
        view_One_Record.setBounds(417, 28, 85, 32);

        view_All.setText("View ALL");
        view_All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_AllActionPerformed(evt);
            }
        });
        getContentPane().add(view_All);
        view_All.setBounds(194, 27, 88, 31);
        getContentPane().add(filler1);
        filler1.setBounds(375, 78, 0, 0);

        tbl_Data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(tbl_Data);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 84, 1300, 600);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 10, 90, 31);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void view_AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_AllActionPerformed
      

                    View_All();

        
    }//GEN-LAST:event_view_AllActionPerformed

    private void view_One_RecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_One_RecordActionPerformed
    /*  View_Name();*/
  
    }//GEN-LAST:event_view_One_RecordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Player().setVisible(true);
            }
        });       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Player().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_Data;
    private javax.swing.JButton view_All;
    private javax.swing.JButton view_One_Record;
    // End of variables declaration//GEN-END:variables
}
