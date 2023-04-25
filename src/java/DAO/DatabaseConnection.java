/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Legion
 */
public class DatabaseConnection {

    //This method returns the database connection
    public static Connection getDatabaseConnection() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqaloan", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e.getMessage());
            return null;
        }

    }
}
