/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;


/**
 *
 * @author Hamza
 */
public class Stadium {
    private int id;
    private String name;
    private String area;
    private String Address;
    private int capacity;
    private Date opened;
    private String owner;
    private long phoneno;

    @Override
    public String toString() {
        return "Stadium{" + "id=" + id + ", name=" + name + ", area=" + area + ", Address=" + Address + ", capacity=" + capacity + ", opened=" + opened + ", owner=" + owner + ", phoneno=" + phoneno + '}';
    }

    public Stadium(int id, String name, String area, String Address, int capacity, Date opened, String owner, long phoneno) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.Address = Address;
        this.capacity = capacity;
        this.opened = opened;
        this.owner = owner;
        this.phoneno = phoneno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public Stadium() {
        id=0;
        name="";
        area="";
        Address="";
        capacity=0;
        opened=null;
        owner="";
        phoneno=0;
        
        
    }

  
   
}

        