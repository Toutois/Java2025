package com.dronesim.gui.panels;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DroneStatusChartPanel extends JPanel {
    public DroneStatusChartPanel() {
        setPreferredSize(new Dimension(300, 200));
        setBorder(BorderFactory.createTitledBorder("Status Overview"));
        add(new JLabel("[Pie Chart Placeholder]"));
    }
}
