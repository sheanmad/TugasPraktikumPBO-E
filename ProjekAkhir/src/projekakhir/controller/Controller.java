
package projekakhir.controller;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import projekakhir.model.PenyebaranCovid;
import projekakhir.view.View;

public class Controller implements ActionListener{
    PenyebaranCovid m;
    View v;
    
    public Controller(PenyebaranCovid m, View v){
        this.m = m;
        this.v = v;
        if(m.getJumlahData() != 0){
            String data[][] = m.getMovie();
            v.table.setModel(new JTable(data, v.colName).getModel());
        } 
        else{
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }
        
        v.ButtonTambah.addActionListener(this);
        v.ButtonUpdate.addActionListener(this);
        v.ButtonDelete.addActionListener(this);
        v.ButtonClear.addActionListener(this);
        
        v.table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = v.table.getSelectedRow();
                v.FieldJudul.setText(v.table.getValueAt(row, 0).toString());
                v.FieldAlur.setText(v.table.getValueAt(row, 1).toString());
                v.FieldPenokohan.setText(v.table.getValueAt(row, 2).toString());
                v.FieldAkting.setText(v.table.getValueAt(row, 3).toString());
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == v.ButtonTambah) {
            String judul = v.getJudul();
            double alur = v.getAlur();
            double penokohan = v.getPenokohan();
            double akting = v.getAkting();
            
            if(verifyInput(judul, alur, penokohan, akting)){
                double nilai = (alur+penokohan+akting)/3;
                m.createMovie(judul, alur, penokohan, akting, nilai);
                String newData[][] = m.getMovie();
                System.out.println(newData);
                v.table.setModel(new JTable(newData, v.colName).getModel());
            }
            
        } else if(e.getSource() == v.ButtonClear){
            v.FieldJudul.setText("");
            v.FieldAlur.setText("");
            v.FieldPenokohan.setText("");
            v.FieldAkting.setText("");

        } else if (e.getSource() == v.ButtonUpdate){
            String judul = v.getJudul();
            double alur = v.getAlur();
            double penokohan = v.getPenokohan();
            double akting = v.getAkting();
            
            
            if(verifyInput(judul, alur, penokohan, akting)){
                if(m.getMovieByJudul(judul) != null){
                    double nilai = (alur+penokohan+akting)/3;
                    m.updateMovie(judul, alur, penokohan, akting, nilai);
                    String newData[][] = m.getMovie();
                    v.table.setModel(new JTable(newData, v.colName).getModel());
                }
                else {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
                }
            } 
            
        } else if(e.getSource() == v.ButtonDelete){
            String judul = v.getJudul();
            if(judul.equals("")){
                JOptionPane.showMessageDialog(null, "Judul Tidak Boleh Kosong");
            } 
            else{
                m.deleteMovie(judul);
                String newData[][] = m.getMovie();
                v.table.setModel(new JTable(newData, v.colName).getModel());
            }
        }
    }
    
    boolean verifyInput(String judul, double alur, double penokohan, double akting){
        if(judul.equals("")){
            JOptionPane.showMessageDialog(null, "Judul Tidak Boleh Kosong");
        }
        else if(alur>5 || alur<0){
            JOptionPane.showMessageDialog(null, "Alur wajib berskala 0-5");
        }
        else if(penokohan>5 || penokohan<0){
            JOptionPane.showMessageDialog(null, "Penokohan wajib berskala 0-5");
        }
        else if(akting>5 || akting<0){
            JOptionPane.showMessageDialog(null, "Akting wajib berskala 0-5");
        }
        else{
            return true;
        }
        return false;
    }
}
