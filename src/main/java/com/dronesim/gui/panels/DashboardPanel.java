package com.dronesim.gui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setLayout(new BorderLayout(10, 10));

        // Oben: Suchleiste
        JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
        JTextField searchField = new JTextField();
        searchField.setToolTipText("Search drones...");
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        searchPanel.add(new JLabel("🔍"), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.NORTH);

        // Mitte: PieChart + Top 5 Rangliste
        JPanel statsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statsPanel.add(new DroneStatusChartPanel());
        statsPanel.add(new TopSpeedRankingPanel());
        add(statsPanel, BorderLayout.CENTER);

        // Unten: Drohnenliste
        DroneTablePanel tablePanel = new DroneTablePanel();
        add(tablePanel, BorderLayout.SOUTH);
    }
}
