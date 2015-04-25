package uyp.j2ee.olshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Koneksi {
    private String url ="jdbc:mysql://localhost:3306/siakad";
    private String user ="root";
    private String password ="password";     
    private Connection connection= null;
    private Statement statement;
    
    public Koneksi() {
        String driver  ="com.mysql.jdbc.Driver";
                
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    protected String getUrl(){
        return this.url;
    }
    
    protected void setUrl(String url){
        this.url = url;
    }

    protected String getUser(){
        return this.user;
    }
    
    protected void setUser(String user){
        this.user = user;
    }
    
    protected String getPassword(){
        return this.password;
    }
    
    protected void setPassword(String password){
        this.password = password;
    }
    
    protected Statement getStatement(){
        return this.statement;
    }
    
    protected ResultSet selectQuery(String query) throws SQLException{
        ResultSet result = statement.executeQuery(query);
        return result;
    }
    
    protected void updateQuery(String query) throws SQLException{
        statement.executeUpdate(query);
    }
}