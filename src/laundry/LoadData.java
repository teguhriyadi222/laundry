/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROOT
 */
public class LoadData {
    File file;
    BufferedReader br;
    BufferedWriter bw;
    DefaultTableModel model;
    public void load(JTable tabel){
        file = new File("src/laundry/data.txt");
        try {
            br = new BufferedReader(new FileReader(file));
            String barispertama = br.readLine();
            String[] namaKolom = barispertama.split(",");
            model = (DefaultTableModel) tabel.getModel();
            model.setColumnIdentifiers(namaKolom);

            Object[] dataBaris = br.lines().toArray();
            for (int i = 0; i < dataBaris.length; i++) {
                String baris = dataBaris[i].toString();
                String[] data = baris.split("/");
                model.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal load data");
        }
    }
}
