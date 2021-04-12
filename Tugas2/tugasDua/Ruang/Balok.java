/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PraktikumPBO.Tugas2.tugasDua.Ruang;
import PraktikumPBO.Tugas2.tugasDua.Tugas2;
/**
 *
 * @author pc msi
 */
public class Balok extends Tugas2 implements MenghitungRuang{
    private double panjang, lebar, tinggi;
    public Balok(double panjang, double lebar, double tinggi){
        this.panjang=panjang;
        this.lebar=lebar;
        this.tinggi=tinggi;
    }
    public double getLuasPermukaanBalok(){
        return 2*(panjang*lebar+lebar*tinggi+panjang*tinggi);
    }
    public double getVolumeBalok(){
        return panjang*lebar*tinggi;
    }
    @Override
    public void outputTampil3(){
     System.out.print("Volume");
    }
    public void outputTampil4(){
     System.out.print("Luas Permukaan");
    }
    
}
