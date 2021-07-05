
package projekakhir.controller;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import projekakhir.model.PenyebaranCovid;
import projekakhir.view.View;

public class Controller implements ActionListener{
    PenyebaranCovid pcovid;
    View v;
    
    public Controller(PenyebaranCovid pcovid, View v){
        this.pcovid = pcovid;
        this.v = v;
        if(pcovid.getJumlahData() != 0){
            String data[][] = pcovid.getPenyebaranCovid();
            v.table.setModel(new JTable(data, v.colName).getModel());
        } 
        else{
            JOptionPane.showMessageDialog(null, "Tidak ada data!");
        }
        
        v.ButtonAdd.addActionListener(this);
        v.ButtonUpdate.addActionListener(this);
        v.ButtonDelete.addActionListener(this);
        v.ButtonClear.addActionListener(this);
        
        v.table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = v.table.getSelectedRow();
                v.FieldNama_Daerah.setText(v.table.getValueAt(row, 0).toString());
                v.FieldConfirmed.setText(v.table.getValueAt(row, 1).toString());
                v.FieldActive.setText(v.table.getValueAt(row, 2).toString());
                v.FieldDeaths.setText(v.table.getValueAt(row, 3).toString());
                v.FieldRecovered.setText(v.table.getValueAt(row, 4).toString());
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == v.ButtonAdd) {
            String nama_daerah = v.getNamaDaerah();
            double confirmed = v.getConfirmed();
            double active = v.getActive();
            double deaths = v.getDeaths();
            double recovered = v.getRecovered();
            
            if(verifyInput(nama_daerah, confirmed, active, deaths, recovered)){
                
                pcovid.createPenyebaranCovid(nama_daerah, confirmed, active, deaths, recovered);
                String newData[][] = pcovid.getPenyebaranCovid();
                System.out.println(newData);
                v.table.setModel(new JTable(newData, v.colName).getModel());
            }
            
        } else if(e.getSource() == v.ButtonClear){
            v.FieldNama_Daerah.setText("");
            v.FieldConfirmed.setText("");
            v.FieldActive.setText("");
            v.FieldDeaths.setText("");
            v.FieldRecovered.setText("");

        } else if (e.getSource() == v.ButtonUpdate){
            String nama_daerah = v.getNamaDaerah();
            double confirmed = v.getConfirmed();
            double active = v.getActive();
            double deaths = v.getDeaths();
            double recovered = v.getRecovered();
            
            if(verifyInput(nama_daerah, confirmed, active, deaths, recovered)){
                if(pcovid.getPenyebaranCovidByNamaDaerah(nama_daerah) != null){
                    
                    pcovid.updatePenyebaranCovid(nama_daerah, confirmed, active, deaths, recovered);
                    String newData[][] = pcovid.getPenyebaranCovid();
                    v.table.setModel(new JTable(newData, v.colName).getModel());
                }
                else {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
                }
            } 
            
        } else if(e.getSource() == v.ButtonDelete){
            String nama_daerah = v.getNamaDaerah();
            if(nama_daerah.equals("")){
                JOptionPane.showMessageDialog(null, "Nama Daerah Cannot Empty");
            } 
            else{
                pcovid.deletePenyebaranCovid(nama_daerah);
                String newData[][] = pcovid.getPenyebaranCovid();
                v.table.setModel(new JTable(newData, v.colName).getModel());
            }
        }
        else if(e.getSource() == v.ButtonCalculate){
            
        }
    }
    
    boolean verifyInput(String nama_daerah,Double confirmed, Double active, Double deaths, Double recovered){
        if(nama_daerah.equals("")){
            JOptionPane.showMessageDialog(null, "Nama Daerah Tidak Boleh Kosong");
        }
        else if(confirmed.equals("") || confirmed<0){
            JOptionPane.showMessageDialog(null, "Confirmed Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(active.equals("") || active<0){
            JOptionPane.showMessageDialog(null, "Active Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(deaths.equals("") || deaths<0){
            JOptionPane.showMessageDialog(null, "Deaths Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(recovered.equals("") || recovered<0){
            JOptionPane.showMessageDialog(null, "Recovered Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else{
            return true;
        }
        return false;
    }
}
