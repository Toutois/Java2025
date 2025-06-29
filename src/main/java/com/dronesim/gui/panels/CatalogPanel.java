package com.dronesim.gui.panels;

import com.dronesim.gui.paging.DronePaginationPanel;
import com.dronesim.model.Drone;
import com.dronesim.model.PagedDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;



public class CatalogPanel extends JPanel implements PagedDataProvider{
    private final List<Drone> allDrones;

    public CatalogPanel(List<Drone> droneData) {
        this.allDrones = droneData;
        setLayout(new BorderLayout());

        DronePaginationPanel pagingTable = new DronePaginationPanel(this);
        add(pagingTable, BorderLayout.CENTER);
    }

    @Override
    public List<String[]> getPageData(int pageIndex, int pageSize) {
        List<String[]> page = new ArrayList<>();
        int start = pageIndex * pageSize;
        int end = Math.min(start + pageSize, allDrones.size());

        for (int i = start; i < end; i++) {
            Drone d = allDrones.get(i);
            page.add(new String[]{
                String.valueOf(d.getId()),
                d.getDronetype(),
                d.getCreated(),
                d.getSerialNumber(),
                d.getCarriage_type()
            });
        }
        return page;
    }
}
