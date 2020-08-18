/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;

/**
 *
 * @author Obaid Ur Rehman
 */

public class Room {
    
    
    private int id;
    private String playername;
    private String HotelName;
    private String Area;
    private int roomno;
    private Date date;
    private int rentpernight;

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", playername=" + playername + ", HotelName=" + HotelName + ", Area=" + Area + ", roomno=" + roomno + ", date=" + date + ", rentpernight=" + rentpernight + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRentpernight() {
        return rentpernight;
    }

    public void setRentpernight(int rentpernight) {
        this.rentpernight = rentpernight;
    }

    public Room(int id, String playername, String HotelName, String Area, int roomno, Date date, int rentpernight) {
        this.id = id;
        this.playername = playername;
        this.HotelName = HotelName;
        this.Area = Area;
        this.roomno = roomno;
        this.date = date;
        this.rentpernight = rentpernight;
    }

    public Room() {
        
        id=0;
        playername="";
        HotelName="";
        Area="";
        roomno=0;
        date=null;
        rentpernight=0;
        
    }
   

   
   
  
} 