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
            
            String consulta = "SELECT P.pedido_id,PL.nombre,B.nombre,C.direccion,C.telefono,CM.descripcion,P.fecha_hora,P.total"
                    + "FROM pedido P JOIN cliente C ON P.cliente_rut = C.rut"
                    + "JOIN plato PL ON P.plato_id = PL.id"
                    + "JOIN bebida B ON P.bebida_id = B.id"
                    + "JOIN comuna CM ON C.comuna_id = CM.id;";
            
            System.out.println(consulta);            
            
            ResultSet setResultados = stms.executeQuery(consulta);
            
            while(setResultados.next())
            {
                Pedido ped = new Pedido();
                ped.setIdPedido(setResultados.getInt(1));
                ped.getPlato().setNombrePlato(setResultados.getString(2));
                ped.getBebida().setNombreBebida(setResultados.getString(3));
                ped.getCliente().setDireccionCliente(setResultados.getString(4));
                ped.getCliente().setTelefonoCliente(setResultados.getInt(5));
                ped.getCliente().getComuna_Cliente().setNombreComuna(setResultados.getString(6));
                ped.setFechaPedido(setResultados.getString(7));
                ped.setTotal(setResultados.getInt(8));
                                            
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
                    + "'"+pedido.getFechaPedido()+"','"+pedido.getCliente().getRutCliente()+"',"
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
