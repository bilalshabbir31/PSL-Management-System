/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bid_Manager_Screens.Auction_Player;

import Dal.AuctionDal;
import Dal.RegistrationDal;
import Dal.SeasonDal;
import DatabaseConnectivity.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Psl_Classes.BidSold;
import Psl_Classes.Player1;
import Psl_Classes.Season;
import Psl_Classes.Team;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author hp
 */
public class Update_Auction extends javax.swing.JFrame {

   DatabaseConnectivity objConnectivity;
   private Connection connection;
    public Update_Auction() {
        initComponents();
        objConnectivity=new DatabaseConnectivity();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         ComboBoxTeam();
         ComboBoxSeason();
     
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
    }      String playerId;
        public void get_Selected_Id_Player(){
          try{
              String selectedCombo=(String)player_ComboBox.getSelectedItem();
                AuctionDal objDal=new AuctionDal(objConnectivity.getConnection());
                playerId=objDal.get_Selected_Id_Player(selectedCombo);
        }catch(Exception e){   
            e.printStackTrace();
        }
           
    }
    
        public void ComboBoxTeam(){
        try{
           RegistrationDal objDal=new RegistrationDal(objConnectivity.getConnection());
           ArrayList<Team> userList=new ArrayList<Team>();
           objDal.ComboBoxTeam(userList);
           int i=0;
            while(i<userList.size()){
            
                comboBox_Team.addItem(userList.get(i).getName());
                i++;
            }
              
        }catch(Exception e){ 
             e.printStackTrace();
        }
      
        
    }
        String teamId;
        public void get_Selected_Id_Team(){
          try{
              
            String selectedCombo=(String)comboBox_Team.getSelectedItem();
            RegistrationDal objDal=new RegistrationDal(objConnectivity.getConnection());
             teamId=objDal.get_Selected_Id_Team(selectedCombo);
            
             }catch(Exception e){   
               e.printStackTrace();
        }
           
    }
    
    
        ///////////////////////////////////////////////////////
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
            comboBox_Team.setSelectedItem(obj);
            lbl_Category.setText(userList.get(i).getCategoryName());
            CategoryId=userList.get(i).getCategory();
            i++;
         }
        
                 }catch(Exception e){
                     e.printStackTrace();
                 } 
   
        } 
         
         
       public void Update(){
              try{
          connection=objConnectivity.getConnection();
          FindId_Season();
          get_Selected_Id_Player();
          get_Selected_Id_Team();
         
          BidSold objAuction=new BidSold(Find_Id_Season,playerId,teamId,CategoryId);
          AuctionDal objDal=new AuctionDal(objConnectivity.getConnection());
          objDal.Update(objAuction);
          
          JOptionPane.showMessageDialog(this,"Bid Updated Sucessfully ");
      }catch(Exception e){
                 e.printStackTrace();
                  }
       }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        player_ComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn_Update = new javax.swing.JButton();
        comboBox_Team = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBox_Season = new javax.swing.JComboBox<>();
        lbl_Category = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Auction Player");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Player");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Team");

        btn_Update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Update.setText("Update");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        comboBox_Team.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox_TeamItemStateChanged(evt);
            }
        });
        comboBox_Team.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_TeamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Category");

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

        lbl_Category.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lbl_Category.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Category.setText("Category");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jButton1)
                                .addGap(317, 317, 317))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(player_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBox_Season, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBox_Team, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(lbl_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(602, 602, 602)
                        .addComponent(btn_Update)))
                .addContainerGap(621, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)))
                .addGap(112, 112, 112)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_Season, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox_Team, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btn_Update)
                .addGap(78, 78, 78))
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
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void player_ComboBoxitem(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_player_ComboBoxitem

    }//GEN-LAST:event_player_ComboBoxitem

    private void player_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player_ComboBoxActionPerformed

    }//GEN-LAST:event_player_ComboBoxActionPerformed

    private void comboBox_TeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TeamActionPerformed
    
    }//GEN-LAST:event_comboBox_TeamActionPerformed

    private void comboBox_SeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_SeasonActionPerformed

    }//GEN-LAST:event_comboBox_SeasonActionPerformed

    private void player_ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_player_ComboBoxItemStateChanged
//        get_Selected_Id_Player();
//        get_Team_Id();
//        get_Team_Name();
        
        Combo_Box_Iem_State_Player();
      
       
    }//GEN-LAST:event_player_ComboBoxItemStateChanged

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
          Update();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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

    private void comboBox_TeamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_TeamItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_TeamItemStateChanged

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
            java.util.logging.Logger.getLogger(Update_Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Auction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Update;
    private javax.swing.JComboBox<String> comboBox_Season;
    private javax.swing.JComboBox<String> comboBox_Team;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_Category;
    private java.awt.Panel panel1;
    private javax.swing.JComboBox<String> player_ComboBox;
    // End of variables declaration//GEN-END:variables
   String teamName;
   String categoryName;
   String categoryId;
}
