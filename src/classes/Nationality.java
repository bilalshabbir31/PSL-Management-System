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
public class Nationality {
    private int id;
    private String Name;

    public Nationality() {
        id=0;
        Name="";
    }

    public Nationality(int id, String Name) {
        this.id = id;
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Nationality{" + "id=" + id + ", Name=" + Name + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
