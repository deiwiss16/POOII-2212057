package views;

import controllers.NewEventController;
import enums.Frequency;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import models.Event;
import models.SchedulerUtil;

public class NewEventView extends JPanel{
    private JTextField txtEventDescription;
    private JTextField txtForwardEmail;
    private JFormattedTextField txtDate;
    private JRadioButton rdbtnDaily;
    private JRadioButton rdbtnWeekly;
    private JRadioButton rdbtnMonthly;
    private JCheckBox cbxAlarm;
    
    private final NewEventController newEventController;
        
    public NewEventView(NewEventController newEventController){
        this.newEventController = newEventController;
        
        make_frame();
        make_field_eventDesc();
        make_field_fwdEmail();
        make_field_date();
        make_field_frequency();
        make_field_alarm();
        make_btn_save();
        make_btn_clean();
        
    }
    
    private void cleanFields() {
        txtEventDescription.setText("");
        txtForwardEmail.setText("");
        txtDate.setText("");
        cbxAlarm.setSelected(false);
        rdbtnDaily.setSelected(true);
    }
    
    private void make_frame() { 
        setLayout(null);
    }
    private void make_field_eventDesc() {
        // Makes label
        JLabel lblEventDescription = new JLabel("Event description");
        lblEventDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEventDescription.setBounds(29, 29, 134, 14);
        add(lblEventDescription);

        // Makes text field
        txtEventDescription = new JTextField();
        txtEventDescription.setBounds(169, 26, 196, 20);
        add(txtEventDescription);
        txtEventDescription.setColumns(10);
    }
    private void make_field_fwdEmail() {
        // Makes label
        JLabel lblForwardEmail = new JLabel("Forward e-mail");
        lblForwardEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblForwardEmail.setBounds(29, 71, 104, 14);
        add(lblForwardEmail);

        // Makes text field
        txtForwardEmail = new JTextField();
        txtForwardEmail.setBounds(169, 68, 196, 20);
        add(txtForwardEmail);
        txtForwardEmail.setColumns(10);
    }
    private void make_field_date() {
        // Makes label
        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDate.setBounds(29, 119, 78, 14);
        add(lblDate);

        // Makes text field
        try {
            txtDate = new JFormattedTextField(new MaskFormatter("##/##/####"));
            txtDate.setBounds(169, 116, 96, 20);
            add(txtDate);
            txtDate.setColumns(10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private void make_field_frequency() {
        final ButtonGroup btgFrequency = new ButtonGroup();

        // Frequency label
        JLabel lblFrequency = new JLabel("Frequency");
        lblFrequency.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblFrequency.setBounds(29, 164, 78, 14);
        add(lblFrequency);

        // Daily option
        rdbtnDaily = new JRadioButton("Daily");
        btgFrequency.add(rdbtnDaily);
        rdbtnDaily.setSelected(true);
        rdbtnDaily.setBounds(169, 160, 60, 23);
        add(rdbtnDaily);

        // Weekly option
        rdbtnWeekly = new JRadioButton("Weekly");
        btgFrequency.add(rdbtnWeekly);
        rdbtnWeekly.setBounds(253, 160, 67, 23);
        add(rdbtnWeekly);

        // Monthly option
        rdbtnMonthly = new JRadioButton("Monthly");
        btgFrequency.add(rdbtnMonthly);
        rdbtnMonthly.setBounds(347, 160, 78, 23);
        add(rdbtnMonthly);
    }
    private void make_field_alarm() {
        // Makes check box
        cbxAlarm = new JCheckBox("Alarm");
        cbxAlarm.setBounds(29, 220, 97, 23);
        add(cbxAlarm);
    }
    private void make_btn_save() {
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(127, 220, 89, 23);
        add(btnSave);
        
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Event event = new Event();
                
                event.setEventDescription(txtEventDescription.getText());
                event.setForwardEmail(txtForwardEmail.getText());
                event.setDate(SchedulerUtil.getDateFromString(txtDate.getText()));
                if (rdbtnDaily.isSelected()) {
                    event.setFrequency(Frequency.DAILY.getFrequency());
                } else if (rdbtnWeekly.isSelected()) {
                    event.setFrequency(Frequency.WEEKLY.getFrequency());
                } else {
                    event.setFrequency(Frequency.MONTHLY.getFrequency());
                }
                event.setAlarm(cbxAlarm.isSelected());
                newEventController.addEvent(event);
                cleanFields();
            }
        });
    }
    private void make_btn_clean() {
        JButton btnClean = new JButton("Clean");
        btnClean.setBounds(253, 220, 89, 23);
        add(btnClean);
        
        btnClean.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cleanFields();
            }
        });
    }
}
