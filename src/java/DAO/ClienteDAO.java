/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.Conexion;
import Modelo.Cliente;
import Utilidades.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author yo
 */
public class ClienteDAO {
    
    Util util = new Util();
    public void agregarCliente(Cliente cliente){
        try
        {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            
            String consulta = "INSERT INTO cliente VALUES('"+cliente.getClaveCliente()+"','"+cliente.getRutCliente()+"',"
                    + "'"+cliente.getNombreCliente()+"','"+cliente.getApPaternoCliente()+"',"
                    + "'"+cliente.getApMaternoCliente()+"','"+cliente.getDireccionCliente()+"',"
                    + "'"+cliente.getNumeracionCliente()+"',"
                    + "'"+cliente.getTelefonoCliente()+"','"+cliente.getComunaCliente()+"');";           
            
            System.out.println(consulta);
            stms.executeUpdate(consulta);
            System.out.println("CLIENTE ALMACENADO");
            util.RegistrarLog("s", "cliente "+cliente.getNombreCliente()+" "+cliente.getApPaternoCliente()+""
                    + " "+cliente.getApMaternoCliente()+" almacenado");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR AL ALMACENAR CLIENTE");
            ex.printStackTrace();
            util.RegistrarLog("e", "error al almacenar");
        }
    }
    
    /*public ArrayList<Cliente> listarCliente(){
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("prueba_tres");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT cliente_id,cliente_rut,cliente_nombre,cliente_mail,cliente_fecha_nacimiento"
                    + " FROM cliente;";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                Cliente cliente = new Cliente();
                cliente.setCliente_id(setResultados.getInt(1));
                cliente.setCliente_rut(setResultados.getString(2));
                cliente.setCliente_nombre(setResultados.getString(3));
                cliente.setCliente_mail(setResultados.getString(4));
                cliente.setCliente_fechaNac(setResultados.getString(5));
                listaClientes.add(cliente);
            }
            
            return listaClientes;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();            
            return listaClientes;
        }               
    }*/
    
    public Cliente buscaCliete(String rut){
        Cliente cliente = new Cliente();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT nombre, apellido_paterno, apellido_materno"
                    + " FROM cliente WHERE rut = '"+rut+"';";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                cliente.setNombreCliente(setResultados.getString(1));
                cliente.setApPaternoCliente(setResultados.getString(2));
                cliente.setApMaternoCliente(setResultados.getString(3));
            }
            
            return cliente;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();            
            return cliente;
        }
    }
    
    public boolean buscaClieteRut(String rut){
        boolean found = false;
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT rut FROM cliente WHERE rut = '"+rut+"';";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                found = true;
            }
            
            return found;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();            
            return found;
        }
    }
    
    public boolean validaCliente(String rut, String pass){
        boolean valid = false;
        
        
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");

            Statement stms = conexion.createStatement();

            String consulta = "SELECT nombre FROM cliente WHERE rut = '"+rut+"' AND clave = '"+pass+"';";

            System.out.println(consulta);            

            ResultSet setResultados = stms.executeQuery(consulta);

            while(setResultados.next())
            {
                valid = true;
            }

            return valid;
        } catch (Exception e) {
            e.printStackTrace();
            return valid;
        }
    
    }
    
    public boolean modificarCliente(String rut, String mail){
            Cliente cliente = new Cliente();
            boolean mod = false;
        
            try
            {
                Conexion conn = new Conexion();
                Connection conexion = conn.getConnection("prueba_tres");

                Statement stms = conexion.createStatement();

                String consulta = "UPDATE cliente SET cliente_mail = '"+mail+"' WHERE cliente_rut = '"+rut+"';";

                System.out.println(consulta);            

                stms.executeUpdate(consulta);
                System.out.println("Modificado Correctamente");
                return mod = true;
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace(); 
                System.out.println("Error al Modificar");
                return mod;
            }
        
    }
}
