package controllers;

import core.Controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Event;
import models.NewEventModel;
import views.EventListView;

public class EventListController extends Controller{
    private EventListView eventListView;
    private JTable tblEvents;

    @Override
    public void run() {
        make_table();
        eventListView = new EventListView(this, tblEvents);
    }
    
    public EventListView getView() {
        return eventListView;
    }
    public void make_table() {
        tblEvents = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(new String[] {
                "Date", 
                "Description", 
                "Frequency", 
                "E-mail", 
                "Alarm"
            }, 0) {
            Class<?>[] columnTypes = new Class[] {
                String.class, 
                String.class, 
                String.class, 
                String.class, 
                Boolean.class
            };
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        };
        
        /*NewEventModel newEventModel = new NewEventModel();
        List<Event> listaEvents = newEventModel.getEvents();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        for(Event event : listaEvents) {
            dtm.addRow(new Object[] {
                sdf.format(event.getDate()), 
                event.getEventDescription(), 
                event.getFrequency(), 
                event.getForwardEmail(), 
                event.getAlarm()                
            });
        }*/
        
        tblEvents.setModel(dtm);
    }
}
