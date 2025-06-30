package com.dronesim.gui.panels;

import com.dronesim.api.DataFetcher;
import com.dronesim.model.DroneType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Ein Panel, das alle Attribute von DroneType in einer Tabelle anzeigt.
 */
public class DroneTypePanel extends JPanel {
    public DroneTypePanel() {
        setLayout(new BorderLayout());

        // Spaltennamen entsprechend DroneType
        String[] columns = {"ID", "Manufacturer", "Type Name", "Weight", "Max Speed", "Battery Capacity", "Control Range", "Max Carriage"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Lade DroneTypes asynchron
        new SwingWorker<List<DroneType>, Void>() {
            @Override
            protected List<DroneType> doInBackground() throws Exception {
                return new DataFetcher().fetchAllDroneTypes();
            }
            @Override
            protected void done() {
                try {
                    for (DroneType dt : get()) {
                        model.addRow(new Object[]{
                            dt.getId(),
                            dt.getManufacturer(),
                            dt.getTypename(),
                            dt.getWeight(),
                            dt.getMax_speed(),
                            dt.getBattery_capacity(),
                            dt.getControl_range(),
                            dt.getMax_carriage()
                        });
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(DroneTypePanel.this,
                        "Fehler beim Laden der DroneTypes:\n" + e.getMessage(),
                        "Ladefehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }
}
