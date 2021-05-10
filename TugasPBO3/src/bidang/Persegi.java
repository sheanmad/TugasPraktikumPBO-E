/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bidang;

/**
 *
 * @author pc msi
 */
public class Persegi implements MenghitungBidang{
    double panjang, lebar;
    private double kelilingPersegi;
    private double luasPersegi;
    
    public Persegi(double panjang, double lebar){
        this.panjang=panjang;
        this.lebar=lebar;
    }

    public double getKelilingPersegi() {
        return kelilingPersegi;
    }

    public double getLuasPersegi() {
        return luasPersegi;
    }
    
    @Override
    public void hitungKeliling() 
    {
        kelilingPersegi = 2*(panjang+lebar);
    }
    @Override
    public void hitungLuas() 
    {
        luasPersegi = panjang*lebar;
    }
    public void hitungPersegi(){
        hitungKeliling();
        hitungLuas();
    }
}
