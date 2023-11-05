/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.modelPegawai;
import Database.database;
import java.sql.*;
import implement.implementPegawai;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;



public class controllerPegawai implements implementPegawai {
    Connection connection;
    final String insert = "INSERT INTO pegawai (id_pegawai, nama_pegawai, alamat, jabatan) VALUES (?,?,?,?);";
    final String update = "UPDATE pegawai set nama_pegawai=?, alamat=?, jabatan=? WHERE id_pegawai=?;";
    final String delete = "DELETE FROM pegawai where id_pegawai=?;";
    final String select = "SELECT * FROM pegawai;";
    final String caripegawai = "SELECT * FROM pegawai where nama_pegawai like ?";
    
    public controllerPegawai() {
        connection = database.configDB();
    }
    
    @Override
    public void insert(modelPegawai b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( insert);
            statement.setString(1,b.getId_pegawai());
            statement.setString(2,b.getNama_pegawai());
            statement.setString(3,b.getAlamat_pegawai());
            statement.setString(4,b.getJabatan());
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
    public void update (modelPegawai b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( update);
            statement.setString(1,b.getNama_pegawai());
            statement.setString(2,b.getAlamat_pegawai());
            statement.setString(3,b.getJabatan());
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
    public void delete (String id_pegawai) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, id_pegawai);
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
    public List<modelPegawai> getcarinama(String nama_pegawai){
        List<modelPegawai> lb = null;
        try {
            lb = new ArrayList<modelPegawai>();
            PreparedStatement st = connection.prepareStatement(caripegawai);
            st.setString(1,"%" + nama_pegawai + "%" );
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                modelPegawai mm = new modelPegawai();
                mm.setId_pegawai(rs.getString("id_pegawai"));
                mm.setId_pegawai(rs.getString("nama_pegawai"));
                mm.setId_pegawai(rs.getString("alamat_pegawai"));
                mm.setId_pegawai(rs.getString("jabatan"));
                lb.add(mm);
            }
        }catch (SQLException ex) {
            Logger.getLogger(controllerMaskapai.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lb;
    }
    
    
    
    @Override
    public List<modelPegawai> getALL(){
        List<modelPegawai> lb = null;
        try {
            lb = new ArrayList<modelPegawai>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                modelPegawai b = new modelPegawai();
                b.setId_pegawai(rs.getString("id_pegawai"));
                b.setNama_pegawai(rs.getString("nama_pegawai"));
                b.setAlamat_pegawai(rs.getString("alamat_pegawai"));
                b.setJabatan(rs.getString("jabatan"));
                lb.add(b);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllerMaskapai.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lb;
    }
    
    
    
    
    
    
    
}
