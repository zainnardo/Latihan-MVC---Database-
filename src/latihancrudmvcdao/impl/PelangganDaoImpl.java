/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancrudmvcdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import latihancrudmvcdao.entity.Pelanggan;
import latihancrudmvcdao.error.PelangganException;
import latihancrudmvcdao.service.PelangganDao;

/**
 * @author 
 * 
 * NIM : 10116380
 * NAMA : ZAIN ACHMAD RIZQULLAH
 * KELAS : PBO - 2
 * 
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    
    private final String insterPelanggan = "INSERT INTO PELANGGAN (NAMA,ALAMAT,TELEPON,EMAIL) VALUES (?,?,?,?)";
    
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?,ALAMAT=?,TELEPON=?,EMAIL=? WHERE ID=?"; 
    
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID=?";
    
    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL=?";
    
    private final String selectAll = "SELECT * FROM PELANGGAN";

    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
            try {
                connection.setAutoCommit(false);
                
                statement = connection.prepareStatement(insterPelanggan, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, pelanggan.getNama());
                statement.setString(2, pelanggan.getAlamat());
                statement.setString(3, pelanggan.getTelepon());
                statement.setString(4, pelanggan.getEmail());
                statement.executeUpdate();
                
                ResultSet result = statement.getGeneratedKeys();
                if (result.next()) {
                    pelanggan.setId(result.getInt(1));
                }
                
                connection.commit();
               
        } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                }
            
            throw new PelangganException(e.getMessage());
        }finally{
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                }
                if (statement!=null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                    }         
                }
         }     
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
PreparedStatement statement = null;
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(updatePelanggan);
                statement.setString(1, pelanggan.getNama());
                statement.setString(2, pelanggan.getAlamat());
                statement.setString(3, pelanggan.getTelepon());
                statement.setString(4, pelanggan.getEmail());
                statement.setInt(5,pelanggan.getId());
                statement.executeUpdate();
                connection.commit();
               
        } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                }
            
            throw new PelangganException(e.getMessage());
        }finally{
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                }
                if (statement!=null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                    }         
                }
         }
    }

    @Override
    public void deletePelanggan(Integer id) throws PelangganException {
PreparedStatement statement = null;
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(deletePelanggan);
                statement.setInt(1,id);
                statement.executeUpdate();
                connection.commit();
               
        } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                }
            
            throw new PelangganException(e.getMessage());
        }finally{
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                }
                if (statement!=null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                    }         
                }
         }
    }

    @Override
    public Pelanggan getPelanggan(Integer id) throws PelangganException {
PreparedStatement statement = null;
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(getById);
                statement.setInt(1,id);
                
                ResultSet result = statement.executeQuery();
                Pelanggan pelanggan=null ;
                
                if (result.next()) {
                    pelanggan = new Pelanggan();
                    pelanggan.setId(result.getInt("ID"));
                    pelanggan.setNama(result.getString("NAMA"));
                    pelanggan.setAlamat(result.getString("ALAMAT"));
                    pelanggan.setTelepon(result.getString("TELEPON"));
                    pelanggan.setEmail(result.getString("EMAIL")); 
                } else {
                    throw new PelangganException("Pelanggan dengan id " + id + " tidak ditemukan"); 
                }
                connection.commit();
               return pelanggan;
        } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                }
            
            throw new PelangganException(e.getMessage());
        }finally{
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                }
                if (statement!=null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                    }         
                }
         }
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
        PreparedStatement statement = null;
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(getByEmail);
                statement.setString(1,email);
                
                ResultSet result = statement.executeQuery();
                Pelanggan pelanggan=null ;
                
                if (result.next()) {
                    pelanggan = new Pelanggan();
                    pelanggan.setId(result.getInt("ID"));
                    pelanggan.setNama(result.getString("NAMA"));
                    pelanggan.setAlamat(result.getString("ALAMAT"));
                    pelanggan.setTelepon(result.getString("TELEPON"));
                    pelanggan.setEmail(result.getString("EMAIL")); 
                } else {
                    throw new PelangganException("Pelanggan dengan email " + email + " tidak ditemukan"); 
                }
                connection.commit();
               return pelanggan;
        } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                }
            
            throw new PelangganException(e.getMessage());
        }finally{
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                }
                if (statement!=null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                    }         
                }
         }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        
        Statement statement = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>(); 
        
            try {
                connection.setAutoCommit(false);
                statement = connection.createStatement();
                
                ResultSet result = statement.executeQuery(selectAll);
                Pelanggan pelanggan=null ;
                
                while (result.next()) {
                    pelanggan = new Pelanggan();
                    pelanggan.setId(result.getInt("ID"));
                    pelanggan.setNama(result.getString("NAMA"));
                    pelanggan.setAlamat(result.getString("ALAMAT"));
                    pelanggan.setTelepon(result.getString("TELEPON"));
                    pelanggan.setEmail(result.getString("EMAIL")); 
                    list.add(pelanggan);
                }
                connection.commit();
               return list;
        } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                }
            
            throw new PelangganException(e.getMessage());
        }finally{
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                }
                if (statement!=null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                    }         
                }
         }
        
    }
    
}
