/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;

/**
 *
 * @author Obaid ur Rehman
 */
public class AirLine {
    
    private int seatno;
    private String pname;
    private long phonenum;
    private String airportname;
    private String airlinecompany;
    private String from;
    private String to;
    private Date Flightdate;
    private String departuretime;
    private String  arrivaltime;
    
     public AirLine() {
        
        seatno=0;
        pname="";
        phonenum=0;
        airportname="";
        airlinecompany="";
        from="";
        to="";
        Flightdate=null;
        departuretime="";
        arrivaltime="";
        
        }
      public AirLine(int seatno, String pname, long phonenum, String airportname, String airlinecompany, String from, String to, Date Flightdate, String departuretime, String arrivaltime) {
        this.seatno = seatno;
        this.pname = pname;
        this.phonenum = phonenum;
        this.airportname = airportname;
        this.airlinecompany = airlinecompany;
        this.from = from;
        this.to = to;
        this.Flightdate = Flightdate;
        this.departuretime = departuretime;
        this.arrivaltime = arrivaltime;
    }

  

   

    public int getSeatno() {
        return seatno;
    }

    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = phonenum;
    }

    public String getAirportname() {
        return airportname;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }

    public String getAirlinecompany() {
        return airlinecompany;
    }

    public void setAirlinecompany(String airlinecompany) {
        this.airlinecompany = airlinecompany;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getFlightdate() {
        return Flightdate;
    }

    public void setFlightdate(Date Flightdate) {
        this.Flightdate = Flightdate;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    @Override
    public String toString() {
        return "AirLine{" + "seatno=" + seatno + ", pname=" + pname + ", phonenum=" + phonenum + ", airportname=" + airportname + ", airlinecompany=" + airlinecompany + ", from=" + from + ", to=" + to + ", Flightdate=" + Flightdate + ", departuretime=" + departuretime + ", arrivaltime=" + arrivaltime + '}';
    } 

   
    
    
    
    
    
}
