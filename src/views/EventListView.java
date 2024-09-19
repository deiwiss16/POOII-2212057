package views;

import controllers.EventListController;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EventListView extends JPanel{
    private final EventListController eventListController;
    private final JTable tblEvents;
    
    public EventListView(EventListController eventListController, JTable tblEvents) {
        this.eventListController = eventListController;
        this.tblEvents = tblEvents;

        make_frame();
    }
    private void make_frame() {
        JScrollPane scpEvents = new JScrollPane(tblEvents);
        add(scpEvents, BorderLayout.CENTER);
    }
}
