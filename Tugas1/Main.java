package Tugas1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int menu;
        Mahasiswa dataMahasiswa = new Mahasiswa();
        Scanner Input = new Scanner(System.in);
        
        do{
            System.out.print(
                "Opsi===\n"+
                "1. Tampilkan Data\n"+
                "2. Edit Data\n"+
                "3. Exit\n"+
                "Pilih : "
            );
            menu=Input.nextInt();
            
            if(menu==1){dataMahasiswa.tampilkanData();}
            else if(menu==2){dataMahasiswa.editData();}
            else {break;}
            
        }while(true);
    }
}
    