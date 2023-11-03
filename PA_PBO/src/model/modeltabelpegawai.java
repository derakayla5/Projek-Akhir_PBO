/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabelpegawai extends AbstractTableModel {
    List<modelPegawai> listPegawai;
    
    public modeltabelpegawai(List<modelPegawai> listPegawai){
        this.listPegawai = listPegawai;
    }
    
    @Override
    public int getRowCount() {
        return listPegawai.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id pegawai";
            case 1:
                return "nama pegawai";
            case 2:
                return "alamat pegawai";
            case 3:
                return "jabatan";
            default:
                return null;
                
        }
    }
    
    
    @Override
    public Object getValueAt(int row, int column){
        switch (column) {
            case 0:
                return listPegawai.get(row).getId_pegawai();
            case 1:
                return listPegawai.get(row).getNama_pegawai();
            case 2:
                return listPegawai.get(row).getAlamat_pegawai();
            case 3:
                return listPegawai.get(row).getJabatan();
            default:
                return null;
        }
    }
    
    
    
    
    
    
    
    
    
}
