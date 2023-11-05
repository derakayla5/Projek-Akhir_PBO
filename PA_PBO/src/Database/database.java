/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;


public class database {
   private static Connection mysqlconfig;
    public static Connection configDB(){
        try {
            String url = "jdbc:mysql://localhost:3306/bandara";
            String user = "root";
            String password = ""; 
            mysqlconfig = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Koneksi gagal"+e.getMessage());
        }
        return mysqlconfig;
    } 
}
