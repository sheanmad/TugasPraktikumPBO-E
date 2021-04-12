/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PraktikumPBO.Tugas2.tugasDua.Bidang;
import PraktikumPBO.Tugas2.tugasDua.Tugas2;
import PraktikumPBO.Tugas2.tugasDua.Ruang.Kerucut;
/**
 *
 * @author pc msi
 */
public class Lingkaran extends Tugas2 implements MenghitungBidang{
    private double jariJari;
    
    public Lingkaran(double jariJari){
        this.jariJari=jariJari;
    }

    public void setjariJari(double jariJari){
        this.jariJari=jariJari;
    }
    
    public double getjariJari(){
        return jariJari;
    }
    
    public double getLuasLingkaran() {
        return 3.14*this.jariJari*this.jariJari;
    }
    public double getKelilingLingkaran() {
        return 2*3.14*this.jariJari;
    }
    @Override
    public void outputTampil1(){
     System.out.print("Luas");
    }
    public void outputTampil2(){
     System.out.print("Keliling");
    }
}
