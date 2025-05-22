package com.adrian.javaProject.gui;

import javax.swing.*;

public class MainGui {
    private JTabbedPane tabbedPane;
    private JPanel connectionPanel;
    private JPanel catalogPanel;
    private JPanel dashboardPanel;
    private JPanel dynamicsPanel;
    private JList list1;
    private JTable table1;
    private JTextField urlInput;
    private JLabel tokenLabel;
    private JLabel urlLabel;
    private JTextField tokenInput;
    private JButton button1;
    private JLabel statusLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        tabbedPane.addTab("Connection", connectionPanel);
        tabbedPane.addTab("Drone catalog", catalogPanel);
        tabbedPane.addTab("Dashboard", dashboardPanel);
        tabbedPane.addTab("Flight dynamics", dynamicsPanel);
    }
}
