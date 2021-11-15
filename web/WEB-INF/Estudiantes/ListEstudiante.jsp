

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Estudiantes"%>
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

            <div class="padrebanner">
                <div class="hijobanner"><img class="logoppal" src="imagenes/logo.jpg" alt="logo"></div>
                <div class="hijobanner">UNIVERSIDAD ABC</div>
                <div class="hijobanner"><a class="botoncerrarsesion" href="index.html">  Cerrar sesión </a></div>
            </div>
            <nav class="nav"> 

                <ul> 
                    <li><a href="imc.html"> Inicio</a></li>
                    <li><a href="kilometraje.html"> Facultades</a></li>
                    <li><a href="notas.html">Programa</a></li>
                </ul> 
            </nav>

            <%
                HttpSession sesion = request.getSession();
                List<Estudiantes> listaEstudiantes = (List<Estudiantes>) sesion.getAttribute("estudiantes");
            %>

            <h1>Estudiante</h1>


            <form action="Controladorestudiante" method="post">
                <div >
                    <div>
                        <h5 class="modal-title" id="exampleModalLabel">Nuevo Estudiante</h5>
                    </div>
                    <div class="modal-body">
                        <input type="text" name="nombre" placeholder="Nombre" class="form-control">
                    </div>
                    <div class="modal-body">
                        <input type="text" name="apellido" placeholder="Apellido" class="form-control">
                    </div>
                    <div class="modal-body">
                        <input type="date" name="fecha" placeholder="Fecha de nacimiento" class="form-control">
                    </div>
                    <div class="modal-body">
                        <input type="number" name="celular" placeholder="Celular" class="form-control">
                    </div>
                    <div class="modal-body">
                        <input type="text" name="correo" placeholder="Correo" class="form-control">
                    </div>
                    <div class="modal-body">
                        <label for="des"> Estado </label>
                        <select name="Estado" >
                            <option value="activo" >Activo</option>
                            <option value="inactivo" >Inactivo</option>
                        </select>
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
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Fecha de nacimiento</th>
                        <th scope="col">Celular</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Estado</th>

                    </tr>
                </thead>
                <tbody>

                    <%
                       for(Estudiantes estudiante: listaEstudiantes){
                    %>
                    <tr class="fila">
                        <td class="celdita"><%= estudiante.getCodEstudiante() %></td>
                        <td class="celdita"><%= estudiante.getNombreEstudiante() %></td>
                        <td class="celdita"><%= estudiante.getApellidoEstudiante() %></td>
                        <td class="celdita"><%= estudiante.getFechaNacimiento() %></td>
                        <td class="celdita"><%= estudiante.getCeluar() %></td>
                        <td class="celdita"><%= estudiante.getEmail() %></td>
                        <td class="celdita"><%= estudiante.getEstado() %></td>


                        <td class="celdita">          
                            <a href="Controladorestudiante?accion=Editar&cod=<%= estudiante.getCodEstudiante()%>"  class="boton-verde">Editar</a>
                            <a href="Controladorestudiante?accion=Eliminar&cod=<%= estudiante.getCodEstudiante()%>" class="boton-rojo">Eliminar</a>
                        </td>

                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

    </body>
</html>
