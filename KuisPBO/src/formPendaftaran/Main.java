/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formPendaftaran;

import java.util.Scanner;
import menuUtama.Menu;

/**
 *
 * @author pc msi
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int menu1, menu2;
        Scanner Input = new Scanner(System.in);
        Pendaftaran objPendaftaran = new Pendaftaran();
        Menu objMenu = new Menu();
        do{
            System.out.println("FORM PENDAFTARAN PT.UDIN");
            System.out.println("1. Android Development");
            System.out.println("2. Web Development");
            System.out.print("Pilih Jenis Form : ");
            menu1=Input.nextInt();
            if(menu1==1){
                objMenu.setValueAndroid();
                do{
                    System.out.println("\nMenu");
                    System.out.println("1. Edit");
                    System.out.println("2. Tampil");
                    System.out.println("3. Exit");
                    System.out.print("Pilih : ");
                    menu2=Input.nextInt();
                    if(menu2==1){
                        objPendaftaran.TesTulis=0;
                        objPendaftaran.TesCoding=0;
                        objPendaftaran.TesWawancara=0;
                        System.out.println("\nFORM EDIT");
                        objMenu.setValueEditAndroid();
                    }
                    else if(menu2==2){
                        objMenu.displayAndroid();
                    }
                    else if(menu2==3){
                        System.exit(0);
                    }
                }while(true);
            }
            else if(menu1==2){
               objMenu.setValueWeb();
                do{
                    System.out.println("\nMenu");
                    System.out.println("1. Edit");
                    System.out.println("2. Tampil");
                    System.out.println("3. Exit");
                    System.out.print("Pilih : ");
                    menu2=Input.nextInt();
                    if(menu2==1){
                        objPendaftaran.TesTulis=0;
                        objPendaftaran.TesCoding=0;
                        objPendaftaran.TesWawancara=0;
                        System.out.println("\nFORM EDIT");
                        objMenu.setValueEditWeb();
                    }
                    else if(menu2==2){
                        objMenu.displayWeb();
                    }
                    else if(menu2==3){
                        System.exit(0);
                    }
                }while(true);
            }
            else{
                System.out.println("Salah Input! Coba Lagi!\n");
            }
        }while(true);
    }
}
