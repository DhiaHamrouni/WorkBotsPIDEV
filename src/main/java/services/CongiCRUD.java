package services;

import utils.MyConnexion;

import java.sql.*;

public class CongiCRUD {

    public String modifcongi(int jours,int id) {
        try {
            String req = "UPDATE `congiet` SET `jours_dispo`=? WHERE id_agent=?";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req);
            pst.setString(1, String.valueOf(jours));
            pst.setString(2, String.valueOf(id));
            pst.executeUpdate();
            return ("les jours de congés sont modifies ");
        }
        catch (SQLException ex){
            return (ex.getMessage());
        }
    }
    public String obtenir_congiet(int id){
        try {
            String req = "SELECT * FROM `congiet` WHERE id_agent=?";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req);
            pst.setString(1, String.valueOf(id));
            ResultSet result = pst.executeQuery(req);
            return (result.getString(3));
        }
        catch (SQLException ex){
            return (ex.getMessage());
        }
    }
}
