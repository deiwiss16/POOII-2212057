package views;

import controllers.NewGuestController;
import enums.Frequency;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import models.Event;
import models.Guest;
import models.SchedulerUtil;

public class NewGuestView extends JPanel {
    private JTextField txtNombre;
    private JTextField txtNumero;
    private JRadioButton rdbtnMasculino;
    private JRadioButton rdbtnFemenino;
    private JComboBox<String> cmbDia;
    private JComboBox<String> cmbMes;
    private JComboBox<String> cmbYear;
    private JTextField txtDireccion;
    private JCheckBox cbxTerminosCondiciones;
    private final NewGuestController newGuestController;
    
    public NewGuestView(NewGuestController newGuestController) {
        this.newGuestController = newGuestController;
        
        make_frame();
        make_field_name();
        make_field_number();
        make_field_genre();
        make_field_birth();
        make_field_address();
        make_field_term_condition();
        make_btn_register();
        make_btn_clean();
        
    }
    
    private void cleanFields() {
        txtNombre.setText("");
        txtNumero.setText("");
        rdbtnMasculino.setSelected(true);
        cmbDia.setSelectedIndex(0);
        cmbMes.setSelectedIndex(0);
        cmbYear.setSelectedIndex(0);
        txtDireccion.setText("");
        cbxTerminosCondiciones.setSelected(false);
    }
    
    private void make_frame() { 
        setLayout(null);
    }

    private void make_field_name() {
        JLabel lblNombre = new JLabel("Ingresar Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNombre.setBounds(15, 15, 134, 14);
        add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(180, 15, 196, 20);
        add(txtNombre);
        txtNombre.setColumns(10);
       
    }
    private void make_field_number(){
        JLabel lblNumero = new JLabel("Ingrese número de celular:");
        lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNumero.setBounds(15, 60, 150, 14);
        add(lblNumero);
        
        txtNumero = new JTextField();
        txtNumero.setBounds(180, 60, 196, 20);
        add(txtNumero);
        txtNumero.setColumns(10);
    }
    private void make_field_genre(){
        final ButtonGroup btgGenero = new ButtonGroup();
        
        JLabel lblGenero = new JLabel("Genero:");
        lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGenero.setBounds(15, 105, 78, 14);
        add(lblGenero);
        
        rdbtnMasculino = new JRadioButton("Masculino");
        btgGenero.add(rdbtnMasculino);
        rdbtnMasculino.setSelected(true);
        rdbtnMasculino.setBounds(180, 105, 96, 20);
        add(rdbtnMasculino);

        // Weekly option
        rdbtnFemenino = new JRadioButton("Femenino");
        btgGenero.add(rdbtnFemenino);
        rdbtnFemenino.setBounds(280, 105, 96, 20);
        add(rdbtnFemenino);
    }
    private void make_field_birth() {
        JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
        lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblFechaNacimiento.setBounds(15, 150, 150, 14);
        add(lblFechaNacimiento);
        
        String[] dias = new String[31];
        for (int i = 0; i < 31; i++) {
            dias[i] = String.format("%02d", (i + 1));
        }
        cmbDia = new JComboBox<>(dias);
        cmbDia.setBounds(180, 146, 50, 20);
        add(cmbDia);
        
        String[] meses = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        cmbMes = new JComboBox<>(meses);
        cmbMes.setBounds(247, 146, 50, 20);
        add(cmbMes);
        
        String[] years = new String[25];
        for (int i = 0; i < 25; i++) {
            years[i] = Integer.toString(2000 + i);
        }
        cmbYear = new JComboBox<>(years);
        cmbYear.setBounds(315, 146, 60, 20);
        add(cmbYear);
    }
    private void make_field_address() {
        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDireccion.setBounds(15, 195, 150, 14);
        add(lblDireccion);
        
        txtDireccion = new JTextField();
        txtDireccion.setBounds(180, 195, 196, 20);
        add(txtDireccion);
        txtDireccion.setColumns(10);
    }
    private void make_field_term_condition() {
        cbxTerminosCondiciones = new JCheckBox("Aceptar Terminos y Condiciones");
        cbxTerminosCondiciones.setBounds(15, 230, 300, 14);
        add(cbxTerminosCondiciones);
    }
    
    
    private void make_btn_register() {
        JButton btnRegister = new JButton("Registrar");
        btnRegister.setBounds(180, 275, 89, 23);
        add(btnRegister);
        
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(txtNombre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(NewGuestView.this, "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                } else if(txtNumero.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(NewGuestView.this, "El numero celular es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNumero.requestFocus();
                    return;
                } else if(txtDireccion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(NewGuestView.this, "La direccion es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDireccion.requestFocus();
                    return;
                } else {
                    Guest guest = new Guest();

                    guest.setNombre(txtNombre.getText());
                    guest.setNumero(txtNumero.getText());
                    if(rdbtnMasculino.isSelected()) {
                        guest.setGenero("Masculino");
                    } else if(rdbtnFemenino.isSelected()) {
                        guest.setGenero("Femenino");
                    }

                    String birth = cmbDia.getSelectedItem().toString() + "/" + 
                            String.format("%02d", cmbMes.getSelectedIndex()+1) + "/" + 
                            cmbYear.getSelectedItem().toString();
                    guest.setFechaNacimiento(SchedulerUtil.getDateFromString(birth));
                    guest.setDireccion(txtDireccion.getText());
                    guest.setTerminosCondiciones(cbxTerminosCondiciones.isSelected());

                    newGuestController.addGuest(guest);
                    JOptionPane.showMessageDialog(NewGuestView.this, "El invitado " + guest.getNombre() + " fue ingresado correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    cleanFields();
                }
            }
        });
    }
    private void make_btn_clean() {
        JButton btnClean = new JButton("Resetear");
        btnClean.setBounds(285, 275, 89, 23);
        add(btnClean);
        
        btnClean.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cleanFields();
            }
        });
    }
}
