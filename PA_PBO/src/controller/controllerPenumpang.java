/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.modelPenumpang;
import Database.database;
import java.sql.*;
import implement.implementPenumpang;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;





public class controllerPenumpang implements implementPenumpang {
    Connection connection;
    final String insert = "INSERT INTO penumpang (id_penumpang, nama_penumpang, no_telp) VALUES (?,?,?);";
    final String update = "UPDATE penumpang set nama_penumpang=?, no_telp=?, WHERE id_penumpang=?;";
    final String delete = "DELETE FROM penumpang where id_penumpang=?;";
    final String select = "SELECT * FROM penumpang;";
    final String caripenumpang = "SELECT * FROM penumpang where nama_penumpang like ?";
    
    public controllerPenumpang() {
        connection = database.configDB();
    }
    
    @Override
    public void insert(modelPenumpang b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( insert);
            statement.setString(1,b.getId_penumpang());
            statement.setString(2,b.getNama_penumpang());
            statement.setInt(3,b.getNo_telp());
            statement.executeUpdate();
            
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    @Override
    public void update (modelPenumpang b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( update);
            statement.setString(1,b.getId_penumpang());
            statement.setString(2,b.getNama_penumpang());
            statement.setInt(3,b.getNo_telp());
            statement.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
     @Override
    public void delete (String id_penumpang) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, id_penumpang);
            statement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    @Override
    public List<modelPenumpang> getcarinama(String nama_penumpang){
        List<modelPenumpang> lb = null;
        try {
            lb = new ArrayList<modelPenumpang>();
            PreparedStatement st = connection.prepareStatement(caripenumpang);
            st.setString(1,"%" + nama_penumpang + "%" );
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                modelPenumpang mp = new modelPenumpang();
                mp.setId_penumpang(rs.getString("id_penumpang"));
                mp.setNama_penumpang(rs.getString("nama_penumpang"));
                mp.setNo_telp(rs.getInt("no_telp"));
                lb.add(mp);
            }
        }catch (SQLException ex) {
            Logger.getLogger(controllerPenumpang.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lb;
    }
    
    
    
    @Override
    public List<modelPenumpang> getALL(){
        List<modelPenumpang> lb = null;
        try {
            lb = new ArrayList<modelPenumpang>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                modelPenumpang b = new modelPenumpang();
                b.setId_penumpang(rs.getString("id_penumpang"));
                b.setNama_penumpang(rs.getString("nama_penumpang"));
                b.setNo_telp(rs.getInt("no_telp"));
                lb.add(b);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllerMaskapai.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lb;
    }
    
}
