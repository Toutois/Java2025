
/* 
package com.dronesim.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.dronesim.api.ApiConfig;
import com.dronesim.gui.dialogs.TokenLoginDialog;
import com.dronesim.gui.frame.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame dummyFrame = new JFrame();
            dummyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dummyFrame.setLocationRelativeTo(null);

            TokenLoginDialog loginDialog = new TokenLoginDialog(dummyFrame);
            loginDialog.setVisible(true);

            if (!loginDialog.isConfirmed()) {
                System.exit(0);
            }

            ApiConfig apiConfig = new ApiConfig(loginDialog.getUrl(), loginDialog.getToken());
            MainFrame app = new MainFrame(apiConfig);
            app.setVisible(true);
        });
    }
}

*/

package com.dronesim.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.dronesim.api.ApiConfig;
import com.dronesim.gui.dialogs.TokenLoginDialog;
import com.dronesim.gui.frame.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame dummyFrame = new JFrame();
            dummyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            TokenLoginDialog loginDialog = new TokenLoginDialog(dummyFrame);
            loginDialog.setVisible(true);

            if (loginDialog.isConfirmed()) {
                ApiConfig config = new ApiConfig(
                    loginDialog.getUrl(), 
                    loginDialog.getToken()
                );
                new MainFrame(config).setVisible(true);
            } else {
                System.exit(0);
            }
        });
    }
}