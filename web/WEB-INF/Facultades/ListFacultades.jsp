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
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <table class="table">
            <thead>
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
              <tr>
                <td>Nombre facultad</td>
                <td>Descripcion facultad</td>
                <td>          
                    <a href="ControladorCategoria?accion=Editar" class="btn btn-primary">Editar</a>
                    <a href="ControladorCategoria?accion=Eliminar" class="btn btn-primary">Eliminar</a>
                </td>

              </tr>
             <%
                 }
             %>
            </tbody>
          </table>
    </body>
</html>
