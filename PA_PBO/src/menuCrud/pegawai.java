/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuCrud;
import controller.controllerPegawai;
import implement.implementPegawai;
import model.modelPegawai;
import java.util.List;
import gui.Crudpegawai;
import model.modeltabelpegawai;
import javax.swing.JOptionPane;




public class pegawai {
   Crudpegawai frameMenus;
   implementPegawai Implementpegawai;
   List<modelPegawai> listpegawai;
   
    public pegawai(Crudpegawai frameMenu) {
        this.frameMenus = frameMenu;
        Implementpegawai = new controllerPegawai();
        listpegawai = Implementpegawai.getALL();
    }
    
    
     public void reset() {
        frameMenus.getTxtidpegawai().setText("");
        frameMenus.getTxtnamapegawai().setText("");
        frameMenus.getTxtalamatpegawai().setText("");
        frameMenus.getTxtjabatan().setText("");  
    }
     
     public void isiTable(){
        listpegawai = Implementpegawai.getALL();
        modeltabelpegawai mtp = new modeltabelpegawai(listpegawai);
        frameMenus.getTabelModelPegawai().setModel(mtp);
    }
     
     public void isiField (int row) {
        frameMenus.getTxtidpegawai().setText(listpegawai.get(row).getId_pegawai());
        frameMenus.getTxtnamapegawai().setText(listpegawai.get(row).getNama_pegawai());
        frameMenus.getTxtalamatpegawai().setText(listpegawai.get(row).getAlamat_pegawai());
        frameMenus.getTxtjabatan().setText(listpegawai.get(row).getJabatan());
        
    }
     
     public void insert() {
        if(!frameMenus.getTxtidpegawai().getText().trim().isEmpty()&!frameMenus.getTxtnamapegawai().getText().trim().isEmpty()& !frameMenus.getTxtalamatpegawai().getText().trim().isEmpty()& !frameMenus.getTxtjabatan().getText().trim().isEmpty()){
            modelPegawai mp = new modelPegawai();
            mp.setId_pegawai (frameMenus.getTxtidpegawai().getText());
            mp.setNama_pegawai(frameMenus.getTxtnamapegawai().getText());
            mp.setAlamat_pegawai(frameMenus.getTxtalamatpegawai().getText());
            mp.setJabatan(frameMenus.getTxtjabatan().getText());

             
            Implementpegawai.insert(mp);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
        } else {
            JOptionPane.showMessageDialog(frameMenus, "DATA TIDAK BOLEH KOSONG" );
        }
    }
    
     
     
     public void update() {
        if(!frameMenus.getTxtidpegawai().getText().trim().isEmpty()){
            modelPegawai mp = new modelPegawai();
            mp.setId_pegawai (frameMenus.getTxtidpegawai().getText());
            mp.setNama_pegawai(frameMenus.getTxtnamapegawai().getText());
            mp.setAlamat_pegawai(frameMenus.getTxtalamatpegawai().getText());
            mp.setJabatan(frameMenus.getTxtjabatan().getText());
            Implementpegawai.update(mp);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        } else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang akan diupdate");
        }
    }
     
     
     public void delete(){
        if(!frameMenus.getTxtidpegawai().getText().trim().isEmpty()){
            String ID = (frameMenus.getTxtidpegawai().getText());
            Implementpegawai.delete(ID);
        }else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang ingin dihapus");
        }
    }
     
     
     public void isiTabelCariNama(){
        listpegawai = Implementpegawai.getcarinama(frameMenus.getTxtCariNama().getText());
        modeltabelpegawai mtp = new modeltabelpegawai (listpegawai);
        frameMenus.getTabelModelPegawai().setModel(mtp);
    }
     
      public void cariNama(){
        if(!frameMenus.getTxtidpegawai().getText().trim().isEmpty()){
            Implementpegawai.getcarinama(frameMenus.getTxtCariNama().getText());
            isiTabelCariNama();
        } else {
            JOptionPane.showMessageDialog(frameMenus, "Silahkan Pilih Data!");
        }
    }
     
     
     
     
     
     
}
