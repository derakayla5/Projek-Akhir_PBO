/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class modeltabelpenumpang extends AbstractTableModel {
    List<modelPenumpang> listPenumpang;
    
    public modeltabelpenumpang(List<modelPenumpang> listPenumpang){
        this.listPenumpang = listPenumpang;
    }
    
    @Override
    public int getRowCount() {
        return listPenumpang.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id penumpang";
            case 1:
                return "nama penumpang";
            case 2:
                return "notelp";
            default:
                return null;
                
        }
    }
    
    
    @Override
    public Object getValueAt(int row, int column){
        switch (column) {
            case 0:
                return listPenumpang.get(row).getId_penumpang();
            case 1:
                return listPenumpang.get(row).getNama_penumpang();
            case 2:
                return listPenumpang.get(row).getNo_telp();
            default:
                return null;
        }
    }
}
