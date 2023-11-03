/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuCrud;
import controller.controllerPenumpang;
import implement.implementPenumpang;
import model.modelPenumpang;
import java.util.List;
import gui.CrudPenumpang;
import model.modeltabelpenumpang;
import javax.swing.JOptionPane;




public class penumpang {
    CrudPenumpang frameMenus;
   implementPenumpang Implementpenumpang;
   List<modelPenumpang> listpenumpang;
    
   public penumpang(CrudPenumpang frameMenu) {
        this.frameMenus = frameMenu;
        Implementpenumpang = new controllerPenumpang();
        listpenumpang = Implementpenumpang.getALLPenumpang();
    }
   
   public void reset() {
        frameMenus.getTxtidpenumpang().setText("");
        frameMenus.getTxtnamapenumpang().setText("");
        frameMenus.getTxtnotelppenumpang().setText("");
        frameMenus.getComboMaskapai().setSelectedItem("---Maskapai---");
        frameMenus.getComboClass().setSelectedItem("---Maskapai class---");
        
    }
     
     public void isiTable(){
        listpenumpang = Implementpenumpang.getALLPenumpang();
        modeltabelpenumpang mtp = new modeltabelpenumpang(listpenumpang);
        frameMenus.getTabelModelPenumpang().setModel(mtp);
    }
   
     
      public void isiField (int row) {
        frameMenus.getTxtidpenumpang().setText(listpenumpang.get(row).getId_penumpang());
        frameMenus.getTxtnamapenumpang().setText(listpenumpang.get(row).getNama_penumpang());
        frameMenus.getTxtnotelppenumpang().setText(listpenumpang.get(row).getNo_telp().toString());
        frameMenus.getComboMaskapai().setSelectedItem(listpenumpang.get(row).getMaskapai());
        frameMenus.getComboClass().setSelectedItem(listpenumpang.get(row).getMaskapai_class());
    }
     
     public void insert() {
        if(!frameMenus.getTxtidpenumpang().getText().trim().isEmpty()&!frameMenus.getTxtnamapenumpang().getText().trim().isEmpty()& !frameMenus.getTxtnotelppenumpang().getText().trim().isEmpty()){
            modelPenumpang mp = new modelPenumpang();
            mp.setId_penumpang(frameMenus.getTxtidpenumpang().getText());
            mp.setNama_penumpang(frameMenus.getTxtnamapenumpang().getText());
            mp.setNo_telp(Integer.parseInt(frameMenus.getTxtnotelppenumpang().getText()));
            mp.setMaskapai(frameMenus.getComboMaskapai().getSelectedItem().toString());
            mp.setMaskapai_class(frameMenus.getComboClass().getSelectedItem().toString());
            
            
            Implementpenumpang.insert(mp);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
        } else {
            JOptionPane.showMessageDialog(frameMenus, "DATA TIDAK BOLEH KOSONG" );
        }
    }
     
     
     
     public void update() {
        if(!frameMenus.getTxtidpenumpang().getText().trim().isEmpty()){
            modelPenumpang mp = new modelPenumpang();
            mp.setId_penumpang(frameMenus.getTxtidpenumpang().getText());
            mp.setNama_penumpang(frameMenus.getTxtnamapenumpang().getText());
            mp.setNo_telp(Integer.parseInt(frameMenus.getTxtnotelppenumpang().getText()));
            mp.setMaskapai(frameMenus.getComboMaskapai().getSelectedItem().toString());
            mp.setMaskapai_class(frameMenus.getComboClass().getSelectedItem().toString());
            Implementpenumpang.update(mp);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        } else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang akan diupdate");
        }
    }
     
     
     public void delete(){
        if(!frameMenus.getTxtidpenumpang().getText().trim().isEmpty()){
            String ID = (frameMenus.getTxtidpenumpang().getText());
            Implementpenumpang.delete(ID);
        }else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang ingin dihapus");
        }
    }
     
       
   
}
