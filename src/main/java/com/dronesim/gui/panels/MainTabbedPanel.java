package com.dronesim.gui.panels;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.dronesim.api.DataProvider;
import com.dronesim.model.*;
import com.dronesim.parser.ManualJsonParser;

public class MainTabbedPanel extends JPanel{
    public MainTabbedPanel() {
        setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        DataProvider parser = new ManualJsonParser();
        List<Drone> drones = parser.parseDrones(jsonString);
        CatalogPanel cPanel = new CatalogPanel(drones);
        tabs.addTab("Catalog", cPanel);

        tabs.addTab("Dashboard", new DashboardPanel());

        List<DroneDynamics> dyn = parser.parseDynamics(jsonString);
        DynamicsPanel dPanel = new DynamicsPanel(dyn);
        tabs.addTab("Dynamics", dPanel);

        this.add(tabs, BorderLayout.CENTER);
    }
}
