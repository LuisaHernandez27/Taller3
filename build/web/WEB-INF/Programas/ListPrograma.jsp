

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Programa"%>
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

            <div class="padrebanner">
                <div class="hijobanner"><img class="logoppal" src="imagenes/logo.jpg" alt="logo"></div>
                <div class="hijobanner">UNIVERSIDAD ABC</div>
                <div class="hijobanner"><a class="botoncerrarsesion" href="index.html">  Cerrar sesión </a></div>
            </div>
             <nav class="nav"> 

                <ul> 
                    <li><a href="imc.html"> Inicio</a></li>
                    <li><a href="kilometraje.html"> Estudiante</a></li>
                    <li><a href="notas.html">Facultades</a></li>
                </ul> 
            </nav>
              <%
                HttpSession sesion = request.getSession();
                List<Programa> listaProgramas = (List<Programa>) sesion.getAttribute("programa");
                List<Facultad> facultades = (List<Facultad>)sesion.getAttribute("facultades");
            %>
        <h1>Programas</h1>
        
        <!--<a href="ControladorProgramas?accion=Eliminar" class="boton-nuevo">+</a>-->
         <form action="ControladorProgramas" method="post">
            <div >
                <div>
                    <h5 class="modal-title" id="exampleModalLabel">Nuevo programa</h5>
                </div>
                <div class="modal-body">
                    <input type="text" name="descripcion" placeholder="Nombre programa" class="form-control">
                </div>
                <select name="listaFacultades" >
                    <%
                    for(Facultad facultad: facultades){
                    %>
                    <option value="<%= facultad.getCodFacultad() %>">
                        <%= facultad.getDescripcion() %></option>
                    <%
                        }
                    %>
                </select>
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
                <th scope="col">Codigo de Facultad</th>
                <th scope="col">Acciones</th>
              </tr>
            </thead>
            <tbody>

                <%
                  for(Programa programa: listaProgramas){

                %>
                <tr class="fila">
                    <td class="celdita"><%= programa.getCodPrograma() %></td>
                    <td class="celdita"><%=  programa.getDescripcion() %></td>
                    <td class="celdita"><%=  programa.getCodFacultad() %></td>
                    <td class="celdita">          
                        <a href="ControladorProgramas?accion=Editar&cod=<%= programa.getCodPrograma()%>"  class="boton-verde">Editar</a>
                        <a href="ControladorProgramas?accion=Eliminar&cod=<%= programa.getCodPrograma()%>" class="boton-rojo">Eliminar</a>
                    </td>

                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
          
    </body>
</html>

