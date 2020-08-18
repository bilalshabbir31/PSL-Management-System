/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bid_Manager_Screens.Auction_Player;

import Dal.AuctionDal;
import Dal.SeasonDal;
import DatabaseConnectivity.DatabaseConnectivity;
import Psl_Classes.BidSold;
import Psl_Classes.Player1;
import Psl_Classes.Season;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


 
public class delete_Auction_Player extends javax.swing.JFrame {
    DatabaseConnectivity objConnectivity;
    private Connection connection;
    public delete_Auction_Player(){
        initComponents();
        objConnectivity=new DatabaseConnectivity();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         ComboBoxSeason();
        playerCombo();
    }
    
      public void playerCombo(){
        try{
       String Season=(String)comboBox_Season.getSelectedItem();
       AuctionDal objDal=new AuctionDal(objConnectivity.getConnection());
       ArrayList<Player1> userList=new ArrayList<Player1>();
       objDal.player_ComboFor_Update(Season,userList);
       int i=0;
         while(i<userList.size()){
             player_ComboBox.addItem(userList.get(i).getPlayerName());   
             i++;
        }
         } catch(Exception e){
        e.printStackTrace();
    }
    }
      
      
  String CategoryId; 
        public void Combo_Box_Iem_State_Player(){  
        try{
       String SeasonName=(String)comboBox_Season.getSelectedItem();
       String playerName= (String)player_ComboBox.getSelectedItem();
        ArrayList<BidSold> userList=new ArrayList<BidSold>();
        AuctionDal objDal=new AuctionDal(objConnectivity.getConnection());
        objDal.Player_State_Change_Update(playerName,SeasonName,userList);
          int i=0;
        if(i<userList.size()){
            Object obj=userList.get(i).getTeamName();
           
            lbl_CurrentTeam.setText(userList.get(i).getTeamName());
            CategoryId=userList.get(i).getCategory();
            i++;
         }
        
                 }catch(Exception e){
                     e.printStackTrace();
                 } 
   
        } 
       public void ComboBoxSeason(){
        try{
            SeasonDal objDal=new SeasonDal(objConnectivity.getConnection());
            ArrayList<Season> userList=new ArrayList<Season>();
            objDal.Fill_Season_Combo(userList);
           int i=0;
           while(i<userList.size()){
                comboBox_Season.addItem(userList.get(i).getSeasonName());
                i++;
                   }
        }catch(Exception e){
            e.printStackTrace();
        }
    }  
    String Find_Id_Season;
    public void FindId_Season(){
        try{
            String selected=(String)comboBox_Season.getSelectedItem();
            SeasonDal objDal=new SeasonDal(objConnectivity.getConnection());
            Find_Id_Season=objDal.FindId_Season(selected);
             }catch(Exception e){
                    e.printStackTrace();
                }
    }
       String playerId;
       public void get_Selected_Id_Player(){
          try{
              String selectedCombo=(String)player_ComboBox.getSelectedItem();
                AuctionDal objDal=new AuctionDal(objConnectivity.getConnection());
                playerId=objDal.get_Selected_Id_Player(selectedCombo);
        }catch(Exception e){   
            e.printStackTrace();
        }
           
    }
    public void delete(){
          try{
           
           
           BidSold objAuction=new BidSold();
           objAuction.setPlayerId(playerId);
           objAuction.setSeasonId(Find_Id_Season);
           objAuction.setStatus(status);
           AuctionDal objDal=new AuctionDal(objConnectivity.getConnection());
           objDal.delete(objAuction);
     
            JOptionPane.showMessageDialog(this,"Auction deleted Sucessfully");
        }catch(Exception e){    
            e.printStackTrace();
        }           
    }    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        lbl_CurrentTeam = new javax.swing.JLabel();
        player_ComboBox = new javax.swing.JComboBox<>();
        vtn_delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboBox_Season = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Delete_Auction");

        lbl_CurrentTeam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_CurrentTeam.setForeground(new java.awt.Color(255, 255, 255));
        lbl_CurrentTeam.setText("??????");

        player_ComboBox.setToolTipText("");
        player_ComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                player_ComboBoxItemStateChanged(evt);
            }
        });
        player_ComboBox.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                player_ComboBoxitem(evt);
            }
        });
        player_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player_ComboBoxActionPerformed(evt);
            }
        });

        vtn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vtn_delete.setText("Delete");
        vtn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vtn_deleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Select Season");

        comboBox_Season.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox_SeasonItemStateChanged(evt);
            }
        });
        comboBox_Season.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_SeasonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Player");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Current Team");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player_ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_Season, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(lbl_CurrentTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGap(723, 723, 723))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)
                        .addGap(476, 476, 476)
                        .addComponent(jLabel1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(622, 622, 622)
                        .addComponent(vtn_delete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox_Season, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(player_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_CurrentTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(vtn_delete)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void player_ComboBoxitem(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_player_ComboBoxitem

    }//GEN-LAST:event_player_ComboBoxitem

    private void player_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player_ComboBoxActionPerformed
            
    }//GEN-LAST:event_player_ComboBoxActionPerformed

    private void comboBox_SeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_SeasonActionPerformed

    }//GEN-LAST:event_comboBox_SeasonActionPerformed

    private void vtn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vtn_deleteActionPerformed
              
        get_Selected_Id_Player();
        delete();
        player_ComboBox.removeAllItems();
        playerCombo();   
    }//GEN-LAST:event_vtn_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Auction_Player_Menu().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBox_SeasonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_SeasonItemStateChanged
        player_ComboBox.removeAllItems();
        FindId_Season();
        playerCombo();       
   
    }//GEN-LAST:event_comboBox_SeasonItemStateChanged

    private void player_ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_player_ComboBoxItemStateChanged
           Combo_Box_Iem_State_Player();             
       
    }//GEN-LAST:event_player_ComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(delete_Auction_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(delete_Auction_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(delete_Auction_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(delete_Auction_Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new delete_Auction_Player().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox_Season;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_CurrentTeam;
    private java.awt.Panel panel1;
    private javax.swing.JComboBox<String> player_ComboBox;
    private javax.swing.JButton vtn_delete;
    // End of variables declaration//GEN-END:variables
   String status="Available";
   String statusPlayerCombo="Reserved";
  String teamName;
    
}
