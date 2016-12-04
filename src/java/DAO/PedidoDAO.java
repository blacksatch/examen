/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.Conexion;
import Modelo.Pedido;
import Utilidades.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yo
 */
public class PedidoDAO 

{
    
    Util util =  new Util();
    public ArrayList<Pedido> ListarPedido(){
        ArrayList<Pedido> ListaPedido = new ArrayList<Pedido>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT pedido_id, despacho,total,fecha_hora,cliente_rut,plato_id,bebida_id FROM pedido;";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                Pedido ped = new Pedido();
                ped.setIdPedido(setResultados.getInt(1));
                ped.setDespacho(setResultados.getBoolean(2));
                ped.setTotal(setResultados.getInt(3));
                ped.setFechaPedido(setResultados.getString(4));
                ped.setRutCliente(setResultados.getString(5));
                ped.setPlato(setResultados.getInt(6));
                ped.setBebida(setResultados.getInt(7));
                                            
                ListaPedido.add(ped);
            }
            
            return ListaPedido;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();            
            return ListaPedido;
        }
    }
     
    public void agregarPedido(Pedido pedido){
        try
        {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("la_abuela");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
                
            
            String consulta = "INSERT INTO cliente VALUES('null,"+pedido.isDespacho()+"','"+pedido.getTotal()+"',"
                    + "'"+pedido.getFechaPedido()+"','"+pedido.getRutCliente()+"',"
                    + "'"+pedido.getBebida()+"');";           
            
            System.out.println(consulta);
            stms.executeUpdate(consulta);
            System.out.println("PEDIDO ALMACENADO");
            util.RegistrarLog("s", "PEDIDO ALMACENADO");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR AL ALMACENAR PEDIDO");
            ex.printStackTrace();
            util.RegistrarLog("e", "ERROR AL ALMACENAR PEDIDO");
        }
    }
    
}
