package com.dronesim.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.dronesim.gui.components.DroneDynamicsCard;
import com.dronesim.model.DroneDynamics;
import com.dronesim.model.PagedDataProvider;

public class DynamicsPanel extends JPanel{
    private final List<DroneDynamics> dynamics;
    private final JPanel cardContainer;
    private final JButton prevBtn;
    private final JButton nextBtn;
    private final JLabel pageLabel;
    private int currentPage = 0;
    private final int PAGE_SIZE = 10;

    public DynamicsPanel(List<DroneDynamics> data) {
        this.dynamics = data;
        setLayout(new BorderLayout());

        cardContainer = new JPanel();
        cardContainer.setLayout(new GridLayout(0, 2, 10, 10));
        add(new JScrollPane(cardContainer), BorderLayout.CENTER);

        JPanel nav = new JPanel(new FlowLayout(FlowLayout.CENTER));
        prevBtn = new JButton("<");
        nextBtn = new JButton(">");
        pageLabel = new JLabel();

        nav.add(prevBtn);
        nav.add(pageLabel);
        nav.add(nextBtn);
        add(nav, BorderLayout.SOUTH);

        prevBtn.addActionListener(e -> {
            if (currentPage > 0) {
                currentPage--;
                refreshCards();
            }
        });

        nextBtn.addActionListener(e -> {
            currentPage++;
            refreshCards();
        });

        refreshCards();
    }

    private void refreshCards() {
        cardContainer.removeAll();
        List<String[]> data = getPageData(currentPage, PAGE_SIZE);
        for (int i = 0; i < data.size(); i++) {
            DroneDynamics dyn = dynamics.get(currentPage * PAGE_SIZE + i);
            cardContainer.add(new DroneDynamicsCard(dyn));
        }
        pageLabel.setText("Page " + (currentPage + 1));
        prevBtn.setEnabled(currentPage > 0);
        cardContainer.revalidate();
        cardContainer.repaint();
    }

    @Override
    public List<String[]> getPageData(int pageIndex, int pageSize) {
        List<String[]> dummy = new ArrayList<>();
        int start = pageIndex * pageSize;
        int end = Math.min(start + pageSize, dynamics.size());
        for (int i = start; i < end; i++) {
            dummy.add(new String[]{}); // only needed for button logic
        }
        return dummy;
    }
}
