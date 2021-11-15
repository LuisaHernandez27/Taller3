/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estudiantes;
import Modelos.EstudiantesDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luisa
 */
@WebServlet(name = "Controladorestudiante", urlPatterns = {"/Controladorestudiante"})
public class Controladorestudiante extends HttpServlet {

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
            out.println("<title>Servlet Controladorestudiante</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controladorestudiante at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void ListarEstudiantes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession listac = request.getSession();
        List<Estudiantes> listaEstudiantes = new EstudiantesDAO().ListarEstudiantes();
        listac.setAttribute("estudiantes", listaEstudiantes);
        RequestDispatcher rd = request.getRequestDispatcher("EstudiantePrincipal.jsp");
        rd.forward(request, response);
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
         int cod = Integer.parseInt(request.getParameter("cod"));
         new EstudiantesDAO().eliminar(cod);
         this.ListarEstudiantes(request, response);
     }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cod = Integer.parseInt(request.getParameter("cod"));
        //Categorias c = new Categorias(cod);
        Estudiantes estudiante = new EstudiantesDAO().buscarPorCodigo(cod);
        request.setAttribute("estudiante", estudiante);
        String pgEditar = "/WEB-INF/Estudiantes/EditarEstudiante.jsp";
        request.getRequestDispatcher(pgEditar).forward(request, response);
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        int cod = Integer.parseInt(request.getParameter("Codigo"));
        String nombre = request.getParameter("Nombre");
        String apellido = request.getParameter("Apellido");
        String fecha = request.getParameter("Fecha");
        int celular = Integer.parseInt(request.getParameter("Celular"));
        String correo = request.getParameter("Correo");
        String estado = request.getParameter("Estado");
        Estudiantes estudiante = new Estudiantes(cod, nombre,apellido,fecha,celular,correo, estado);
        int fila = new EstudiantesDAO().editar(estudiante);
        this.ListarEstudiantes(request, response);
    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fecha = request.getParameter("fecha");
        
        Estudiantes nuevoEstudiante;
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int celular = Integer.parseInt(request.getParameter("celular"));
        String correo = request.getParameter("correo");
        String estado = request.getParameter("Estado");
        
        nuevoEstudiante = new Estudiantes(nombre, apellido,fecha,celular,correo,estado);
        new EstudiantesDAO().insertar(nuevoEstudiante);
        this.ListarEstudiantes(request, response);
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
                this.ListarEstudiantes(request, response);
            }
            
        }else{
        this.ListarEstudiantes(request, response);
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
                    this.ListarEstudiantes(request, response);
                    break;
                default:
                    this.ListarEstudiantes(request, response);
                
            }
            
        }else{
            this.ListarEstudiantes(request, response);
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
