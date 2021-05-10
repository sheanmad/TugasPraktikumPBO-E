/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruang;
import bidang.Persegi;
/**
 *
 * @author pc msi
 */
public class Balok extends Persegi implements MenghitungRuang{
    double tinggi;
    protected double volumeBalok;
    protected double luasPermukaanBalok;
    
    public Balok(double panjang, double lebar, double tinggi){
        super(panjang, lebar);
        this.tinggi=tinggi;
    }

    public double getVolumeBalok() {
        return volumeBalok;
    }

    public double getLuasPermukaanBalok() {
        return luasPermukaanBalok;
    }
    
    @Override
    public void hitungVolume() 
    {
        volumeBalok = super.getLuasPersegi()*tinggi;
    }
    @Override
    public void hitungLuasPermukaan() 
    {
        luasPermukaanBalok = 2*super.getLuasPersegi()+super.getKelilingPersegi()*tinggi;
    }
    public void hitungBalok(){
        super.hitungPersegi();
        hitungVolume();
        hitungLuasPermukaan();   
    }
}
