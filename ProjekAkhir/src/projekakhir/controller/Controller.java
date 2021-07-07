package projekakhir.controller;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import projekakhir.model.PenyebaranCovid;
import projekakhir.view.View;
import java.lang.Math;

public class Controller implements ActionListener, ListenerCovid{
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
        
        v.ButtonUpdate.addActionListener(this);
        v.ButtonClear.addActionListener(this);
        v.ButtonCalculate.addActionListener(this);
        
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
        if(e.getSource() == v.ButtonClear){
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
            
            if(verifyInputData(nama_daerah, confirmed, active, deaths, recovered)){
                if(pcovid.getPenyebaranCovidByNamaDaerah(nama_daerah) != null){
                    
                    pcovid.updatePenyebaranCovid(nama_daerah, confirmed, active, deaths, recovered);
                    String newData[][] = pcovid.getPenyebaranCovid();
                    v.table.setModel(new JTable(newData, v.colName).getModel());
                }
                else {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
                }
            } 
        } else if(e.getSource() == v.ButtonCalculate){
            double w1 = v.getFieldWeight1();
            double w2 = v.getFieldWeight2();
            double w3 = v.getFieldWeight3();
            double w4 = v.getFieldWeight4();
            
            if(verifyInputWeight(w1, w2, w3, w4)){
                double dataCovid[][] = pcovid.getPenyebaranCovidWP();
                double wTotal = w1 + w2 + w3 +w4;
                double temp=0;
                ArrayList<Double> hasilWP = new ArrayList<Double>();
                ArrayList<Integer> tipeKriteia = new ArrayList<Integer>();
                    tipeKriteia.add(0);
                    tipeKriteia.add(0);
                    tipeKriteia.add(0);
                    tipeKriteia.add(1);
                ArrayList<Double> weight = new ArrayList<Double>();
                    weight.add(w1);
                    weight.add(w2);
                    weight.add(w3);
                    weight.add(w4);
                for(int i=0;i<weight.size();i++){
                    weight.set(i, weight.get(i)/wTotal);
                    if(tipeKriteia.get(i)==0){
                        weight.set(i, weight.get(i)*(-1));
                    }
                }
                for(int i=0;i<pcovid.getJumlahData();i++){
                    for(int p=0;p<4;p++){
                        if(p==0){
                            temp = Math.pow(dataCovid[i][p], weight.get(p));
                        }else{
                            temp = temp * Math.pow(dataCovid[i][p], weight.get(p));
                        }
                    }
                    hasilWP.add(temp);
                }
                temp=0;
                for(int i=0;i<5;i++){
                    temp = temp + hasilWP.get(i);
                }
                
                for(int i=0;i<5;i++){
                    hasilWP.set(i, hasilWP.get(i)/temp);
                }
                v.LabelHasil1.setText(hasilWP.get(0).toString());
                v.LabelHasil2.setText(hasilWP.get(1).toString());
                v.LabelHasil3.setText(hasilWP.get(2).toString());
                v.LabelHasil4.setText(hasilWP.get(3).toString());
                v.LabelHasil5.setText(hasilWP.get(4).toString());
            }
            
        }
    }
    @Override
    public boolean verifyInputData(String nama_daerah,Double confirmed, Double active, Double deaths, Double recovered){
        if(nama_daerah.equals("")){
            JOptionPane.showMessageDialog(null, "Nama Daerah Tidak Boleh Kosong");
        }
        else if(confirmed.equals(null) || confirmed<0){
            JOptionPane.showMessageDialog(null, "Confirmed Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(active.equals(null) || active<0){
            JOptionPane.showMessageDialog(null, "Active Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(deaths.equals(null) || deaths<0){
            JOptionPane.showMessageDialog(null, "Deaths Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(recovered.equals(null) || recovered<0){
            JOptionPane.showMessageDialog(null, "Recovered Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else{
            return true;
        }
        return false;
    }
    @Override
    public boolean verifyInputWeight(Double a, Double b, Double c, Double d) {
        if(a.equals(null) || a<0){
            JOptionPane.showMessageDialog(null, "Bobot 1 Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(b.equals(null) || b<0){
            JOptionPane.showMessageDialog(null, "Bobot 2 Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(c.equals(null) || c<0){
            JOptionPane.showMessageDialog(null, "Bobot 3 Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else if(d.equals(null) || d<0){
            JOptionPane.showMessageDialog(null, "Bobot 4 Tidak Boleh Kosong Dan Harus Bernilai Positif");
        }
        else{
            return true;
        }
        return false;
    }
    
}