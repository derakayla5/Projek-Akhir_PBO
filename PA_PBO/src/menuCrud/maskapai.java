/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuCrud;
import controller.controllerMaskapai;
import implement.implementMaskapai;
import model.modelMaskapai;
import java.util.List;
import gui.CrudMaskapai;
import model.modeltabelmaskapai;
import javax.swing.JOptionPane;


public class maskapai {
    CrudMaskapai frameMenus;
   implementMaskapai Implementmaskapai;
   List<modelMaskapai> listmaskapai;
   
    public maskapai(CrudMaskapai frameMenu) {
        this.frameMenus = frameMenu;
        Implementmaskapai = new controllerMaskapai();
        listmaskapai = Implementmaskapai.getALL();
    }
    
    public void reset() {
        frameMenus.getTxtidpenerbangan().setText("");
        frameMenus.getTxtnamamaskapai().setText("");
        frameMenus.getTxtkotakeberangkatan().setText("");
        frameMenus.getTxtkotakedatangan().setText("");
        frameMenus.getBtnmaskapaiclass().setSelectedItem("-----MASKAPAI CLASS---------");
    }
    
    public void isiTable(){
        listmaskapai = Implementmaskapai.getALL();
        modeltabelmaskapai mtm = new modeltabelmaskapai(listmaskapai);
        frameMenus.getTabelmaskapai().setModel(mtm);
    }
    
    public void isiField (int row) {
        frameMenus.getTxtidpenerbangan().setText(listmaskapai.get(row).getId_penerbangan());
        frameMenus.getTxtnamamaskapai().setText(listmaskapai.get(row).getNama_maskapai());
        frameMenus.getTxtkotakeberangkatan().setText(listmaskapai.get(row).getKota_keberangkatan());
        frameMenus.getTxtkotakedatangan().setText(listmaskapai.get(row).getKota_kedatangan());
        frameMenus.getBtnmaskapaiclass().setSelectedItem(listmaskapai.get(row).getMaskapai_class());
        
    }
    
    public void insert() {
        if(!frameMenus.getTxtidpenerbangan().getText().trim().isEmpty()&!frameMenus.getTxtnamamaskapai().getText().trim().isEmpty()& !frameMenus.getTxtkotakeberangkatan().getText().trim().isEmpty()& !frameMenus.getTxtkotakedatangan().getText().trim().isEmpty()){
            modelMaskapai mm = new modelMaskapai();
            mm.setId_penerbangan (frameMenus.getTxtidpenerbangan().getText());
            mm.setNama_maskapai(frameMenus.getTxtnamamaskapai().getText());
            mm.setKota_keberangkatan(frameMenus.getTxtkotakeberangkatan().getText());
            mm.setKota_kedatangan(frameMenus.getTxtkotakedatangan().getText());
            mm.setMaskapai_class(frameMenus.getBtnmaskapaiclass().getSelectedItem().toString());

             
            Implementmaskapai.insert(mm);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
        } else {
            JOptionPane.showMessageDialog(frameMenus, "DATA TIDAK BOLEH KOSONG" );
        }
    }
    
    public void update() {
        if(!frameMenus.getTxtidpenerbangan().getText().trim().isEmpty()){
            modelMaskapai mm = new modelMaskapai();
            mm.setId_penerbangan (frameMenus.getTxtidpenerbangan().getText());
            mm.setNama_maskapai(frameMenus.getTxtnamamaskapai().getText());
            mm.setKota_keberangkatan(frameMenus.getTxtkotakeberangkatan().getText());
            mm.setKota_kedatangan(frameMenus.getTxtkotakedatangan().getText());
            mm.setMaskapai_class(frameMenus.getBtnmaskapaiclass().getSelectedItem().toString());
            Implementmaskapai.update(mm);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        } else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang akan diupdate");
        }
    }

    
    public void delete(){
        if(!frameMenus.getTxtidpenerbangan().getText().trim().isEmpty()){
            String ID = (frameMenus.getTxtidpenerbangan().getText());
            Implementmaskapai.delete(ID);
        }else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang ingin dihapus");
        }
    }
    
    public void isiTabelCariNama(){
        listmaskapai = Implementmaskapai.getcariMaskapai(frameMenus.getTxtcarimaskapai().getText());
        modeltabelmaskapai mtm = new modeltabelmaskapai (listmaskapai);
        frameMenus.getTabelmaskapai().setModel(mtm);
    }
    
    public void cariNama(){
        if(!frameMenus.getTxtcarimaskapai().getText().trim().isEmpty()){
            Implementmaskapai.getcariMaskapai(frameMenus.getTxtcarimaskapai().getText());
            isiTabelCariNama();
        } else {
            JOptionPane.showMessageDialog(frameMenus, "Silahkan Pilih Data!");
        }
    }
}
