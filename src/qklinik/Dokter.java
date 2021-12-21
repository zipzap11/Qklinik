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
public class Dokter {
    private String nama;
    private final int harga = 100000;
    
    public Dokter(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return this.nama;
    }
    public int getHarga() {
        return this.harga;
    }
}
