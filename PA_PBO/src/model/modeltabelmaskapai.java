/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabelmaskapai extends AbstractTableModel {
    
    List<modelMaskapai> listMaskapai;
    
    public modeltabelmaskapai(List<modelMaskapai> listMaskapai){
        this.listMaskapai = listMaskapai;
    }
    
    @Override
    public int getRowCount() {
        return listMaskapai.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id penerbangan";
            case 1:
                return "nama maskapai";
            case 2:
                return "kota keberangkatan";
            case 3:
                return "kota kedatangan";
            case 4:
                return "Maskapai Class";
            default:
                return null;
                
        }
    }
    
    @Override
    public Object getValueAt(int row, int column){
        switch (column) {
            case 0:
                return listMaskapai.get(row).getId_penerbangan();
            case 1:
                return listMaskapai.get(row).getNama_maskapai();
            case 2:
                return listMaskapai.get(row).getKota_keberangkatan();
            case 3:
                return listMaskapai.get(row).getKota_kedatangan();
            case 4:
                return listMaskapai.get(row).getMaskapai_class();
            default:
                return null;
        }
    }
    
}
