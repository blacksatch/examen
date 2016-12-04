/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.Conexion;
import Modelo.Comuna;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yo
 */
public class ComunaDAO {
    
    public ArrayList<Comuna> ListarComunas(){
        ArrayList<Comuna> listaComunas = new ArrayList<Comuna>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT id, descripcion FROM comuna;";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                Comuna com = new Comuna();
                com.setIdComuna(setResultados.getInt(1));
                com.setNombreComuna(setResultados.getString(2));
                listaComunas.add(com);
            }
            
            return listaComunas;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();            
            return listaComunas;
        }
    }
    
}
