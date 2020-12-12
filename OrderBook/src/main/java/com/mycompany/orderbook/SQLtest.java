/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bobur
 */
public class SQLtest {
    
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/orderbook";
        
        String username = "root";
        String password = "MyMomgotGreenCard89$$";
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.format("%S", "Connected to the database");
        } catch (SQLException ex) {
            
            System.out.println("Oops, error!");
            Logger.getLogger(SQLtest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
