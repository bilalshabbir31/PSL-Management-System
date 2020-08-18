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
public class Employee {

    private String designation;
    private int iddesignation,nationality;
    private String id,Name, mail;
    private long phonenumber,cnic;
    private Date date;

    public Employee(String id, String Name, String mail, long phonenumber, long cnic, Date date, int nationality,int iddesignation) {
        this.iddesignation = iddesignation;
        this.id = id;
        this.Name = Name;
        this.mail = mail;
        this.nationality = nationality;
        this.phonenumber = phonenumber;
        this.cnic = cnic;
        this.date = date;
    }

    public Employee(String id, String Name, String mail, long phonenumber, long cnic, Date date, int nationality,String designation) {
        this.designation = designation;
        this.id = id;
        this.Name = Name;
        this.mail = mail;
        this.nationality = nationality;
        this.phonenumber = phonenumber;
        this.cnic = cnic;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public long getCnic() {
        return cnic;
    }

    public void setCnic(long cnic) {
        this.cnic = cnic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String EmployeetoString() {
        return  "Designation ! "+"\n"+
                this.getDesignation()+"\n"
                + "ID: "+this.getId()+"\n"
                + "Name: "+this.getName()+"\n"
                + "Mail: "+this.getMail()+"\n"
                + "PhoneNo: "+this.getPhonenumber()+"\n"
                + "CNIC: "+this.getCnic()+"\n"
                + "DOB: "+this.getDate()+"\n"
                + "Nationality: "+this.getNationality();
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }    
       public int getIddesignation() {
        return iddesignation;
    }

    public void setIddesignation(int iddesignation) {
        this.iddesignation = iddesignation;
    }
}
