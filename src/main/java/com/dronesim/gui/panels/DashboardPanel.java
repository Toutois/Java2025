package com.dronesim.gui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dronesim.gui.components.DroneStatusChartPanel;
import com.dronesim.gui.components.TopSpeedRankingPanel;
<<<<<<< HEAD
=======
import com.dronesim.gui.paging.DronePaginationPanel;
import com.dronesim.model.interfaces.PagedDataProvider;
>>>>>>> 338a909 (reorder)

public class DashboardPanel extends JPanel {
    public DashboardPanel(int droneId) {
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

<<<<<<< HEAD
        // Unten: Drohnenliste
        //DroneTablePanel tablePanel = new DroneTablePanel();
        //add(tablePanel, BorderLayout.SOUTH);

        List<String[]> data = new ArrayList<>();
        for (int i = 1; i <= 35; i++) {
            data.add(new String[]{String.valueOf(i), "Drone-" + i, String.valueOf(20 + i), "Online"});
        }
=======
        // Unten: Paging ohne Daten
        DronePaginationPanel paginationPanel = new DronePaginationPanel(new PagedDataProvider() {
            @Override
            public java.util.List<String[]> getPageData(int pageIndex, int pageSize) {
                return java.util.Collections.emptyList();
            }
        });
        add(paginationPanel, BorderLayout.SOUTH);
>>>>>>> 338a909 (reorder)
    }
}
