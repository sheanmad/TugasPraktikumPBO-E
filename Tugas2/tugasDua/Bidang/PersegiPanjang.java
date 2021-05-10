/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PraktikumPBO.Tugas2.tugasDua.Bidang;
import PraktikumPBO.Tugas2.tugasDua.Tugas2;
import PraktikumPBO.Tugas2.tugasDua.Ruang.Balok;

/**
 *
 * @author pc msi
 */
public class PersegiPanjang extends Tugas2 implements MenghitungBidang{
    private double panjang, lebar;

    public PersegiPanjang(double panjang, double lebar){
        this.panjang=panjang;
        this.lebar=lebar;
    }
    public PersegiPanjang(double panjang){
        this.panjang=panjang;
    }
    public void setPanjang(double panjang){
        this.panjang=panjang;
    }
    
    public double getPanjang(){
        return panjang;
    }
    
    public void setLebar(double lebar){
        this.lebar=lebar;
    }
    
    public double getLebar(){
        return lebar;
    }
    
    public double getLuasPersegi() {
        return this.panjang*this.lebar;
    }
    public double getKelilingPersegi() {
        return (2*this.panjang)+(2*this.lebar);
    }    
    @Override
    public void outputTampil1(){
     System.out.print("Luas");
    }
    public void outputTampil2(){
     System.out.print("Keliling");
    }

}
