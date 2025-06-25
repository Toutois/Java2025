package com.dronesim.gui.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainTabbedPanel extends JPanel{
    public MainTabbedPanel() {
        setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Catalog", new CatalogPanel());
        tabs.addTab("Dashboard", new DashboardPanel());
        tabs.addTab("Dynamics", new DynamicsPanel());

        this.add(tabs, BorderLayout.CENTER);
    }
}
