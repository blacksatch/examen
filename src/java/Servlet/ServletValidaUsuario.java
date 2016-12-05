/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ClienteDAO;
import DAO.ComunaDAO;
import Modelo.Cliente;
import Modelo.Comuna;
import Utilidades.Util;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yo
 */
@WebServlet(name = "ServletValidaUsuario", urlPatterns = {"/ServletValidaUsuario"})
public class ServletValidaUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        
            String btnIngresar = request.getParameter("btnIngresar");
            String btnCierra = request.getParameter("btnCerrarSesion");
            String btnRegistrar = request.getParameter("btnRegistrar");
            String btnRegistrar2 = request.getParameter("btnRegistrar2");
            RequestDispatcher dispatcher = null;
            HttpSession sesion =  request.getSession(true);
            sesion.setAttribute("sesion_ingreso_correcto", 0);
            sesion.setAttribute("sesion_valida_rut_error", 0);
            sesion.setAttribute("sesion_valida_mal", 0);
            
            
            if (btnIngresar != null) {
                String rutLog = request.getParameter("txtRutLog");
                String passLog = request.getParameter("txtPassLog");
                if (buscaClienteRut(rutLog)) {
                    if (validaCliente(rutLog, passLog)) {
                        Cliente traeCli = new Cliente();
                        traeCli = traeCliente(rutLog);
                        String nombreCompleto = traeCli.getNombreCliente()+" "+traeCli.getApPaternoCliente()+" "+traeCli.getApMaternoCliente();
                        sesion.setAttribute("sesion_usuario_bienvenido", nombreCompleto);
                        dispatcher = getServletContext().getRequestDispatcher("/menu.jsp");
                        dispatcher.forward(request, response);
                    }else{
                        sesion.setAttribute("sesion_valida_mal", 1);
                        dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                        dispatcher.forward(request, response);
                    }
                }else{
                    sesion.setAttribute("sesion_valida_mal", 1);
                    dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (btnRegistrar != null || btnRegistrar2 != null) {
                if (btnRegistrar2 != null) {
                    sesion.setAttribute("sesion_lista_comuna", ListaComunas());
                    dispatcher = getServletContext().getRequestDispatcher("/registro.jsp");
                    dispatcher.forward(request, response);
                }else if (btnRegistrar != null) {
                    Cliente nuevoCli = new Cliente();
                    nuevoCli.setClaveCliente(request.getParameter("txtClaveReg"));
                    nuevoCli.setNombreCliente(request.getParameter("txtNombreReg"));
                    nuevoCli.setApPaternoCliente(request.getParameter("txtApPaternoReg"));
                    nuevoCli.setApMaternoCliente(request.getParameter("txtApMaternoReg"));
                    nuevoCli.setDireccionCliente(request.getParameter("txtDireccionReg"));
                    nuevoCli.setNumeracionCliente(Integer.parseInt(request.getParameter("txtNumeracionReg")));
                    nuevoCli.getComuna_Cliente().setIdComuna(Integer.parseInt(request.getParameter("cmb_Comuna")));
                    nuevoCli.setTelefonoCliente(Integer.parseInt(request.getParameter("txtTelefonoReg")));
                    if (validaRut(request.getParameter("txtRutReg"))) {
                        nuevoCli.setRutCliente(request.getParameter("txtRutReg"));
                        AgregarCliente(nuevoCli);
                        sesion.setAttribute("sesion_ingreso_correcto", 1);
                        dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                        dispatcher.forward(request, response);
                    } else{
                        sesion.setAttribute("sesion_valida_rut_error", 1);
                        dispatcher = getServletContext().getRequestDispatcher("/registro.jsp");
                        dispatcher.forward(request, response);
                    }   
                }   
            }
            
        }
    }
    
    public Cliente traeCliente(String rut){
        ClienteDAO ctrlCli = new ClienteDAO();
        Cliente cli = new Cliente();
        try {
            cli = ctrlCli.buscaCliete(rut);
            return cli;
        } catch (Exception e) {
            e.printStackTrace();
            return cli;
        }
        
    }

    public boolean buscaClienteRut(String rut){
        ClienteDAO ctrlCli = new ClienteDAO();
        boolean encontrado = false;
        try {
            encontrado = ctrlCli.buscaClieteRut(rut);
            return encontrado;
        } catch (Exception e) {
            e.printStackTrace();
            return encontrado;
        }
    }
    
    public boolean validaCliente(String rut, String pass){
        boolean valida = false;
        ClienteDAO ctrlCli = new ClienteDAO();
        try {
            valida = ctrlCli.validaCliente(rut, pass);
            return valida;
        } catch (Exception e) {
            e.printStackTrace();
            return valida;
        }
    }
    
    public ArrayList<Comuna> ListaComunas(){
        ComunaDAO ctrlCom = new ComunaDAO();
        ArrayList<Comuna> listaCom = new ArrayList<Comuna>();
        try {
            listaCom = ctrlCom.ListarComunas();
            return listaCom;
        } catch (Exception e) {
            e.printStackTrace();
            return listaCom;
        }
    }
    
    public void AgregarCliente(Cliente cli){
       ClienteDAO ctrlCli = new ClienteDAO();
        try {
            ctrlCli.agregarCliente(cli);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean validaRut(String rut){
        Util u = new Util();
        try {
            return u.validarRut(rut);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
