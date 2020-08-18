/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;



/**
 *
 * @author MUHAMMED BILAL
 */
public class Coach extends Manager{
    private String cstatus;
    
    public Coach(){
        cstatus="";
    }

    public Coach(int id,String firstname, String lastname, String mail, int phonenumber, int Cnic, Date DOB,String nationality,String cstatus) {
        super(id,firstname, lastname, mail, phonenumber, Cnic, DOB,nationality);
        this.cstatus = cstatus;
    }
    
    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }
    
}
