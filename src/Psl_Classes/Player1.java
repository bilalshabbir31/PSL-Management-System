/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Psl_Classes;

import java.util.Date;

/**
 *
 * @author MUHAMMED BILAL
 */
public class Player1{
    
 

   
  private  String id;
  private  String playerName;
  private  String mail;
  private  Date dob;
  private  String phoneNumber; 
  private String status;
  private String nationality;
  private String Pcategory;
  private String playerType;
  private String Team;
  public Player1(String playerName){
        this.playerName = playerName;
    }

    public Player1() {
    }

    
  
    public Player1(String id, String playerName, String mail, Date dob, String phoneNumber, String nationality, String Pcategory) {
        this.id = id;
        this.playerName = playerName;
        this.mail = mail;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.Pcategory = Pcategory;
    }

    public Player1(String playerName, String phoneNumber, String nationality, String Pcategory) {
        this.playerName = playerName;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.Pcategory = Pcategory;
    }

    public Player1(String playerName, String mail, String phoneNumber, String nationality, String Pcategory) {
        this.playerName = playerName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.Pcategory = Pcategory;
    }
    

    public Player1(String id, String playerName, String mail, String phoneNumber, String nationality, String Pcategory) {
        this.id = id;
        this.playerName = playerName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.Pcategory = Pcategory;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality(){
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPcategory() {
        return Pcategory;
    }

    public void setPcategory(String Pcategory){
        this.Pcategory = Pcategory;
    }
    
    


    
  



}
