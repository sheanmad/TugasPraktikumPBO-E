/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PraktikumPBO.Tugas2.tugasDua;
import PraktikumPBO.Tugas2.tugasDua.Bidang.PersegiPanjang;
import PraktikumPBO.Tugas2.tugasDua.Ruang.Balok;
import PraktikumPBO.Tugas2.tugasDua.Ruang.Kerucut;
import PraktikumPBO.Tugas2.tugasDua.Bidang.Lingkaran;
import java.util.Scanner;
/**
 *
 * @author pc msi
 */
public class Tugas2 {
     public static void main(String[] args) {
        int menu;
        Scanner Input = new Scanner(System.in);
        
        do{
            System.out.println("INPUT");
            System.out.println("1.Balok");
            System.out.println("2.Kerucut");
            System.out.println("3.Exit");
            System.out.print("Pilih: ");
            menu=Input.nextInt();
            
            if(menu==1){
                double panjang, lebar, tinggi;
                
                System.out.print("Panjang : ");
                panjang=Input.nextDouble();
                System.out.print("Lebar : ");
                lebar=Input.nextDouble();
                System.out.print("Tinggi : ");
                tinggi=Input.nextDouble();
                
                PersegiPanjang a = new PersegiPanjang(panjang, lebar);
                Balok b = new Balok(panjang, lebar, tinggi);
                System.out.println("-----OUTPUT-----");
                a.outputTampil1();
                System.out.println(" Persegi : "+a.getLuasPersegi());
                a.outputTampil2();
                System.out.println(" Persegi : "+a.getKelilingPersegi());
                b.outputTampil3();
                System.out.println(" Persegi : "+b.getVolumeBalok());
                b.outputTampil4();
                System.out.println(" Persegi : "+b.getLuasPermukaanBalok());

            }
            else if(menu==2){
                double jariJari, tinggi;
                
                System.out.print("Jari-Jari : ");
                jariJari=Input.nextDouble();
                System.out.print("Tinggi : ");
                tinggi=Input.nextDouble();
                
                Lingkaran a = new Lingkaran(jariJari);
                Kerucut b = new Kerucut(jariJari, tinggi);
                System.out.println("-----OUTPUT-----");
                a.outputTampil1();
                System.out.println(" Kerucut : "+a.getLuasLingkaran());
                a.outputTampil2();
                System.out.println(" Kerucut : "+a.getKelilingLingkaran());
                b.outputTampil3();
                System.out.println(" Kerucut : "+b.getVolumeKerucut());
                b.outputTampil4();
                System.out.println(" Kerucut : "+b.getLuasPermukaanKerucut());
            
            }
            else {break;}
            
        }while(true);
    }
}
