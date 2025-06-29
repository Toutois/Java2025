package com.dronesim.gui.panels;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.dronesim.api.ApiConfig;
import com.dronesim.api.DataFetcher;

public class MainTabbedPanel extends JPanel {
    public MainTabbedPanel(ApiConfig apiConfig) {
        DataFetcher fetcher = new DataFetcher(apiConfig);
        
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Catalog", new CatalogPanel(fetcher));
        tabs.addTab("Dashboard", new DashboardPanel());
        tabs.addTab("Dynamics", new DynamicsPanel());
        
        add(tabs);
    }
}