/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetfinal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnexion {
    public String url="jdbc:mysql://localhost:3306/Viva_la_villa";
    public String login="root";
    public String pwd="";
    Connection cnx; 
    public static MyConnexion instance;
    private MyConnexion(){
        try {
            cnx =DriverManager.getConnection(url, login, pwd);
            System.out.println("Connection etablie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public Connection getCnx(){
    return cnx;
    }
    public static MyConnexion getInstance(){
    if (instance == null)
    {
        instance = new MyConnexion();
    }
    return instance; 
    }
}

