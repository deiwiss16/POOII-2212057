package views;

import controllers.NewGuestController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewGuestView extends JPanel {
    private JTextField txtName;
    private JTextField txtNumber;
    private JRadioButton rdbtnMale;
    private JRadioButton rdbtnFemale;
    private JComboBox<String> cmbDay;
    private JComboBox<String> cmbMonth;
    private JComboBox<String> cmbYear;
    private JTextField txtAddress;
    private JCheckBox cbxTermsConditions;
    private final NewGuestController newGuestController;
    
    public NewGuestView(NewGuestController newGuestController) {
        this.newGuestController = newGuestController;
        
        make_frame();
        make_field_name();
        make_field_number();
        make_field_genre();
        make_field_birth();
        /*make_field_address();
        make_field_term_condition();
        make_btn_register();*/
        make_btn_clean();
        
    }
    
    private void cleanFields() {
        txtName.setText("");
        txtNumber.setText("");
        rdbtnMale.setSelected(true);
        txtAddress.setText("");
        cbxTermsConditions.setSelected(false);
    }
    
    private void make_frame() { 
        setLayout(null);
    }

    private void make_field_name() {
        JLabel lblName = new JLabel("Ingresar Nombre");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblName.setBounds(29, 29, 134, 14);
        add(lblName);
        
        txtName = new JTextField();
        txtName.setBounds(169, 26, 196, 20);
        add(txtName);
        txtName.setColumns(10);
       
    }
    private void make_field_number(){
        JLabel lblNumber = new JLabel("Ingrese número de celular");
        lblNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNumber.setBounds(29, 71, 104, 14);
        add(lblNumber);

        // Makes text field
        txtNumber = new JTextField();
        txtNumber.setBounds(169, 68, 196, 20);
        add(txtNumber);
        txtNumber.setColumns(10);
    }
    private void make_field_genre(){
        final ButtonGroup btgGenre = new ButtonGroup();
        
        JLabel lblGenre = new JLabel("Genero");
        lblGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGenre.setBounds(29, 119, 78, 14);
        add(lblGenre);
        
        rdbtnMale = new JRadioButton("Daily");
        btgGenre.add(rdbtnMale);
        rdbtnMale.setSelected(true);
        rdbtnMale.setBounds(169, 116, 96, 20);
        add(rdbtnMale);

        // Weekly option
        rdbtnFemale = new JRadioButton("Weekly");
        btgGenre.add(rdbtnFemale);
        rdbtnFemale.setBounds(300, 116, 96, 20);
        add(rdbtnFemale);
    }
    private void make_field_birth() {
        JLabel lblBirth = new JLabel("Fecha de nacimiento");
        lblBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBirth.setBounds(29, 164, 78, 14);
        add(lblBirth);
        
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }
        cmbDay = new JComboBox<>(days);
        
        String[] months = { "January", "February", "March", "April", "May", "June", 
                            "July", "August", "September", "October", "November", "December" };
        cmbMonth = new JComboBox<>(months);
        
        String[] years = new String[25];
        for (int i = 0; i < 25; i++) {
            years[i] = Integer.toString(2000 + i);
        }
        cmbYear = new JComboBox<>(years);
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
