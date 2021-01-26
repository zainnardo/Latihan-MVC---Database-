/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancrudmvcdao.event;

import latihancrudmvcdao.entity.Pelanggan;
import latihancrudmvcdao.model.PelangganModel;

/**
 * @author 
 * 
 * NIM : 10116380
 * NAMA : ZAIN ACHMAD RIZQULLAH
 * KELAS : PBO - 2
 * 
 */
public interface PelangganListener {
    
    public void onChange (PelangganModel model);
    
    public void onInsert (Pelanggan pelanggan);
    
    public void onDelete ();
    
    public void onUpdate (Pelanggan pelanggan);    
    
}
