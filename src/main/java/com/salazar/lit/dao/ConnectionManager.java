/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.dao;

/**
 *
 * @author Johnny
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Johnny
 */
public class ConnectionManager {
    
    public static Connection getConnection() {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/Master Canada Lit Inv.", "postgres",
                    "Primetime21");
            System.out.println("Connection successful");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
        
        return connection;
    }
}