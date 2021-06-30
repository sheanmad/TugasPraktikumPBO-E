
package responsipbo.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
   JLabel LabelJudul = new JLabel("Judul");
   public JTextField FieldJudul = new JTextField(30);
   
    JLabel LabelAlur = new JLabel("Alur");
    public final JTextField FieldAlur = new JTextField(30);
    
    JLabel LabelPenokohan = new JLabel("Penokohan");
    public final JTextField FieldPenokohan = new JTextField(30);
    
    JLabel LabelAkting = new JLabel("Akting");
    public final JTextField FieldAkting = new JTextField(30);
     
    public JButton ButtonTambah = new JButton("Tambah");
    public JButton ButtonUpdate = new JButton("Update");
    public JButton ButtonDelete = new JButton("Delete");
    public JButton ButtonClear = new JButton("Clear");

    public JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public Object colName[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};

    public View() {
        setTitle("Data Movie");

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
        addPanel.add(scrollPane, c);
        
        c.gridx = 2;
        c.gridheight = 1;
        c.insets = new java.awt.Insets(15, 5, 10, 5); 
        addPanel.add(LabelJudul, c);
        c.gridx = 3;
        addPanel.add(FieldJudul, c);

        c.gridx = 2;
        c.gridy = 2;
        c.insets = new java.awt.Insets(5, 10, 10, 10);
        addPanel.add(LabelAlur, c);
        c.gridx = 3;
        addPanel.add(FieldAlur, c);

        c.gridx = 2;
        c.gridy = 3;
        addPanel.add(LabelPenokohan, c);
        c.gridx = 3;
        addPanel.add(FieldPenokohan, c);

        c.gridx = 2;
        c.gridy = 4;
        addPanel.add(LabelAkting, c);
        c.gridx = 3;
        addPanel.add(FieldAkting, c);

        c.gridx = 3;
        c.gridy = 5;
        addPanel.add(ButtonTambah, c);
        c.gridy = 6;
        addPanel.add(ButtonUpdate, c);
        c.gridy = 7;
        addPanel.add(ButtonDelete, c);
        c.gridy = 8;
        addPanel.add(ButtonClear, c);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(addPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public String getJudul() {
        return FieldJudul.getText();
    }

    public double getAlur() {
        String str = FieldAlur.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldAlur.getText());
    }

    public double getPenokohan() {
        String str = FieldPenokohan.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldPenokohan.getText());
    }

    public double getAkting() {
        String str = FieldAkting.getText();
        if (str.equals("") || !this.Check(str)) {
            return -1;
        }
        return Double.parseDouble(FieldAkting.getText());
    }

    public static boolean Check(String str) {
        return str != null && str.matches("[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?");
    }
}