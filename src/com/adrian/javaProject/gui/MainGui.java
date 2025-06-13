
import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class MainGui extends JFrame {

    private final JTabbedPane tabbedPane;


    public MainGui() {
        this.setTitle("Drone");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        ConnectionPanel connectionP = new ConnectionPanel();
        CatalogPanel catalogP = new CatalogPanel();
        DashboardPanel dashboardP = new DashboardPanel();
        DynamicsPanel dynamicsP = new DynamicsPanel();
        // Tabs hinzufügen

        tabbedPane.addTab("Connection", connectionP);
        tabbedPane.addTab("Drone catalog", catalogP);
        tabbedPane.addTab("Dashboard", dashboardP);
        tabbedPane.addTab("Flight dynamics", dynamicsP);

        this.add(tabbedPane);
        this.setVisible(true);
    }

}