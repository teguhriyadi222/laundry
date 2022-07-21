/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROOT
 */
public class SimpanData {
    File file;
    BufferedWriter bw;
    DefaultTableModel model;
    DefaultTableModel model2;
    
    public void simpanData(JTable tabel){
        try {
            model = (DefaultTableModel) tabel.getModel();
            file = new File("src/laundry/data.txt");
            bw = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < tabel.getColumnCount(); i++) {
                if (i > 0) {
                    bw.write(",");
                }
                bw.write(tabel.getColumnName(i));
            }
            bw.newLine();
            for (int i = 0; i < tabel.getRowCount(); i++) {
                for (int j = 0; j < tabel.getColumnCount(); j++) {
                    if (j > 0) {
                        bw.write("/");
                    }
                    bw.write(tabel.getValueAt(i, j).toString());
                }
                bw.newLine();
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }
        model.getDataVector().removeAllElements();
        LoadData ld = new LoadData();
        ld.load(tabel);
        
    }
}
