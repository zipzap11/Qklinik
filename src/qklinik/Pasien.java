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
public class Pasien {
    private String kode;
    private String nama;
    private String umur;
    private String jk;
    private String handphone;
    private String alamat;
    private Obat [] listObat = new Obat[10];
    private int jmlObat;
    private int jmlBerobat;
    
    public Pasien(String kode, String nama, String umur, String jk, String alamat, String handphone, String jmlBerobat) {
        this.kode = kode;
        this.nama = nama;
        this.umur = umur;
        this.jk = jk;
        this.alamat = alamat;
        this.handphone = handphone;
        this.jmlObat = 0;
        this.jmlBerobat = Integer.parseInt(jmlBerobat);
        System.out.println("jml" + jmlBerobat);
    }
    
    public String getKode() {
        return kode;
    }
    public String getNama() {
        return nama;
    }
    public String getUmur() {
        return umur;
    }
    public String getJK() {
        return jk;
    }
    public String getHandphone() {
        return handphone;
    }
    public String getAlamat() {
        return alamat;
    }
    
    public int getJmlBerobat() {
        return jmlBerobat;
    }
    
    public String incrementJmlBerobat() {
        jmlBerobat += 1;
        String data = "jml_berobat='" + getJmlBerobat() + "'";
        String query = "UPDATE tabel_pasien set " + data + " WHERE kode='" + getKode() + "'";
        return query;
    }
    
    public void setKode(String kode) {
        this.kode = kode;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setUmur(String umur) {
        this.umur = umur;
    }
    public void setJK(String jk) {
        this.jk = jk;
    }
    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void tambahListObat(Obat obat) {
        if (jmlObat + 1 > listObat.length) {
            Obat [] temp = listObat;
            listObat = new Obat[listObat.length * 2];
            for (int i = 0; i < temp.length; i++) {
                listObat[i] = temp[i];
            }
        }
        listObat[jmlObat] = obat;
        jmlObat++;
    }
    
    public Obat[] getListObat() {
        return listObat;
    }
}
