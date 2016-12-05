/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.Conexion;
import Modelo.Bebida;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yo
 */
public class BebidaDAO {
    
    public ArrayList<Bebida> traeBebidas(){
        ArrayList<Bebida> listaBeb = new ArrayList<Bebida>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT id,nombre,precio FROM bebida;";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                Bebida beb = new Bebida();
                beb.setIdBebida(setResultados.getInt(1));
                beb.setNombreBebida(setResultados.getString(2));
                beb.setPrecioBebida(setResultados.getInt(3));
                listaBeb.add(beb);
            }
            
            return listaBeb;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();            
            return listaBeb;
        }
    }
    
}
