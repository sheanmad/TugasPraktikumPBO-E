package projekakhir.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

    JLabel LabelNama_Daerah = new JLabel("nama_daerah");
    public JTextField FieldNama_Daerah = new JTextField(30);
    
    JLabel LabelConfirmed = new JLabel("confirmed");
    public final JTextField FieldConfirmed = new JTextField(30);
    
    JLabel LabelActive = new JLabel("active");
    public final JTextField FieldActive = new JTextField(30);
    
    JLabel LabelDeaths = new JLabel("deaths");
    public final JTextField FieldDeaths = new JTextField(30);
    
    JLabel LabelRecovered = new JLabel("recovered");
    public final JTextField FieldRecovered = new JTextField(30);
    
    JLabel LabelWeight1 = new JLabel("Weight1");
        JLabel LabelWeight2 = new JLabel("Weight2");
            JLabel LabelWeight3 = new JLabel("Weight3");
                JLabel LabelWeight4 = new JLabel("Weight4");
    public final JTextField FieldWeight1 = new JTextField(30);
    public final JTextField FieldWeight2 = new JTextField(30);
    public final JTextField FieldWeight3 = new JTextField(30);
    public final JTextField FieldWeight4 = new JTextField(30);
    JLabel LabelPengumuman = new JLabel("Hasil Perhitungan Weighted Product Tiap Daerah");

    JLabel LabelBantul = new JLabel("Bantul : ");
        JLabel LabelGunkid = new JLabel("Gunungkidul : ");
            JLabel LabelJogja = new JLabel("Jogja : ");
                JLabel LabelKulpro = new JLabel("Kulon Progo : ");
                    JLabel LabelSlem = new JLabel("Sleman : ");
    public JLabel LabelHasil1 = new JLabel("");
    public JLabel LabelHasil2 = new JLabel("");
    public JLabel LabelHasil3 = new JLabel("");
    public JLabel LabelHasil4 = new JLabel("");
    public JLabel LabelHasil5 = new JLabel("");
    
    public JButton ButtonUpdate = new JButton("Update");
    public JButton ButtonClear = new JButton("Clear");
    public JButton ButtonCalculate = new JButton("Calculate");

    public JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public Object colName[] = {"nama_daerah", "confirmed", "active", "deaths", "recovered"};

    public View() {
        setTitle("Data Penyebaran Covid19 DIY");

        tableModel = new DefaultTableModel(colName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        JPanel addPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(0, 0, 0, 0);//Top.Left.Bottom.Right

        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 10;
        addPanel.add(scrollPane,c);

        c.gridx = 2;
        c.gridheight = 1;
        c.insets = new java.awt.Insets(15, 5, 10, 5); 
        addPanel.add(LabelNama_Daerah, c);
        c.gridx = 3;
        addPanel.add(FieldNama_Daerah, c);

        c.gridx = 2;
        c.gridy = 2;
        c.insets = new java.awt.Insets(5, 10, 10, 10);
        addPanel.add(LabelConfirmed, c);
        c.gridx = 3;
        addPanel.add(FieldConfirmed, c);

        c.gridx = 2;
        c.gridy = 3;
        addPanel.add(LabelActive, c);
        c.gridx = 3;
        addPanel.add(FieldActive, c);

        c.gridx = 2;
        c.gridy = 4;
        addPanel.add(LabelDeaths, c);
        c.gridx = 3;
        addPanel.add(FieldDeaths, c);
        
        c.gridx = 2;
        c.gridy = 5;
        addPanel.add(LabelRecovered, c);
        c.gridx = 3;
        addPanel.add(FieldRecovered, c);
        
        c.gridx = 3;
        c.gridy = 6;
        addPanel.add(ButtonUpdate, c);
        c.gridy = 7;
        addPanel.add(ButtonClear, c);        
        
        c.insets = new java.awt.Insets(15, 10, 10, 10);
        c.gridx = 4;
        c.gridy = 1;
        addPanel.add(LabelWeight1, c);
        c.gridx = 4;
        c.gridy = 2;
        addPanel.add(LabelWeight2, c);
        c.gridx = 4;
        c.gridy = 3;
        addPanel.add(LabelWeight3, c);
        c.gridx = 4;
        c.gridy = 4;
        addPanel.add(LabelWeight4, c);
        c.gridx = 5;
        c.gridy = 1;
        addPanel.add(FieldWeight1, c);
        c.gridx = 5;
        c.gridy = 2;
        addPanel.add(FieldWeight2, c);
        c.gridx = 5;
        c.gridy = 3;
        addPanel.add(FieldWeight3, c);
        c.gridx = 5;
        c.gridy = 4;
        addPanel.add(FieldWeight4, c);
        
        c.gridx = 5;
        c.gridy = 5;
        addPanel.add(ButtonCalculate, c);

        c.gridx = 5;
        c.gridy = 6;
        addPanel.add(LabelPengumuman, c);

        c.gridx = 4;
        c.gridy = 7;
        addPanel.add(LabelBantul, c);
        c.gridx = 5;
        c.gridy = 7;
        addPanel.add(LabelHasil1, c);

        c.gridx = 4;
        c.gridy = 8;
        addPanel.add(LabelGunkid, c);
        c.gridx = 5;
        c.gridy = 8;
        addPanel.add(LabelHasil2, c);

        c.gridx = 4;
        c.gridy = 9;
        addPanel.add(LabelJogja, c);
        c.gridx = 5;
        c.gridy = 9;
        addPanel.add(LabelHasil3, c);

        c.gridx = 4;
        c.gridy = 10;
        addPanel.add(LabelKulpro, c);
        c.gridx = 5;
        c.gridy = 10;
        addPanel.add(LabelHasil4, c);

        c.gridx = 4;
        c.gridy = 11;
        addPanel.add(LabelSlem, c);
        c.gridx = 5;
        c.gridy = 11;
        addPanel.add(LabelHasil5, c);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(addPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public double getFieldWeight1(){
        String str = FieldWeight1.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldWeight1.getText());
    }

    public double getFieldWeight2(){
        String str = FieldWeight2.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldWeight2.getText());
    }

    public double getFieldWeight3(){
        String str = FieldWeight3.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldWeight3.getText());
    }

    public double getFieldWeight4(){
        String str = FieldWeight4.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldWeight4.getText());
    }

    public String getNamaDaerah() {
        return FieldNama_Daerah.getText();
    }

    public double getConfirmed() {
        String str = FieldConfirmed.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldConfirmed.getText());
    }

    public double getActive() {
        String str = FieldActive.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldActive.getText());
    }

    public double getDeaths() {
        String str = FieldDeaths.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldDeaths.getText());
    }

    public double getRecovered() {
        String str = FieldRecovered.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldRecovered.getText());
    }
    
    public static boolean Check(String str) {
        return str != null && str.matches("[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?");
    }
}