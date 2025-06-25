package com.dronesim.gui.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopSpeedRankingPanel extends JPanel {
    public TopSpeedRankingPanel() {
        setPreferredSize(new Dimension(300, 200));
        setBorder(BorderFactory.createTitledBorder("Top 5 Fastest Drones"));
        setLayout(new GridLayout(5, 1));

        // Dummy data
        for (int i = 1; i <= 5; i++) {
            add(new JLabel(i + ". [Drone Name] - [Speed] km/h"));
        }
    }
}