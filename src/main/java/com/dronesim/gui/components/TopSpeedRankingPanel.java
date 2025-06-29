package com.dronesim.gui.components;

import com.dronesim.model.Drone;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopSpeedRankingPanel extends JPanel {
    private final JLabel[] labels;

    public TopSpeedRankingPanel() {
        setPreferredSize(new Dimension(300, 200));
        setBorder(BorderFactory.createTitledBorder("Top 5 Fastest Drones"));
        setLayout(new GridLayout(5, 1));

        labels = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel((i + 1) + ". ---");
            add(labels[i]);
        }
    }

    public void updateRanking(List<Drone> drones) {
        List<Drone> top5 = drones.stream()
                .sorted(Comparator.comparingInt(Drone::getSpeed).reversed())
                .limit(5)
                .collect(Collectors.toList());

        for (int i = 0; i < labels.length; i++) {
            if (i < top5.size()) {
                Drone d = top5.get(i);
                labels[i].setText((i + 1) + ". " + d.getDronetype() + " - " + d.getSpeed() + " km/h");
            } else {
                labels[i].setText((i + 1) + ". ---");
            }
        }
    }
}