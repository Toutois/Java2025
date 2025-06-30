package com.dronesim;

import com.dronesim.api.ApiClient;
import com.dronesim.api.ApiConfig;
import com.dronesim.gui.dialogs.TokenInputDialog;
import com.dronesim.gui.frame.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Token vom User per Dialog holen
                boolean demoMode = true;

                if (!demoMode) {
                    TokenInputDialog dialog = new TokenInputDialog();
                    String token = dialog.getToken();
                    if (token == null || token.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Kein Token eingegeben.");
                        System.exit(0);
                    }
                    ApiConfig.overrideToken(token);
                }

                // Verbindung testen (optional, um Fehler früh zu erkennen)
                ApiClient api = new ApiClient(new ApiConfig());
                api.testConnection();

                // GUI starten
                new MainFrame();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Fehler beim Start: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
        });
    }    
}
