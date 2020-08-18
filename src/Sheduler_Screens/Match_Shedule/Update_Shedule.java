/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sheduler_Screens.Match_Shedule;

import DatabaseConnectivity.DatabaseConnectivity;
import Psl_Classes.PointsTable;
import Psl_Classes.Season;
import Psl_Classes.SheduleMatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Update_Shedule extends javax.swing.JFrame {

    /**
     * Creates new form Update
     */
    DatabaseConnectivity objConnectivity;
        private Connection connection;
    public Update_Shedule() {
        initComponents();
        objConnectivity=new DatabaseConnectivity();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
        ComboBoxSeason();
        comboTeam();
        ComboBoxStadium();
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
    public void comboTeam(){
        try{
            String query="select  Name from team ";
            connection=objConnectivity.getConnection(); 
            PreparedStatement objPreparedStatement=connection.prepareStatement(query);
            ResultSet objResultSet= objPreparedStatement.executeQuery();
            while(objResultSet.next()){
            
                comboBox_TeamA.addItem(objResultSet.getString("Name"));
                
                comboBox_TeamB.addItem(objResultSet.getString("Name"));
            }
              
        }catch(SQLException e){ 
             e.printStackTrace();
        }    
    }
    
 /*   public void ComboBoxMatch(){
        try{
            FindId_Season();
           connection=objConnectivity.getConnection();
           String query="  select MatchName\n" +
"  from MatchShedule M\n" +
"  join TeamMatch Tm\n" +
"  on  M.MatchId=Tm.SeasonId\n" +
"  where seasonId=?";
           PreparedStatement objPrepareStatement=connection.prepareStatement(query);
           objPrepareStatement.setString(1,Find_Id_Season);
           ResultSet objResult= objPrepareStatement.executeQuery();
           while(objResult.next()){
               String name=objResult.getString("MatchName");
                comboBox_Match.addItem(name);
                   }
        }catch(Exception e){
            e.printStackTrace();
        }
    }  */
   /*  String Find_Id_Match;
    public void FindId_Match(){
        try{
        connection=objConnectivity.getConnection();
        String MatchName=(String) comboBox_Match.getSelectedItem();
        String query="select MatchId from MatchShedule where MatchName= ? ";
        PreparedStatement objPrepareStatement=connection.prepareStatement(query);
        SheduleMatch objShedule=new SheduleMatch();
        objShedule.setMatchName(MatchName);
        objPrepareStatement.setString(1, objShedule.getMatchName());
        ResultSet objResult=objPrepareStatement.executeQuery();
        if(objResult.next()){
            Find_Id_Match=objResult.getString("MatchId");
                   }else{
            JOptionPane.showMessageDialog(this,"Not Found");
        }
             }catch(Exception e){
                    e.printStackTrace();
                }
    } */
     public void ComboBoxStadium(){
        try{
           connection=objConnectivity.getConnection();
           String query="select Name from Stadium";
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
    String teamAId;
        public void get_Selected_Id_TeamA(){
          try{
              String selectedCombo=(String)comboBox_TeamA.getSelectedItem();
            connection=objConnectivity.getConnection();
            String query="Select TeamId from Team where Name=?";
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
            String query="Select TeamId from Team where Name=?";
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
    public void Update(){
             try{
                 
               // FindId_Match();
                FindId_Stadium();
                get_Selected_Id_TeamA();
                get_Selected_Id_TeamB();
            
                
                
           
                connection=objConnectivity.getConnection();
                /*insertion in  TeamMatch*/
                String querySeason="Update  TeamMatch set TeamAId=?,TeamBId=? where MatchId=?";
                PreparedStatement objStatement=connection.prepareStatement(querySeason);
                SheduleMatch objShedule=new SheduleMatch();
                objShedule.setTeamAId(teamAId);
                objShedule.setTeamBId(teamBId);
                objShedule.setMatchId(txt_Id.getText());
              
                objStatement.setString(1,objShedule.getTeamAId());
                objStatement.setString(2,objShedule.getTeamBId());
                objStatement.setString(3,objShedule.getMatchId());
                objStatement.executeUpdate();
                
                /*      Update in shedule  */
                String queryShedule="Update MatchShedule set date=?,time=?,StadiumId=?,MatchType=? where MatchId=? ";
                objStatement=connection.prepareStatement(queryShedule);
                
                objShedule.setTime(txt_Time.getText());
                objShedule.setStadiumId(Find_Id_Stadium);
                objShedule.setMatchType(txt_Match_Type.getText());
                java.util.Date utilStartDate = Date_Chooser.getDate();
                java.sql.Date d = new java.sql.Date(utilStartDate.getTime());
               
        
                objStatement.setDate(1,d);
                objStatement.setString(2,objShedule.getTime());
                objStatement.setString(3,objShedule.getStadiumId());
                objStatement.setString(4,objShedule.getMatchType());
                objStatement.setString(5,objShedule.getMatchId());
                objStatement.executeUpdate();
                JOptionPane.showMessageDialog(this,"Updated Sucessfully");
                
                
                   
         }catch(Exception e){
             e.printStackTrace();
         }
        }
    public void Fill_Fields(){
        try{
            FindId_Season();
            connection=objConnectivity.getConnection();
            String query=" select Sea.seasonname,M.MatchId, M.date,M.Time,S.Name,M.MatchType,T.Name,Td.Name\n" +
                "  from MatchShedule M\n" +
                "  left join Stadium S\n" +
                "  on M.StadiumId=S.StadiumId\n" +
                "  left join \n" +
                "  TeamMatch Tm\n" +
                "  on M.MatchId=Tm.MatchId\n" +
                "  left join Team T\n" +
                "  on T.TeamId=Tm.TeamAId\n" +
                "  full join Team Td\n" +
                "  on Td.TeamId=Tm.TeamBId\n" +
                "  left join Season Sea\n" +
                "  on Sea.seasonId=Tm.seasonId "+
                "  where M.MatchId=? and Sea.SeasonId=?";
            
     PreparedStatement objStatement=connection.prepareStatement(query);
     SheduleMatch objShedule=new SheduleMatch();
     objShedule.setMatchId(txt_Id.getText());
     objShedule.setSeasonId(Find_Id_Season);
     objStatement.setString(1,objShedule.getMatchId());
     objStatement.setString(2,objShedule.getSeasonId());
     ResultSet objResult=objStatement.executeQuery();
     
     /* get Result */
     if(objResult.next()){
     objShedule.setMatchType(objResult.getString("MatchType"));
     objShedule.setStadiumId("Name");
     objShedule.setTeamAId(objResult.getString(7));
     objShedule.setTeamBId(objResult.getString(8));
     objShedule.setTime(objResult.getString("Time"));
     objShedule.setDate(objResult.getDate("Date"));
     /*set Result in text Fields*/
     txt_Match_Type.setText(objShedule.getMatchType());
     String TeamA=objShedule.getTeamAId();
     Object obj=TeamA;
     comboBox_TeamA.setSelectedItem(obj);
     String TeamB=objShedule.getTeamBId();
     obj=TeamB;
     comboBox_TeamB.setSelectedItem(obj);
     txt_Time.setText(objShedule.getTime());
     String Stadium=objShedule.getStadiumId();
     obj=Stadium;
     comboBox_Stadium.setSelectedItem(obj);
     
     Date_Chooser.setDate(objShedule.getDate());
     
     }
     
     
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Points_Table_AutoUpdate(){
        try{
            
            FindId_Season();
            String teamWon=txt_Team.getText();
            
            String query1="select t.Name,p.NumberWins,p.NumberLoss,p.points,p.drawn,p.Noresult,p.netRunRate,s.seasonName\n" +
                          "from pointstable p\n" +
                          "join Team t\n" +
                          "on p.teamId=t.teamId\n" +
                          "join season s\n" +
                          "on s.seasonId=p.SeasonId\n" +
                          "where p.seasonId=? and t.name=? ";
             PreparedStatement objStatement=connection.prepareStatement(query1);
             objStatement.setString(2,teamWon);
             objStatement.setString(1,Find_Id_Season);
             ResultSet objResult=objStatement.executeQuery();
             PointsTable objTable=new PointsTable();
             if(objResult.next()){
           
            objTable.setPoints((objResult.getInt(4)));
            objTable.setDrawn((objResult.getInt("drawn")));
            objTable.setNetRunrate((objResult.getFloat("NetRunRate")));
            objTable.setNoResult((objResult.getInt("NoResult")));
            objTable.setSeasonId(objResult.getString("seasonName"));
            objTable.setTeamId(objResult.getString("Name"));
             }
             
            int points=objTable.getPoints()+2;
            int NumberWins=objTable.getNumberWins()+1;
             objTable.setPoints(points);
             objTable.setNumberWins(NumberWins);
             String queryTeamId="select teamId from team where Name=?";
             objStatement=connection.prepareStatement(queryTeamId);
              objStatement.setString(1,txt_Team.getText());
             objResult=objStatement.executeQuery();
             if(objResult.next()){
             objTable.setTeamId(objResult.getString("teamId"));
             }
           
            String query="Update  pointsTable set points=?, NumberWins=?  where teamId=? and seasonId=?";
            objStatement=connection.prepareStatement(query);
             objStatement.setInt(1,objTable.getPoints());
             objStatement.setInt(2,objTable.getNumberWins());
             objStatement.setString(3,objTable.getTeamId());
             objStatement.setString(4,Find_Id_Season);
             objStatement.executeUpdate();
    
            
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
        jLabel11 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txt_Team = new javax.swing.JTextField();

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
        jLabel2.setText("Update Shedule Match");

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        btn_Save.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Save.setText("Update");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        comboBox_Season.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jLabel10.setText("Enter Match Id");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select Season");

        txt_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IdActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Team Won");

        txt_Team.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TeamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(back)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Date_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(comboBox_Stadium, javax.swing.GroupLayout.Alignment.LEADING, 0, 290, Short.MAX_VALUE)
                                        .addComponent(txt_Time, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBox_TeamB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBox_TeamA, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBox_Season, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(803, 803, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(521, 521, 521))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)
                        .addGap(464, 464, 464))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txt_Match_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(txt_Team, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(jButton1)))
                .addContainerGap(920, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_Season, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Match_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Team, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_TeamA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_TeamB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBox_Stadium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Date_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_Save)
                .addGap(519, 519, 519))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Match_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Match_TypeActionPerformed
        
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
Update();      
Points_Table_AutoUpdate();
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void comboBox_SeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_SeasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_SeasonActionPerformed

    private void comboBox_TeamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TeamBActionPerformed

    }//GEN-LAST:event_comboBox_TeamBActionPerformed

    private void comboBox_TeamAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TeamAActionPerformed
      
    }//GEN-LAST:event_comboBox_TeamAActionPerformed

    private void comboBox_SeasonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_SeasonItemStateChanged
      
        
    }//GEN-LAST:event_comboBox_SeasonItemStateChanged

    private void txt_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdActionPerformed
     
    }//GEN-LAST:event_txt_IdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Fill_Fields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_TeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TeamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TeamActionPerformed

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
            java.util.logging.Logger.getLogger(Update_Shedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Shedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Shedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Shedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Shedule().setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Match_Type;
    private javax.swing.JTextField txt_Team;
    private javax.swing.JTextField txt_Time;
    // End of variables declaration//GEN-END:variables
}
