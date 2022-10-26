package com.example.demo2.utils;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {
    private String url = "jdbc:mysql://localhost:3306/viva_la_villa";
    private String user = "root";
    private String pwd = "";
    Connection cnx;

    private static Myconnection myCnx;

    public Myconnection() {
        try {
            cnx = (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getConnection(){
        return cnx;
    }

    public static Myconnection getMyCnx(){
        if(myCnx == null){
            myCnx = new Myconnection();
        }
        return myCnx;
    }

}



