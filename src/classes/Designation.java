/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author MUHAMMED BILAL
 */
public class Designation {
    private int id;
    private String DName;

    public Designation() {
        id=0;
        DName=null;
    }

    public Designation(int id, String DName) {
        this.id = id;
        this.DName = DName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }
}
