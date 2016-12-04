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
public class Plato {
    private int idPlato;
    private String nombrePlato;
    private int precioPlato;
    
    public Plato(){
        idPlato = 0;
        nombrePlato = "";
        precioPlato = 0;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public int getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(int precioPlato) {
        this.precioPlato = precioPlato;
    }
    
    
}
