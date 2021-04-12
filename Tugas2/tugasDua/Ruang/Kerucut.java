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
public class Kerucut extends Tugas2 implements MenghitungRuang{
    private double jariJari, tinggi;
    public Kerucut(double jariJari, double tinggi){
        this.jariJari=jariJari;
        this.tinggi=tinggi;
    }
    public double getGarisPelukis(){
        return Math.sqrt((jariJari*jariJari)+(tinggi*tinggi));
    }
    public double getVolumeKerucut(){
        return 3.14*jariJari*jariJari*tinggi*1/3;
    }
    public double getLuasPermukaanKerucut(){
        return (getGarisPelukis()+jariJari)*3.14*jariJari;
    }
    @Override
    public void outputTampil3(){
     System.out.print("Volume");
    }
    public void outputTampil4(){
     System.out.print("Luas Permukaan");
    }
}
