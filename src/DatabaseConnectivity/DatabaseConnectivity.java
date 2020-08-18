/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MUHAMMED BILAL
 */
public final class DatabaseConnectivity{
	public DatabaseConnectivity(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			objConnection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PSL;user=bilaldb;password=bilal123");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

    public Connection getObjConnection() {
        return objConnection;
    }

    public void setObjConnection(Connection objConnection) {
        this.objConnection = objConnection;
    }
	public Connection getConnection(){
		return this.objConnection;
	}
	private Connection objConnection;
}
