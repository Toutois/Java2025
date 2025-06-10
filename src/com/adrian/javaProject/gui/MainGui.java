import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainGui extends JFrame {

    private JTabbedPane tabbedPane;

    private JPanel connectionPanel;
    private JPanel catalogPanel;
    private JPanel dashboardPanel;
    private JPanel dynamicsPanel;

    private JLabel tokenLabel;
    private JLabel urlLabel;
    private JTextField tokenField;
    private JTextField urlField;
    private JButton btn;

    public MainGui() {
        this.setTitle("Drone");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        catalogPanel = new JPanel();
        dashboardPanel = new JPanel();
        dynamicsPanel = new JPanel();

        tokenLabel = new JLabel("API Token:");
        tokenField = new JTextField("Loading...");
        tokenField.setPreferredSize(new Dimension(200, 25));

        urlLabel = new JLabel("Base URL:");
        urlField = new JTextField("Loading...");
        urlField.setPreferredSize(new Dimension(200, 25));

        btn = new JButton("Button");

        connectionPanel = new JPanel(new GridLayout(3, 2, 10, 10)); 

        connectionPanel.add(tokenLabel);
        connectionPanel.add(tokenField);
        connectionPanel.add(urlLabel);
        connectionPanel.add(urlField);
        connectionPanel.add(new JLabel()); 
        connectionPanel.add(btn);


        tabbedPane.addTab("Connection", connectionPanel);
        tabbedPane.addTab("Drone catalog", catalogPanel);
        tabbedPane.addTab("Dashboard", dashboardPanel);
        tabbedPane.addTab("Flight dynamics", dynamicsPanel);

        this.add(tabbedPane);
        this.setVisible(true);
    }

}
