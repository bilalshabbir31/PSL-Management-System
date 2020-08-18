/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;

/**
 *
 * @author MUHAMMED BILAL
 */
public class Player extends Manager{
    Team t;
    String Pcategory;

    public Player(){
        t=null;
        Pcategory="";
    }

    public Player(int id, String firstname, String lastname, String mail, int phonenumber, int Cnic, Date DOB, String nationality,Team t, String Pcategory) {
        super(id, firstname, lastname, mail, phonenumber, Cnic, DOB, nationality);
        this.t = t;
        this.Pcategory = Pcategory;
    }
    
    
    
    public Team getT() {
        return t;
    }

    public void setT(Team t) {
        this.t = t;
    }

    public String getPcategory() {
        return Pcategory;
    }

    public void setPcategory(String Pcategory) {
        this.Pcategory = Pcategory;
    }
}
