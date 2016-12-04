/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author yo
 */
public class Cliente {
    private String rutCliente;
    private String claveCliente;
    private String nombreCliente;
    private String apPaternoCliente;
    private String apMaternoCliente;
    private String direccionCliente;
    private int numeracionCliente;
    private Comuna comuna_Cliente;
    private int telefonoCliente;
    
    public Cliente(){
        rutCliente = "";
        claveCliente = "";
        nombreCliente = "";
        apPaternoCliente = "";
        apMaternoCliente = "";
        direccionCliente = "";
        numeracionCliente = 0;
        comuna_Cliente =  new Comuna();
        telefonoCliente = 0;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(String claveCliente) {
        this.claveCliente = claveCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApPaternoCliente() {
        return apPaternoCliente;
    }

    public void setApPaternoCliente(String apPaternoCliente) {
        this.apPaternoCliente = apPaternoCliente;
    }

    public String getApMaternoCliente() {
        return apMaternoCliente;
    }

    public void setApMaternoCliente(String apMaternoCliente) {
        this.apMaternoCliente = apMaternoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public int getNumeracionCliente() {
        return numeracionCliente;
    }

    public void setNumeracionCliente(int numeracionCliente) {
        this.numeracionCliente = numeracionCliente;
    }

    public Comuna getComuna_Cliente() {
        return comuna_Cliente;
    }

    public void setComuna_Cliente(Comuna comuna_Cliente) {
        this.comuna_Cliente = comuna_Cliente;
    }

    

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
    
    
}
