/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class FrmRegistroEventos extends JFrame{
    private JPanel panContent;
    
    private JTabbedPane tabbedPane;
    private JPanel panNewEvent;
    private JLabel lblEventDescription;
    private JTextField txtEventDescription;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblDate;
    private JTextField txtDate;
    //jformdatefield
    private JLabel lblFrequency;
    private JRadioButton rdbtnDaily;
    private JRadioButton rdbtnWeekly;
    private JRadioButton rdbtnMonthly;
    private ButtonGroup btgFrequency;
    private JCheckBox cbxAlarm;
    private JButton btnSave;
    private JButton btnClean;
    
    private JPanel panEvents;
    private JScrollPane scpEvents;
    private JTable tblEvents;
    
    public static void main(String[] args){
        FrmRegistroEventos frmRegistroEventos = new FrmRegistroEventos();
    }
    
    public FrmRegistroEventos(){
        initComponents();
        cargarTabla();
    }
    private void cargarTabla() {
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
        tblEvents.setModel(dtm);
    }
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 312);
        setVisible(true);
        setTitle("Registro de Eventos");
        panContent = new JPanel();
        panContent.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panContent);
        panContent.setLayout(null);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(5, 5, 475, 265);
        panContent.add(tabbedPane);
        
        // Pestaña New Events
        panNewEvent = new JPanel();
        tabbedPane.addTab("New Event", null, panNewEvent, null);
        panNewEvent.setLayout(null);
        
        lblEventDescription = new JLabel("Event Description:");
        lblEventDescription.setBounds(20, 20, 110, 13);
        panNewEvent.add(lblEventDescription);
        
        lblEmail = new JLabel("Forward e-mail:");
        lblEmail.setBounds(20, 60, 110, 13);
        panNewEvent.add(lblEmail);
        
        lblDate = new JLabel("Date:");
        lblDate.setBounds(20, 100, 110, 13);
        panNewEvent.add(lblDate);
        
        lblFrequency = new JLabel("Frequency:");
        lblFrequency.setBounds(20, 140, 110, 13);
        panNewEvent.add(lblFrequency);
        
        txtEventDescription = new JTextField();
        txtEventDescription.setBounds(150, 16, 250, 20);
        panNewEvent.add(txtEventDescription);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 56, 250, 20);
        panNewEvent.add(txtEmail);
        
        txtDate = new JTextField();
        txtDate.setBounds(150, 96, 125, 20);
        panNewEvent.add(txtDate);
        
        rdbtnDaily = new JRadioButton("Daily");
        rdbtnDaily.setBounds(150, 137, 55, 20);
        panNewEvent.add(rdbtnDaily);
        
        rdbtnWeekly = new JRadioButton("Weekly");
        rdbtnWeekly.setBounds(250, 137, 85, 20);
        panNewEvent.add(rdbtnWeekly);
        
        rdbtnMonthly = new JRadioButton("Monthly");
        rdbtnMonthly.setBounds(350, 137, 90, 20);
        panNewEvent.add(rdbtnMonthly);
        
        btgFrequency = new ButtonGroup();
        btgFrequency.add(rdbtnDaily);
        btgFrequency.add(rdbtnWeekly);
        btgFrequency.add(rdbtnMonthly);
        rdbtnDaily.setSelected(true);
        
        cbxAlarm = new JCheckBox("Alarm");
        cbxAlarm.setBounds(20, 200, 110, 13);
        panNewEvent.add(cbxAlarm);
        
        btnSave = new JButton("Save");
        btnSave.setBounds(150, 195, 70, 25);
        panNewEvent.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("holaaaa");
            }
        });
        
        btnClean = new JButton("Clean");
        btnClean.setBounds(250, 195, 70, 25);
        panNewEvent.add(btnClean);
        
        // Pestaña Events
        panEvents = new JPanel();
        tabbedPane.addTab("Events", null, panEvents, null);
        panEvents.setLayout(null);
        
        scpEvents = new JScrollPane();
        scpEvents.setBounds(5, 5, 460, 200);
        panEvents.add(scpEvents);
        
        tblEvents = new JTable();
        scpEvents.setViewportView(tblEvents);
    }
    
    private void btnActionPerformed(java.awt.event.ActionEvent e){
        System.out.println("Holaaaaaaaaa");        
    }
}
