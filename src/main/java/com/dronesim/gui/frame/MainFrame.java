package com.dronesim.gui.frame;

import javax.swing.JFrame;

import com.dronesim.gui.panels.MainTabbedPanel;

public class MainFrame extends JFrame{
    public MainFrame() {
        setTitle("Drone Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setContentPane(new MainTabbedPanel());
    }
}
