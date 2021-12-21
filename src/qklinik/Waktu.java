/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qklinik;

import java.util.Calendar;

/**
 *
 * @author Asus
 */
public class Waktu {
    private String jam;
    private String tanggal;
    
    public Waktu() {
    }
    

    
    public String getJam() {
        Calendar now = Calendar.getInstance();
            int detik = now.get(Calendar.SECOND);
            int menit = now.get(Calendar.MINUTE);
            int jam = now.get(Calendar.HOUR_OF_DAY);
            
            String waktu = "";
            String sec ="";
            String min ="";
            String hour ="";
            
            if (detik <= 9) sec = "0" + detik;
            else sec = "" + detik;
            
            if (menit <= 9) min = "0" + menit;
            else min = "" + menit;
            
            if (jam <= 9) hour = "0" + jam;
            else hour = "" + jam; 
            
            waktu = hour + ":" + min + ":" + sec;
            this.jam = waktu;
            
            return this.jam;
    }
    
    public String getTanggal() {
        Calendar now = Calendar.getInstance();
        
        int tgl = now.get(Calendar.DATE);
        int bulan = now.get(Calendar.MONTH) + 1;
        int tahun = now.get(Calendar.YEAR);
        
        String tanggal = tgl + "-" + bulan + "-" + tahun;
        this.tanggal = tanggal;
        
        return this.tanggal;
    }
}
