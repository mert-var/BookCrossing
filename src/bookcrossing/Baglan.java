/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookcrossing;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MERT
 */
public class Baglan {
    
        
        
        static ResultSet Listele(String sorgu) throws SQLException{
            
            
             Class c = null;
        try {
            c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }

        Driver drv = null;
        try {
            drv = (Driver) c.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        String urlsql ="jdbc:sqlserver://127.0.0.1;databaseName=kitaplar; user=root; password=root";
        Connection conn = null;
        try {
            conn = drv.connect(urlsql, null);
        } catch (SQLException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }

           ResultSet rs = null;

        try {   
            rs = stmt.executeQuery(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return rs;
        }
        
        
         static void Guncelle(String sorgu) throws SQLException{
            
            
            Class c = null;
                try {
                     c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                }

                Driver drv = null;
                try {
                    drv = (Driver) c.newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
   
                String urlsql ="jdbc:sqlserver://127.0.0.1;databaseName=kitaplar; user=root; password=root";
                Connection conn = null;
                try {
                    conn = drv.connect(urlsql, null);
                } catch (SQLException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                Statement stmt = null;
                try {
                stmt = conn.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    stmt.executeUpdate(sorgu);
                } catch (SQLException ex) {
                    Logger.getLogger(UyelikForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            
         
        }
    
    
}
