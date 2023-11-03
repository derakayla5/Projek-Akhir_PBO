/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package implement;
import model.modelPegawai;
        
        
public interface implementPegawai {
    public void insert(modelPegawai b);
    public void update(modelPegawai b);
    public void delete(String ID);
    
    public java.util.List<modelPegawai> getALLPegawai();
    public java.util.List<modelPegawai> getcariPegawai(String nama_pegawai);
    
}
