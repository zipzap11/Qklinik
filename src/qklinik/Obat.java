/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qklinik;

/**
 *
 * @author Asus
 */
public class Obat {
    private String kode;
    private String nama;
    private String harga;
    
    public Obat(String kode, String nama, String harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }
    
    public String getKode() {
        return kode;
    }
    public String getNama() {
        return nama;
    }
    public String getHarga() {
        return harga;
    }
    
    public void setNama(String nama) {
        nama = nama;
    }
    public void setHarga() {
        harga = harga;
    }
}
