
package com.vellu.journaling101;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqlConnection {
    
    Connection con = null;
    
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:MyJournalDB.db");
            System.out.println("You are connected to database.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException e) {
        e.printStackTrace();
    }
        
    
  
    }
    
    public void disconnect() {
        try {
            con.close();
            System.out.println("Database disconnected");
        } catch (SQLException ex) {
            Logger.getLogger(sqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
