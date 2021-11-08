<%-- 
    Document   : ListFacultades
    Created on : 7 nov. 2021, 19:48:21
    Author     : Luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <h1>Facultades</h1>
        
        <a href="ControladorCategoria?accion=Eliminar" class="boton-nuevo">+</a>
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
                   for(int i=1;i<4;i++){
                %>
                <tr class="fila">
                    <td class="celdita">Nombre facultad</td>
                    <td class="celdita">Descripcion facultad</td>
                    <td class="celdita">          
                        <a href="ControladorCategoria?accion=Editar"  class="boton-verde">Editar</a>
                        <a href="ControladorCategoria?accion=Eliminar" class="boton-rojo">Eliminar</a>
                    </td>

                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
          
    </body>
</html>
