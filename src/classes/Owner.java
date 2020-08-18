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
public class Owner {
    private int id,nationality;
    private long cnic,phonenumber;
    private String Name,mail;
    private Date date;

    public Owner(){
        id=nationality=0;
        cnic=phonenumber=0;
        Name=mail="";
        date=null;
    }

    public Owner(int id,String Name, String mail,long phonenumber , long cnic,Date date,int nationality) {
        this.id = id;
        this.cnic = cnic;
        this.phonenumber = phonenumber;
        this.Name = Name;
        this.mail = mail;
        this.nationality = nationality;
        this.date=new Date(date.getYear(),date.getMonth(),date.getDay());
        this.date = date;
    }


    @Override
    public String toString() {
        return "Owner{" + "id=" + id + ", cnic=" + cnic + ", phonenumber=" + phonenumber + ", Name=" + Name + ", mail=" + mail + ", nationality=" + nationality + ", date=" + date + '}';
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCnic() {
        return cnic;
    }

    public void setCnic(long cnic) {
        this.cnic = cnic;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
