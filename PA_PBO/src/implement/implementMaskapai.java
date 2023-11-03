/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package implement;
import model.modelMaskapai;


public interface implementMaskapai {
    public void insert(modelMaskapai b);
    public void update(modelMaskapai b);
    public void delete(String ID);
    
    public java.util.List<modelMaskapai> getALL();
    public java.util.List<modelMaskapai> getcariMaskapai(String nama_maskapai);
    
}
