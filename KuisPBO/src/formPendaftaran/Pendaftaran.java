/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formPendaftaran;
import java.util.Scanner;
/**
 *
 * @author pc msi
 */
public class Pendaftaran implements Form{
    protected float TesTulis, TesCoding, TesWawancara;
    protected String NIK, Nama;
    Scanner input1 = new Scanner(System.in);

    @Override
    public void formInput(){
        System.out.print("Masukan NIK = ");
        NIK = input1.nextLine();
        System.out.print("Masukan Nama = ");
        Nama = input1.nextLine();
        System.out.print("Masukan Nilai Tes Tulis = ");
        TesTulis = input1.nextFloat();
        System.out.print("Masukan Nilai Tes Coding = ");
        TesCoding = input1.nextFloat();
        System.out.print("Masukan Nilai Tes Wawancara = ");
        TesWawancara = input1.nextFloat();
    }
    
    @Override
    public void formEdit(){
        System.out.print("Masukan Nilai Tes Tulis = ");
        TesTulis = input1.nextFloat();
        System.out.print("Masukan Nilai Tes Coding = ");
        TesCoding = input1.nextFloat();
        System.out.print("Masukan Nilai Tes Wawancara = ");
        TesWawancara = input1.nextFloat();
    }
    public String getNIK() {
        return NIK;
    }
    public String getNama() {
        return Nama;
    }
    public float getTesTulis() {
        return TesTulis;
    }
    public float getTesCoding() {
        return TesCoding;
    }
    public float getTesWawancara() {
        return TesWawancara;
    }
}
