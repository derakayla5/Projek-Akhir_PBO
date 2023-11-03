/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.modelMaskapai;
import Database.database;
import java.sql.*;
import implement.implementMaskapai;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;


public class controllerMaskapai implements implementMaskapai{
    Connection connection;
    final String insert = "INSERT INTO maskapai (id_penerbangan, nama_maskapai, kota_keberangkatan, kota_kedatangan, Maskapai_class) VALUES (?,?,?,?,?);";
    final String update = "UPDATE maskapai set nama_maskapai=?, kota_keberangkatan=?, kota_kedatangan=?, Maskapai_class=? WHERE id_penerbangan=?;";
    final String delete = "DELETE FROM maskapai where id_penerbangan=?;";
    final String select = "SELECT * FROM maskapai;";
    final String carimaskapai = "SELECT * FROM maskapai where nama_maskapai like ?";
    
    public controllerMaskapai() {
        connection = database.configDB();
    } 
    
    @Override
    public void insert(modelMaskapai b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( insert);
            statement.setString(1,b.getId_penerbangan());
            statement.setString(2,b.getNama_maskapai());
            statement.setString(3,b.getKota_keberangkatan());
            statement.setString(4,b.getKota_kedatangan());
            statement.setString(5,b.getMaskapai_class());
            
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
    public void update (modelMaskapai b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( update);
            statement.setString(1,b.getNama_maskapai());
            statement.setString(2,b.getKota_keberangkatan());
            statement.setString(3,b.getKota_kedatangan());
            statement.setString(4,b.getMaskapai_class());
            statement.setString(5,b.getId_penerbangan());
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
    public void delete (String id_penerbangan) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, id_penerbangan);
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
    public List<modelMaskapai> getcariMaskapai(String nama_maskapai){
        List<modelMaskapai> lb = null;
        try {
            lb = new ArrayList<modelMaskapai>();
            PreparedStatement st = connection.prepareStatement(carimaskapai);
            st.setString(1,"%" + nama_maskapai + "%" );
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                modelMaskapai mm = new modelMaskapai();
                mm.setId_penerbangan(rs.getString("id_penerbangan"));
                mm.setNama_maskapai(rs.getString("nama_maskapai"));
                mm.setKota_keberangkatan(rs.getString("kota_keberangkatan"));
                mm.setKota_kedatangan(rs.getString("kota_kedatangan"));
                mm.setMaskapai_class(rs.getString("Maskapai_class"));
                lb.add(mm);
            }
        }catch (SQLException ex) {
            Logger.getLogger(controllerMaskapai.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lb;
    }
    
    @Override
    public List<modelMaskapai> getALL(){
        List<modelMaskapai> lb = null;
        try {
            lb = new ArrayList<modelMaskapai>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                modelMaskapai b = new modelMaskapai();
                b.setId_penerbangan(rs.getString("id_penerbangan"));
                b.setNama_maskapai(rs.getString("nama_maskapai"));
                b.setKota_keberangkatan(rs.getString("kota_keberangkatan"));
                b.setKota_kedatangan(rs.getString("kota_kedatangan"));
                b.setMaskapai_class(rs.getString("Maskapai_class"));
                lb.add(b);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllerMaskapai.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lb;
    }

    
}


    





