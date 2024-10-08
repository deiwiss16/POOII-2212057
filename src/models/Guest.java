package models;

import java.util.Date;

public class Guest {
    private String nombre;
    private String numero;
    private String genero;
    private Date fechaNacimiento;
    private String direccion;
    private Boolean terminosCondiciones;
    
    public Guest() {
    }

    public Guest(String nombre, String numero, String genero, Date fechaNacimiento, String direccion, Boolean terminosCondiciones) {
        this.nombre = nombre;
        this.numero = numero;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.terminosCondiciones = terminosCondiciones;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getTerminosCondiciones() {
        return terminosCondiciones;
    }
    public void setTerminosCondiciones(Boolean terminosCondiciones) {
        this.terminosCondiciones = terminosCondiciones;
    }

    @Override
    public String toString() {
        return "Invitado:" + "\nnombre: " + nombre + "\nnumero: " + numero + "\ngenero: " + genero + "\nfechaNacimiento: " + fechaNacimiento + "\ndireccion: " + direccion + "\nterminosCondiciones: " + terminosCondiciones;
    }
}
