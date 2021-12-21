/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qklinik;

/**
 *
 * @author qihh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection con;
    private static Statement stm;
    private final String url = "jdbc:mysql://localhost/qklinik";
    private final String user = "root";
    private final String pass = "";
    
    private Connection getConnection() {
        try{
            con = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.err.println("koneksi gagal" +e.getMessage());
            JOptionPane.showMessageDialog(null, "koneksi gagal");
        }
        return con;
    }
    
    
    public ResultSet getDataFromDB(String query) throws SQLException {
        ResultSet result = getConnection().createStatement().executeQuery(query);
        return result;
    }
    
    public void addDataToDB(String query) throws SQLException {
        getConnection().createStatement().executeUpdate(query);
    }
    

    public static void main (String [] args) {
        
    }
    
}
