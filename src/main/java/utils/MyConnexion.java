package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnexion {
    public static String url="jdbc:mysql://localhost:3306/viva_la_villa";
    public static String login="root";
    public static String pwd="";
    static Connection cnx;
    public static MyConnexion instance;
    public MyConnexion(){
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