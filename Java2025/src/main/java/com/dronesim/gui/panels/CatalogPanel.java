package com.dronesim.gui.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import com.dronesim.api.DataFetcher;
import com.dronesim.model.DroneType;
import com.dronesim.parser.ManualJsonParser;

public class CatalogPanel extends JPanel {
    private final DataFetcher dataFetcher;
    private JTable droneTypeTable;
    private DefaultTableModel tableModel;

    public CatalogPanel(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
        initializeUI();
        loadDroneTypes();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        
        // All columns including previously missing ones
        String[] columns = {
            "ID", 
            "Manufacturer", 
            "Model", 
            "Weight (kg)", 
            "Max Speed (km/h)",
            "Battery (mAh)",
            "Control Range (m)",
            "Max Carriage (kg)"
        };
        
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                // All columns except manufacturer/model are numbers
                return (column == 1 || column == 2) ? String.class : Integer.class;
            }
        };
        
        droneTypeTable = new JTable(tableModel);
        
        // Left-align ALL columns
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        
        for (int i = 0; i < droneTypeTable.getColumnCount(); i++) {
            droneTypeTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }
        
        // Auto-resize columns
        droneTypeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        // Sort by ID by default
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        droneTypeTable.setRowSorter(sorter);
        sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
        
        add(new JScrollPane(droneTypeTable), BorderLayout.CENTER);
    }

    private void loadDroneTypes() {
        try {
            String json = dataFetcher.fetchDroneTypes();
            List<DroneType> types = new ManualJsonParser().parseDroneTypes(json);
            updateTable(types);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error loading data: " + e.getMessage(),
                "API Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable(List<DroneType> types) {
        tableModel.setRowCount(0);
        for (DroneType type : types) {
            tableModel.addRow(new Object[]{
                type.getId(),
                type.getManufacturer(),
                type.getTypename(),
                type.getWeight(),
                type.getMax_speed(),
                type.getBattery_capacity(),
                type.getControl_range(),
                type.getMax_carriage()
            });
        }
        
        // Auto-resize columns after data loads
        for (int column = 0; column < droneTypeTable.getColumnCount(); column++) {
            TableColumn tableColumn = droneTypeTable.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
            
            for (int row = 0; row < droneTypeTable.getRowCount(); row++) {
                TableCellRenderer cellRenderer = droneTypeTable.getCellRenderer(row, column);
                Component c = droneTypeTable.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + droneTypeTable.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
                
                //
                // Don't exceed max width
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }
            
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
}