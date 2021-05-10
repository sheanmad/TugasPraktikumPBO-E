/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspbo3;
import ruang.Balok;
import javax.swing.*;
import java.awt.event.*;

public class Main{
  public static void main(String[] args) {  
    GUI gui = new GUI();    
  }
}
    class GUI extends JFrame implements ActionListener{
        
        JLabel LayoutJudul = new JLabel("Kalkulator Balok");
        
        JLabel LayoutPanjang = new JLabel("Panjang");
        final JTextField FillPanjang = new JTextField();
        
        JLabel LayoutLebar = new JLabel("Lebar");
        final JTextField FillLebar = new JTextField();
        
        JLabel LayoutTinggi = new JLabel("Tinggi");
        final JTextField FillTinggi = new JTextField();
        
        JButton ButtonHitung = new JButton("Hitung");
        JButton ButtonReset = new JButton("Reset");
        
        JLabel LayoutHasil = new JLabel("Hasil: ");
        
        JLabel LayoutLuasPersegi = new JLabel("Luas Persegi: ");
        JLabel FillLuasPersegi = new JLabel("0");
        
        JLabel LayoutKelilingPersegi = new JLabel("Keliling Persegi: ");
        JLabel FillKelilingPersegi = new JLabel("0");
        
        JLabel LayoutVolumeBalok = new JLabel("Volume Balok: ");
        JLabel FillVolumeBalok = new JLabel("0");
        
        JLabel LayoutLuasPermukaanBalok = new JLabel("Luas Permukaan Balok: ");
        JLabel FillLuasPermukaanBalok = new JLabel("0");
        
        public GUI(){
            setTitle("Kalkulator Balok");
            setSize(350, 300);

            setLayout(null);
            add(LayoutJudul);
            add(LayoutPanjang);
            add(FillPanjang);
            add(LayoutLebar);
            add(FillLebar);
            add(LayoutTinggi);
            add(FillTinggi);
            add(LayoutHasil);
            add(LayoutLuasPersegi);
            add(LayoutKelilingPersegi);
            add(LayoutVolumeBalok);
            add(LayoutLuasPermukaanBalok);
            add(FillLuasPersegi);
            add(FillKelilingPersegi);
            add(FillVolumeBalok);
            add(FillLuasPermukaanBalok);
            add(ButtonHitung);
            add(ButtonReset);

            LayoutJudul.setBounds(120,10,120,20);
            LayoutPanjang.setBounds(10,50,120,20);
            FillPanjang.setBounds(130,50,150,20);
            LayoutLebar.setBounds(10,70,120,20);
            FillLebar.setBounds(130,70,150,20);
            LayoutTinggi.setBounds(10,90,120,20);
            FillTinggi.setBounds(130,90,150,20);
            LayoutHasil.setBounds(130,110,150,20);
            
            LayoutLuasPersegi.setBounds(10,140,150,20);
            FillLuasPersegi.setBounds(150,140,150,20);
            LayoutKelilingPersegi.setBounds(10,160,150,20);
            FillKelilingPersegi.setBounds(150,160,150,20);
            LayoutVolumeBalok.setBounds(10,180,150,20);
            FillVolumeBalok.setBounds(150,180,150,20);
            LayoutLuasPermukaanBalok.setBounds(10,200,150,20);
            FillLuasPermukaanBalok.setBounds(150,200,150,20);
            enableView(false);
            ButtonHitung.setBounds(60,230,80,20);
            ButtonReset.setBounds(180,230,80,20);
            setVisible(true);
            setLocationRelativeTo(null);

            FillPanjang.addActionListener(this);
            FillLebar.addActionListener(this);
            FillTinggi.addActionListener(this);
            ButtonHitung.addActionListener(this);
            ButtonReset.addActionListener(this);
        }
        
        public void enableView(boolean value){
            LayoutLuasPersegi.setVisible(value);
            FillLuasPersegi.setVisible(value);
            LayoutKelilingPersegi.setVisible(value);
            FillKelilingPersegi.setVisible(value);
            LayoutVolumeBalok.setVisible(value);
            FillVolumeBalok.setVisible(value);
            LayoutLuasPermukaanBalok.setVisible(value);
            FillLuasPermukaanBalok.setVisible(value);
        }
        
        public double getPanjang(){return Double.parseDouble(FillPanjang.getText());}
        public double getLebar(){return Double.parseDouble(FillLebar.getText());}
        public double getTinggi(){return Double.parseDouble(FillTinggi.getText());}
        
        public void setPanjang(String panjang){this.FillPanjang.setText(panjang);}
        public void setLebar(String lebar){this.FillLebar.setText(lebar);}
        public void setTinggi(String tinggi){this.FillTinggi.setText(tinggi);}
        
        public void setLuasPersegi(double luasPersegi){this.FillLuasPersegi.setText(String.valueOf(luasPersegi));}
        public void setKelilingPersegi(double kelilingPersegi){this.FillKelilingPersegi.setText(String.valueOf(kelilingPersegi));}
        public void setVolumeBalok(double volumeBalok){this.FillVolumeBalok.setText(String.valueOf(volumeBalok));}
        public void setLuasPermukaanBalok(double luasPermukaanBalok){this.FillLuasPermukaanBalok.setText(String.valueOf(luasPermukaanBalok));}
        
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource()==ButtonHitung){
            try{
                double panjang, lebar, tinggi;
                panjang=getPanjang();
                lebar=getLebar();
                tinggi=getTinggi();
                Balok ObjBalok = new Balok(panjang,lebar,tinggi);
                ObjBalok.hitungBalok();
                setLuasPersegi(ObjBalok.getLuasPersegi());
                setKelilingPersegi(ObjBalok.getKelilingPersegi());
                setVolumeBalok(ObjBalok.getVolumeBalok());
                setLuasPermukaanBalok(ObjBalok.getLuasPermukaanBalok());
                enableView(true);
            }
            catch(Exception error){
                String message = error.getMessage();
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if(e.getSource()==ButtonReset){
            enableView(false);
            setPanjang("");
            setLebar("");
            setTinggi("");
            setLuasPersegi(0);
            setKelilingPersegi(0);
            setVolumeBalok(0);
            setLuasPermukaanBalok(0);
        }
    }
    
}
