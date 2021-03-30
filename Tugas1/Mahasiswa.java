package Tugas1;

import java.util.Scanner;
public class Mahasiswa {
        String namaMahasiswa;
        int nimMahasiswa, usiaMahasiswa, utsMahasiswa, uasMahasiswa;
        float nilaiAkhir;
    
    Mahasiswa(){
        Scanner Input = new Scanner(System.in);
        System.out.println("Input Data===");
        System.out.print("Nama    : ");
        namaMahasiswa=Input.nextLine();
        System.out.print("NIM     : ");
        nimMahasiswa=Input.nextInt();
        System.out.print("Usia    : ");
        usiaMahasiswa=Input.nextInt();
        System.out.print("UTS     : ");
        utsMahasiswa=Input.nextInt();
        System.out.print("UAS     : ");
        uasMahasiswa=Input.nextInt();
    }    
    void hitungRata(){
        nilaiAkhir=(float)(utsMahasiswa+uasMahasiswa)/2;
    }
    void tampilkanData(){
        hitungRata();
        System.out.println(
            "\nHai teman - teman! Perkenalkan Nama Saya " + namaMahasiswa + 
            ", NIM " + nimMahasiswa + 
            "\nUsia : " + usiaMahasiswa +
            "\nNilai akhir :" + nilaiAkhir + "\n");
    }
    void editData(){
        Scanner Input = new Scanner(System.in);
        System.out.println("Input Data===");
        System.out.print("Nama    : ");
        namaMahasiswa=Input.nextLine();
        System.out.print("NIM     : ");
        nimMahasiswa=Input.nextInt();
        System.out.print("Usia    : ");
        usiaMahasiswa=Input.nextInt();
        System.out.print("UTS     : ");
        utsMahasiswa=Input.nextInt();
        System.out.print("UAS     : ");
        uasMahasiswa=Input.nextInt();
    }
}
