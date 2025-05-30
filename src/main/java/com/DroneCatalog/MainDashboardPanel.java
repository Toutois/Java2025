package com.DroneCatalog;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Main dashboard panel with tabs for Catalog
 */
public class MainDashboardPanel extends JPanel {
    public MainDashboardPanel() {
        setLayout(new BorderLayout());
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Drone Catalog", new DroneCatalogPanel());
        //Other tabs can be added here as needed
        add(tabs, BorderLayout.CENTER);
    }
}
