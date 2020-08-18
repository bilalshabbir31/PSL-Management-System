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
public class Manager {
    private String firstname,lastname,mail,nationality;
    private Date DOB;
    private int phonenumber;
    private int Cnic;
    private int id;
    
    public Manager(){
        firstname=lastname=mail="";
        DOB=null;
        id=0;
        phonenumber=Cnic=0;
    }

    public Manager(int id,String firstname, String lastname, String mail,int phonenumber,int Cnic, Date DOB,String nationality) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.DOB = DOB;
        this.phonenumber = phonenumber;
        this.Cnic = Cnic;
        this.nationality=nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getCnic() {
        return Cnic;
    }

    public void setCnic(int Cnic) {
        this.Cnic = Cnic;
    }
    
}
