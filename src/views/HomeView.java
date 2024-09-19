package views;

import controllers.HomeController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class HomeView extends JPanel{
    private final HomeController homeController;
    private final JFrame mainFrame;    
    private final static int MAIN_FRAME_WIDTH = 800;
    private final static int MAIN_FRAME_HEIGHT = 350;
    private final static int MAIN_FRAME_X = 100;
    private final static int MAIN_FRAME_Y = 100;
    
    public HomeView(HomeController homeController, JFrame mainFrame) {
        this.homeController = homeController;
        this.mainFrame = mainFrame;

        make_mainFrame();
        make_tabs();
    }
    
    private void make_mainFrame() {
        mainFrame.setOpacity(1.0f);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(MAIN_FRAME_X, MAIN_FRAME_Y, MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
        mainFrame.setMinimumSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));
        
        
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));
    }
    private void make_tabs() {
        JTabbedPane tpnEvents = new JTabbedPane(JTabbedPane.TOP);
        //tpnEvents.add("Prueba", new Panel());
        tpnEvents.addTab("New event", homeController.getNewEventView());
        tpnEvents.addTab("Events", homeController.getEventListView());
        tpnEvents.addTab("New guest", homeController.getNewGuestView());
        add(tpnEvents, BorderLayout.CENTER);
    }
}
