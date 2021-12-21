/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qklinik;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Admin {
    private final String USERNAME = "Admin";
    private final String PASSWORD = "qklinik1945";
    private boolean isLogin = false; 
    private final Koneksi koneksi = new Koneksi();
    private Pasien pasien;
    private Pembayaran pembayaran;
    
    public boolean login(String username, String password) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            isLogin = true;
            return isLogin;
        }
        return isLogin;
    }
    
    
    public void logout() {
        isLogin = false;
    }
    
    
//    pasien start point
    public boolean tambahPasienBaru(String kode, String name, String age, String gender, String address, String handphone, Component menuutama) {
        String queryKode = "SELECT * FROM tabel_pasien WHERE kode='" + kode + "'";
        boolean isExist = isKodeExist(queryKode, menuutama);
        if (isExist) {
            JOptionPane.showMessageDialog(menuutama, "Kode sudah terpakai.");
            return false;
        }
        String data = "'" + kode + "','" + name + "','" + age + "','" + gender + "','" + address + "','" + handphone + "','" + "0'";
        String query = "INSERT INTO tabel_pasien values (" + data + ")";
        try {
            koneksi.addDataToDB(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(menuutama, "Gagal Koneksi.");
            return false;
        }
    }
    
    private boolean isKodeExist(String query, Component menuutama) {
        try {
            ResultSet result = koneksi.getDataFromDB(query);
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(menuutama, "Gagal koneksi");
        }
        return false;
    }
    
    public Pasien getPasien(String id, Component menuutama) {
        if (pasien != null && pasien.getKode().equals(id)) {
            return pasien;
        }
        pasien = null;
        String query = "SELECT * FROM tabel_pasien WHERE kode='" + id + "'";
        ResultSet result = null;
        try {
            result = koneksi.getDataFromDB(query);
            if (result.next()) {
                String kode = result.getString(1);
                String nama = result.getString(2);
                String umur = result.getString(3);
                String jk = String.valueOf(result.getString(4));
                String alamat = result.getString(5);
                String handphone = result.getString(6);
                String jmlBerobat = result.getString(7);
                pasien = new Pasien(kode, nama, umur, jk, alamat, handphone, jmlBerobat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(menuutama, "Gagal Koneksi");
        }
        return pasien;
    }
    
    public void resetPasien() {
        this.pasien = null;
    }
    
    public boolean updateDataPasien(String nama, String umur, String jk, String alamat, String handphone) {
        pasien.setNama(nama);
        pasien.setUmur(umur);
        pasien.setJK(jk);
        pasien.setAlamat(alamat);
        pasien.setHandphone(handphone);
        String data = "nama='" + nama + "',umur='" + umur + "',jenis_kelamin='" + jk + "',alamat='" + alamat + "'";
        String query = "UPDATE tabel_pasien SET " + data + " WHERE kode=" + "'" + this.pasien.getKode() + "'";
        try {
            koneksi.addDataToDB(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal Koneksi.");
            return false;
        }
    }
//   pasien end point 
    
//    obat start point
    public boolean tambahObatBaru(String kode, String name, String price, Component menuutama) {
        String queryKode = "SELECT * FROM tabel_obat WHERE kode='" + kode + "'";
        boolean isExist = isKodeExist(queryKode, menuutama);
        if (isExist) {
            JOptionPane.showMessageDialog(menuutama, "Kode sudah terpakai.");
            return false;
        }
        String data = "'" + kode +"','" + name + "','" + price + "'";
        String query = "INSERT INTO tabel_obat VALUES (" + data + ")";
        try {
            koneksi.addDataToDB(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal Koneksi.");
            return false;
        }
    }
    
    public boolean updateDataObat(String kode, String nama, String harga) {
        String data = "nama='" + nama + "',harga='" + harga + "'";
        String query = "UPDATE tabel_obat SET " + data + " WHERE kode='" + kode + "'";
        try {
            koneksi.addDataToDB(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Obat getObat(String kode) {
        Obat obat = null;
        String query = "SELECT * FROM tabel_obat WHERE kode='" + kode + "'";
        try {
            ResultSet result = koneksi.getDataFromDB(query);
            if (result.next()) {
                String kodeObat = result.getString(1);
                String namaObat = result.getString(2);
                String hargaObat = result.getString(3);
                obat = new Obat(kodeObat, namaObat, hargaObat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal koneksi.");
        }
            
        return obat;
    }
    
    public ResultSet getListObat() {
        String query = "SELECT * FROM tabel_obat";
        ResultSet result  = null;
        try {
            result = koneksi.getDataFromDB(query);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
// obat end point
    
//    pembayaran start point
    public void setPembayaran(Dokter dokter) {
        pembayaran = new Pembayaran(pasien, pasien.getListObat(), dokter);
    }
    
    public Pembayaran getPembayaran() {
        return pembayaran;
    }
    
    public void resetPembayaran() {
        this.pembayaran = null;
    }
    
    public void incrementBerobat() {
        try {
            String query = pasien.incrementJmlBerobat();
            koneksi.addDataToDB(query);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal increment.");
        }
    }
}
