/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ClienteDAO;
import DAO.ComunaDAO;
import Modelo.Comuna;
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
            
            String rutLog = request.getParameter("txtRutLog");
            String passLog = request.getParameter("txtPassLog");
            String btnIngresar = request.getParameter("btnIngresar");
            String btnRegistrar = request.getParameter("btnRegistrar");
            RequestDispatcher dispatcher = null;
            HttpSession sesion =  request.getSession(true);
            
            
            if (btnIngresar != null) {
                if (buscaClienteRut(rutLog)) {
                    if (validaCliente(rutLog, passLog)) {
                        dispatcher = getServletContext().getRequestDispatcher("/menu.jsp");
                        dispatcher.forward(request, response);
                    }else{
                        dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                        dispatcher.forward(request, response);
                    }
                }
            } else if (btnRegistrar != null) {
                sesion.setAttribute("sesion_lista_comuna", ListaComunas());
                dispatcher = getServletContext().getRequestDispatcher("/registro.jsp");
                dispatcher.forward(request, response);
            }
            
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
