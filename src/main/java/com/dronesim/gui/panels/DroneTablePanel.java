package com.dronesim.gui.panels;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DroneTablePanel extends JPanel {
    public DroneTablePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("All Drones"));

        String[] columnNames = {"ID", "Name", "Speed", "Status"};
        Object[][] data = {
            {"1", "Alpha", "45", "Online"},
            {"2", "Bravo", "38", "Offline"},
            {"3", "Charlie", "52", "Idle"},
            {"4", "Delta", "41", "Online"},
            {"5", "Echo", "48", "In Transit"},
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
