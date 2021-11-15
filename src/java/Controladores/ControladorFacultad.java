/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Facultad;
import Modelos.FacultadDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Luisa
 */
@WebServlet(name = "ControladorFacultad", urlPatterns = {"/ControladorFacultad"})
public class ControladorFacultad extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorFacultad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFacultad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void ListarFacultades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession listac = request.getSession();
        List<Facultad> listaFacultades = new FacultadDAO().ListarFacultad();
        listac.setAttribute("facultades", listaFacultades);
        
        RequestDispatcher rd = request.getRequestDispatcher("FacultadesPrincipal.jsp");
        rd.forward(request, response);
    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Facultad nuevaFacultad;
        String des = request.getParameter("descripcion");
        nuevaFacultad = new Facultad(des);
        new FacultadDAO().insertar(nuevaFacultad);
        this.ListarFacultades(request, response);
        
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
         int cod = Integer.parseInt(request.getParameter("cod"));
         new FacultadDAO().eliminar(cod);
         this.ListarFacultades(request, response);
         
     }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cod = Integer.parseInt(request.getParameter("cod"));
        //Categorias c = new Categorias(cod);
        Facultad facultad = new FacultadDAO().buscarPorCodigo(cod);
        request.setAttribute("facultad", facultad);
        String pgEditar = "/WEB-INF/Facultades/EditarFacultad.jsp";
        request.getRequestDispatcher(pgEditar).forward(request, response);
    }
    
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        int cod = Integer.parseInt(request.getParameter("Codigo"));
        String des = request.getParameter("Descripcion");
        Facultad facultad = new Facultad(cod, des);
        int fila = new FacultadDAO().editar(facultad);
        this.ListarFacultades(request, response);
    
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
         String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                
                case "Editar":                    
                    this.editar(request, response);                    
                    break;
                case "Eliminar":
                    this.eliminar(request, response);
                    break;
                default:
                this.ListarFacultades(request, response);
            }
            
        }else{
        this.ListarFacultades(request, response);
        }
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
        String accion = request.getParameter("accion");
        if (accion != null) {
            
            switch (accion) {
                
                case "Agregar":
                    this.insertar(request, response);
                    break;
                case "Actualizar":
                    this.actualizar(request, response);
                    break;
                case "Cancelar":
                    this.ListarFacultades(request, response);
                    break;
                default:
                    this.ListarFacultades(request, response);
                
            }
            
        }else{
            this.ListarFacultades(request, response);
        }
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
