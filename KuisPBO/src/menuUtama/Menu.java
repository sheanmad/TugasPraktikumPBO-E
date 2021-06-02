/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuUtama;
import formPendaftaran.Pendaftaran;
/**
 *
 * @author pc msi
 */
public class Menu extends Pendaftaran implements Kalkulasi, Display {
    float NilaiAkhir;
    @Override
    public void setValueAndroid() {
        super.formInput();
        NilaiAkhir = (float)(super.getTesTulis()*0.2)+(float)(super.getTesCoding()*0.5)+(float)(super.getTesWawancara()*0.3);
    }
    @Override
    public void setValueWeb() {
        super.formInput();
        NilaiAkhir = (float)(super.getTesTulis()*0.4)+(float)(super.getTesCoding()*0.35)+(float)(super.getTesWawancara()*0.25);
    }
    @Override
    public void setValueEditAndroid(){
        super.formEdit();
        NilaiAkhir = (float)(super.getTesTulis()*0.2)+(float)(super.getTesCoding()*0.5)+(float)(super.getTesWawancara()*0.3);
    }
    @Override
    public void setValueEditWeb(){
        super.formEdit();
        NilaiAkhir = (float)(super.getTesTulis()*0.4)+(float)(super.getTesCoding()*0.35)+(float)(super.getTesWawancara()*0.25);
    }
    @Override
    public void displayAndroid(){
        System.out.println("NIK = "+super.getNIK());
        System.out.println("Nama = "+super.getNama());
        System.out.println("Nilai Akhir = "+NilaiAkhir);
        if(NilaiAkhir>=85){
            System.out.println("Keterangan = LOLOS");
            System.out.println("Selamat kepada "+super.getNama()+" telah diterima sebagai Android");
        }
        else if(NilaiAkhir<85){
            System.out.println("Keterangan = GAGAL");
            System.out.println("Mohon maaf kepada "+super.getNama()+" telah ditolak sebagai Android");    
        }
    }
    @Override
    public void displayWeb(){
        System.out.println("NIK = "+super.getNIK());
        System.out.println("Nama = "+super.getNama());
        System.out.println("Nilai Akhir = "+NilaiAkhir);
        if(NilaiAkhir>=85){
            System.out.println("Keterangan = LOLOS");
            System.out.println("Selamat kepada "+super.getNama()+" telah diterima sebagai Web");
        }
        else if(NilaiAkhir<85){
            System.out.println("Keterangan = GAGAL");
            System.out.println("Mohon maaf kepada "+super.getNama()+" telah ditolak sebagai Web");    
        }
    }
}
