/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qklinik;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Pembayaran {
    private Pasien pasien;
    private Obat [] listObat;
    private int uangPembayaran = 0;
    private int kembalian;
    private int totalHarga = 0;
    private Dokter dokter;
    
    public Pembayaran(Pasien pasien, Obat[] listObat, Dokter dokter) {
        this.listObat = listObat;
        this.pasien = pasien;
        this.dokter = dokter;
        for (Obat obat : listObat) {
            if (obat != null) {
                totalHarga += Integer.parseInt(obat.getHarga());
            }
        }
        totalHarga += dokter.getHarga();
    }
    
    public int getTotalHarga() {        
        return totalHarga;
    }
    
    public void setUangPembayaran(int nominal) {
        uangPembayaran = nominal;
    }
    
    public int getKembalian() {
        System.out.println("Uang pembayran :=" + uangPembayaran);
        System.out.println("totalharga :=" + totalHarga);
        kembalian = uangPembayaran - totalHarga;
        System.out.println("Pembayaran.java Kembalian = " + kembalian);
        return kembalian;
    }
    
    public Pasien getPasien() {
        return this.pasien;
    }
    
    public Obat[] getListObat() {
        return listObat;
    }
    
    public Dokter getDokter() {
        return dokter;
    }
}
