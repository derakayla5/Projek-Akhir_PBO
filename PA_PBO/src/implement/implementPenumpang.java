/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package implement;
import model.modelPenumpang;
/**
 *
 * @author ASUS
 */
public interface implementPenumpang {
    public void insert(modelPenumpang b);
    public void update(modelPenumpang b);
    public void delete(String ID);
    
    public java.util.List<modelPenumpang> getALLPenumpang();
    public java.util.List<modelPenumpang> getcarinama(String namapenumpang);
    
}
