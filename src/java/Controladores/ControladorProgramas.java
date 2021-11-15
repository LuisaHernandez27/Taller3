/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Facultad;
import Entidades.Programa;
import Modelos.FacultadDAO;
import Modelos.ProgramaDAO;
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
@WebServlet(name = "ControladorProgramas", urlPatterns = {"/ControladorProgramas"})
public class ControladorProgramas extends HttpServlet {

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
            out.println("<title>Servlet ControladorProgramas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProgramas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void ListarProgramas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession listac = request.getSession();
        List<Programa> listaProgramas = new ProgramaDAO().ListarPrograma();
        List<Facultad> listaFacultades = new FacultadDAO().ListarFacultad();
        listac.setAttribute("programa", listaProgramas);
        listac.setAttribute("facultades", listaFacultades);
        RequestDispatcher rd = request.getRequestDispatcher("ProgramaPrincipal.jsp");
        rd.forward(request, response);
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
         int cod = Integer.parseInt(request.getParameter("cod"));
         new ProgramaDAO().eliminar(cod);
         this.ListarProgramas(request, response);
         
     }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cod = Integer.parseInt(request.getParameter("cod"));
        //Categorias c = new Categorias(cod);
        Programa programa = new ProgramaDAO().buscarPorCodigo(cod);
        List<Facultad> listaFacultades = new FacultadDAO().ListarFacultad();
        request.setAttribute("programa", programa);
        request.setAttribute("facultades", listaFacultades);
        String pgEditar = "/WEB-INF/Programas/EditarPrograma.jsp";
        request.getRequestDispatcher(pgEditar).forward(request, response);
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        int cod = Integer.parseInt(request.getParameter("Codigo"));
        String des = request.getParameter("Descripcion");
        int facultad = Integer.parseInt(request.getParameter("listaFacultades"));
        Programa programa = new Programa(cod, des, facultad);
        int fila = new ProgramaDAO().editar(programa);
        this.ListarProgramas(request, response);
    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Programa nuevoPrograma;
        String des = request.getParameter("descripcion");
        int facultad = Integer.parseInt(request.getParameter("listaFacultades"));
        nuevoPrograma = new Programa(des, facultad);
        new ProgramaDAO().insertar(nuevoPrograma);
        this.ListarProgramas(request, response);
        
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
                this.ListarProgramas(request, response);
            }
            
        }else{
        this.ListarProgramas(request, response);
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
                    this.ListarProgramas(request, response);
                    break;
                default:
                    this.ListarProgramas(request, response);
                
            }
            
        }else{
            this.ListarProgramas(request, response);
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
