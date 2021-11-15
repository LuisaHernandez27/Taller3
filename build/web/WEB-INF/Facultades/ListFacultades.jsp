

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Facultad"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
         <div align="center" class="container">

           <img class="logoppal" src="imagenes/logo.jpg" alt="logo">
             
           
             <nav class="nav"> 

                <ul> 
                    <li><a href="principal.html"> Inicio</a></li>
                    <li><a href="EstudiantePrinciapl.jsp"> Estudiante</a></li>
                    <li><a href="ProgramaPrincipal.jsp">Programa</a></li>
                    <li><a class="botoncerrarsesion" href="index.html"> Cerrar sesión</a></li>
                </ul> 
            </nav>
            <%
                HttpSession sesion = request.getSession();
                List<Facultad> listaFacultades = (List<Facultad>) sesion.getAttribute("facultades");
            %>
        <h1>Facultades</h1>
        
        <!-- <a href="ControladorFacultad?accion=Insertar" class="boton-nuevo">+</a>-->
        
        <form action="ControladorFacultad" method="post">
            <div >
              <div>
                <h5 class="modal-title" id="exampleModalLabel">Nueva Facultad</h5>
              </div>
              <div class="modal-body">
                      <input type="text" name="descripcion" placeholder="Nombre Categoria" class="form-control">
              </div>
              <div class="modal-footer">
                <input type="submit" value="Agregar" name="accion" class="btn btn-primary" data-toggle="modal" data-terget="#nuevaCategoria">
              </div>
            </div>
        </form>
        
        
        
        
        
        
        
        <table class="tabla">
            <thead class="TablaCabecera">
              <tr>
                <th scope="col">Código</th>
                <th scope="col">Descripción</th>
                <th scope="col">Acciones</th>
              </tr>
            </thead>
            <tbody>

                <%
                   for(Facultad facultad: listaFacultades){
                %>
                <tr class="fila">
                    <td class="celdita"><%= facultad.getCodFacultad() %></td>
                    <td class="celdita"><%=  facultad.getDescripcion() %></td>
                    <td class="celdita">
                        <a href="ControladorFacultad?accion=Editar&cod=<%= facultad.getCodFacultad()%>"  class="boton-verde">Editar</a>
                        <a href="ControladorFacultad?accion=Eliminar&cod=<%= facultad.getCodFacultad()%>" class="boton-rojo">Eliminar</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
          
    </body>
    </div>
</html>
