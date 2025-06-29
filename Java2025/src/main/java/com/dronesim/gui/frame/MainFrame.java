package com.dronesim.gui.frame;

import javax.swing.JFrame;

import com.dronesim.api.ApiConfig;
import com.dronesim.gui.panels.MainTabbedPanel;

public class MainFrame extends JFrame {
    private final ApiConfig apiConfig;

    public MainFrame(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
        setTitle("Drone Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setContentPane(new MainTabbedPanel(apiConfig));
    }

    public ApiConfig getApiConfig() {
        return apiConfig;
    }
}