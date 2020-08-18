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
public class Dates {
    private int year,month,day;

    public Dates(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Dates() {
        year=month=day=0;
    }

    public String getDate(){
        return year+"-"+month+"-"+day;
    }
    public Date Date(){
        Date d1=new Date(getYear(), getMonth(),getDay());
        return d1;
    }
    public Dates(Date date) {
        this.year=date.getYear();
        this.month=date.getMonth();
        this.day=date.getDay();
    }

    @Override
    public String toString() {
        return "Date{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
