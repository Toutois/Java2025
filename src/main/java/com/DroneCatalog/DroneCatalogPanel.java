package com.DroneCatalog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DroneCatalogPanel extends JPanel {
    private JTable table;
    private JTextField txtUrl;
    private JTextField txtToken;
    private JButton btnLoad;

    public DroneCatalogPanel() {
        setLayout(new BorderLayout());

        // 🔹 Top panel with URL and Token input
        JPanel top = new JPanel(new FlowLayout());
        txtUrl = new JTextField("http://dronesim.facets-labs.com/api/dronetypes/", 30);
        txtToken = new JTextField(20);
        btnLoad = new JButton("Load Drones");

        top.add(new JLabel("URL:"));
        top.add(txtUrl);
        top.add(new JLabel("Token:"));
        top.add(txtToken);
        top.add(btnLoad);
        add(top, BorderLayout.NORTH);

        // 🔹 Table to display drone data
        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 🔹 Click button to load data
        btnLoad.addActionListener(this::loadData);
    }

    private void loadData(ActionEvent e) {
        try {
            String urlStr = txtUrl.getText().trim();
            String token = txtToken.getText().trim();

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Token " + token);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(reader);
            JsonNode results = root.get("results");

            // 🔹 Table headers
            String[] columns = {"ID", "Manufacturer", "Type", "Weight", "Speed", "Battery", "Range"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);

            // 🔹 Add each drone to table
            for (JsonNode node : results) {
                model.addRow(new Object[]{
                        node.get("id").asInt(),
                        node.get("manufacturer").asText(),
                        node.get("typename").asText(),
                        node.get("weight").asInt(),
                        node.get("max_speed").asInt(),
                        node.get("battery_capacity").asInt(),
                        node.get("control_range").asInt()
                });
            }

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
