/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sheduler_Screens.Match_Shedule;

import DatabaseConnectivity.DatabaseConnectivity;
import Psl_Classes.Season;
import Psl_Classes.SheduleMatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author hp
 */
public class Shedule_Match extends javax.swing.JFrame {

    /**
    
     */
     DatabaseConnectivity objConnectivity;
    private Connection connection;
    public Shedule_Match(){
        initComponents();
        objConnectivity=new DatabaseConnectivity();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
        ComboBoxStadium();
        ComboBoxSeason();
        comboTeam();
        
    }
         public void ComboBoxSeason(){
        try{
           connection=objConnectivity.getConnection();
           String query="select seasonName from Season";
           PreparedStatement objPrepareStatement=connection.prepareStatement(query);
           ResultSet objResult= objPrepareStatement.executeQuery();
           while(objResult.next()){
               String name=objResult.getString("seasonName");
                comboBox_Season.addItem(name);
                   }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
         
    String Find_Id_Season;
    public void FindId_Season(){
        try{
            connection=objConnectivity.getConnection();
        String seasonName=(String) comboBox_Season.getSelectedItem();
        String query="select seasonId from Season where seasonName= ? ";
        PreparedStatement objPrepareStatement=connection.prepareStatement(query);
        Season objSeason=new Season();
        objSeason.setSeasonName(seasonName);
        objPrepareStatement.setString(1, objSeason.getSeasonName());
        ResultSet objResult=objPrepareStatement.executeQuery();
        if(objResult.next()){
            Find_Id_Season=objResult.getString("seasonId");
                   }else{
            JOptionPane.showMessageDialog(this,"Not Found");
        }
             }catch(Exception e){
                    e.printStackTrace();
                }
    }
    
       public void ComboBoxStadium(){
        try{
           connection=objConnectivity.getConnection();
           String query="select name from Stadium";
           PreparedStatement objPrepareStatement=connection.prepareStatement(query);
           ResultSet objResult= objPrepareStatement.executeQuery();
           while(objResult.next()){
               String name=objResult.getString("Name");
                comboBox_Stadium.addItem(name);
                   }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        String Find_Id_Stadium;
    public void FindId_Stadium(){
        try{
            connection=objConnectivity.getConnection();
        String stadiumName=(String) comboBox_Stadium.getSelectedItem();
        String query="select StadiumId from Stadium where Name= ? ";
        PreparedStatement objPrepareStatement=connection.prepareStatement(query);
      //SheduleMatch objShedule=new SheduleMatch();
    
        objPrepareStatement.setString(1,stadiumName);
        ResultSet objResult=objPrepareStatement.executeQuery();
        if(objResult.next()){
            Find_Id_Stadium=objResult.getString("StadiumId");
            }else{
            JOptionPane.showMessageDialog(this,"Not Found");
        }
             }catch(Exception e){
                    e.printStackTrace();
                }
    }
     public void comboTeam(){
        try{
            String query="select  name from team ";
            connection=objConnectivity.getConnection(); 
            PreparedStatement objPreparedStatement=connection.prepareStatement(query);
            ResultSet objResultSet= objPreparedStatement.executeQuery();
            while(objResultSet.next()){
            
                comboBox_TeamA.addItem(objResultSet.getString("name"));
                
                comboBox_TeamB.addItem(objResultSet.getString("name"));
            }
              
        }catch(SQLException e){ 
             e.printStackTrace();
        }    
    }
       String teamAId;
        public void get_Selected_Id_TeamA(){
          try{
              String selectedCombo=(String)comboBox_TeamA.getSelectedItem();
            connection=objConnectivity.getConnection();
            String query="Select TeamId from Team where name=?";
            PreparedStatement objPreparedStatement=connection.prepareStatement(query);
            objPreparedStatement.setString(1,selectedCombo);
            ResultSet objResult=objPreparedStatement.executeQuery();
            
            if(objResult.next()){
            teamAId=(objResult.getString("TeamId"));   
            }
        }catch(SQLException e){   
            e.printStackTrace();
        }
           
    }
         String teamBId;
        public void get_Selected_Id_TeamB(){
          try{
              String selectedCombo=(String)comboBox_TeamB.getSelectedItem();
            connection=objConnectivity.getConnection();
            String query="Select TeamId from Team where name=?";
            PreparedStatement objPreparedStatement=connection.prepareStatement(query);
            objPreparedStatement.setString(1,selectedCombo);
            ResultSet objResult=objPreparedStatement.executeQuery();
            
            if(objResult.next()){
            teamBId=(objResult.getString("TeamId"));   
            }
        }catch(SQLException e){   
            e.printStackTrace();
        }
           
    } 
     
    
        public void Shedule(){
             try{
                 FindId_Season();
                 get_Selected_Id_TeamA();
                 get_Selected_Id_TeamB();
                 
             
                connection=objConnectivity.getConnection();
                
            
                /*      insertion in shedule  */
                String queryShedule="Insert into MatchShedule(MatchId,date,time,StadiumId,MatchType) values(?,?,?,?,?) ";
               SheduleMatch objShedule=new SheduleMatch();
               PreparedStatement objStatement=connection.prepareStatement(queryShedule);
                objShedule.setTime(txt_Time.getText());
                objShedule.setStadiumId(Find_Id_Stadium);
                objShedule.setMatchType(txt_Match_Type.getText());
                objShedule.setMatchId(txt_Match_Id.getText());
              
               
                java.util.Date utilStartDate = Date_Chooser.getDate();
                java.sql.Date d = new java.sql.Date(utilStartDate.getTime());
               
                objStatement.setString(1,objShedule.getMatchId());
                objStatement.setDate(2,d);
                objStatement.setString(3,objShedule.getTime());
                objStatement.setString(4,objShedule.getStadiumId());
                objStatement.setString(5,objShedule.getMatchType());
                objStatement.executeUpdate();
                
                
                /*insertion in  TeamMatch*/
                String querySeason="Insert into TeamMatch(seasonId,TeamAId,TeamBId,MatchId) values(?,?,?,?)";
                objStatement=connection.prepareStatement(querySeason);
                objShedule=new SheduleMatch(txt_Match_Id.getText(),teamAId,teamBId,Find_Id_Season);
          
                objStatement.setString(1,objShedule.getSeasonId());
                objStatement.setString(2,objShedule.getTeamAId());
                objStatement.setString(3,objShedule.getTeamBId());
                objStatement.setString(4,objShedule.getMatchId());
                objStatement.executeUpdate();
                
                
                JOptionPane.showMessageDialog(this,"Match Sheduled Sucessfully");
                   
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

        jPanel1 = new javax.swing.JPanel();
        txt_Match_Type = new javax.swing.JTextField();
        txt_Time = new javax.swing.JTextField();
        comboBox_Stadium = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        btn_Save = new javax.swing.JButton();
        Date_Chooser = new com.toedter.calendar.JDateChooser();
        comboBox_Season = new javax.swing.JComboBox<>();
        comboBox_TeamB = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboBox_TeamA = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_Match_Id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        txt_Match_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Match_TypeActionPerformed(evt);
            }
        });

        txt_Time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TimeActionPerformed(evt);
            }
        });

        comboBox_Stadium.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBox_Stadium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_StadiumActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Match Id");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Team A");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Team B");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Stadium");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Select Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Start Time");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Shedule Match");

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        btn_Save.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Save.setText("Shedule");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        comboBox_Season.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBox_Season.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_SeasonActionPerformed(evt);
            }
        });

        comboBox_TeamB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBox_TeamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_TeamBActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Match Type");

        comboBox_TeamA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBox_TeamA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_TeamAActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select Season");

        txt_Match_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Match_IdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(back)
                        .addGap(371, 371, 371)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(245, 245, 245)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(253, 253, 253)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(253, 253, 253)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBox_TeamB, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox_Stadium, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Date_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox_TeamA, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Match_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Match_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox_Season, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_Season, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Match_Type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Match_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_TeamA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBox_TeamB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_Stadium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Date_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(53, 53, 53)
                .addComponent(btn_Save)
                .addGap(345, 345, 345))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Match_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Match_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Match_TypeActionPerformed

    private void txt_TimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TimeActionPerformed

    private void comboBox_StadiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_StadiumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_StadiumActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Match_Shedule_Menu().setVisible(true);
            }
        });

    }//GEN-LAST:event_backActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
Shedule();     

    }//GEN-LAST:event_btn_SaveActionPerformed

    private void comboBox_SeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_SeasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_SeasonActionPerformed

    private void comboBox_TeamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TeamBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_TeamBActionPerformed

    private void comboBox_TeamAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TeamAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_TeamAActionPerformed

    private void txt_Match_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Match_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Match_IdActionPerformed

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
            java.util.logging.Logger.getLogger(Shedule_Match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Shedule_Match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Shedule_Match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Shedule_Match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Shedule_Match().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_Chooser;
    private javax.swing.JButton back;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox<String> comboBox_Season;
    private javax.swing.JComboBox<String> comboBox_Stadium;
    private javax.swing.JComboBox<String> comboBox_TeamA;
    private javax.swing.JComboBox<String> comboBox_TeamB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_Match_Id;
    private javax.swing.JTextField txt_Match_Type;
    private javax.swing.JTextField txt_Time;
    // End of variables declaration//GEN-END:variables
}
