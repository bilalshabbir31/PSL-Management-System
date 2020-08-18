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
public class CreateAccount {
    private String id,Username,password;
    private int Designation;
    
    public CreateAccount(){
        id=Username=password="";
        Designation=0;
    }
    
    public CreateAccount(int Designation,String password,String Username,String id) {
        this.id = id;
        this.Username = Username;
        this.password = password;
        this.Designation = Designation;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDesignation() {
        return Designation;
    }

    public void setDesignation(int Designation) {
        this.Designation = Designation;
    }
}
