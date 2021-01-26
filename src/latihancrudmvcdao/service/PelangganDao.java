/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancrudmvcdao.service;

import java.util.List;
import latihancrudmvcdao.entity.Pelanggan;
import latihancrudmvcdao.error.PelangganException;

/**
 * @author 
 * 
 * NIM : 10116380
 * NAMA : ZAIN ACHMAD RIZQULLAH
 * KELAS : PBO - 2
 * 
 */
public interface PelangganDao {
    
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public void deletePelanggan(Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan (Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan (String email) throws PelangganException;
    
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;
    
}
