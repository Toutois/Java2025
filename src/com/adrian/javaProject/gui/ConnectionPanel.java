//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectionPanel extends JPanel{

    private JLabel tokenLabel;
    private JLabel urlLabel;

    private JTextField tokenTxt;
    private JTextField urlTxt;

    private JButton connectBtn;

    public ConnectionPanel() {
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(10,10,10,10);

        tokenLabel = new JLabel("Token:");
        urlLabel = new JLabel("API Url:");
        tokenTxt = new JTextField(20);
        urlTxt = new JTextField(20);
        connectBtn = new JButton("Connect");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(tokenLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(tokenTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(urlLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(urlTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(connectBtn, gbc);
        }

    public String getToken(){
        return tokenTxt.getText();
    }
    public String getUrl() {
        return urlTxt.getText();
    }
    public JButton getConnectBtn() {
        return connectBtn;
    }
}
