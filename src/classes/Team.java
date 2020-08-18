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
public class Team {
    private int Owner_id;
    private String id,name,mail;
    private String Owner_name;
    private long Office_Contact;
    private Date date;

    public Team(){
        id="";
        Owner_id=0;
        name=mail="";
        Office_Contact=00000;
        date=null;
    }
    
    public Team(String id,String name, String mail, long Office_Contact, Date date, int Owner_id) {
        this.id = id;
        this.Owner_id = Owner_id;
        this.name = name;
        this.mail = mail;
        this.Office_Contact = Office_Contact;
        this.date=new Date(date.getYear(),date.getMonth(),date.getDay());
        this.date = date;
    }
    
    public Team(String id,String name, String mail, long Office_Contact, Date date,String Owner_Name) {
        this.id = id;
        this.Owner_name=Owner_Name;
        this.name = name;
        this.mail = mail;
        this.Office_Contact = Office_Contact;
        this.date=new Date(date.getYear(),date.getMonth(),date.getDay());
        this.date = date;
    }

    @Override
    public String toString() {
        return "Team{" + "Team_id=" + id + ", Owner_Name=" + Owner_name + ", Team_Name=" + name + ",Team_mail=" + mail + ", Office_Contact=" + Office_Contact + ", Founded_date=" + date + '}';
    }

    public String getOwner_name() {
        return Owner_name;
    }

    public void setOwner_name(String Owner_name) {
        this.Owner_name = Owner_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOwner_id() {
        return Owner_id;
    }

    public void setOwner_id(int Owner_id) {
        this.Owner_id = Owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getOffice_Contact() {
        return Office_Contact;
    }

    public void setOffice_Contact(long Office_Contact) {
        this.Office_Contact = Office_Contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
