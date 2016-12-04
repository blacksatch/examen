/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.Conexion;
import Modelo.Cliente;
import Modelo.Plato;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author yo
 */
public class PlatoDAO {
    
    public Plato traePlatos(){
        Plato pl = new Plato();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT id,nombre,precio FROM plato;";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                pl.setIdPlato(setResultados.getInt(1));
                pl.setNombrePlato(setResultados.getString(2));
                pl.setPrecioPlato(setResultados.getInt(3));
            }
            
            return pl;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();            
            return pl;
        }
    }
    
}
