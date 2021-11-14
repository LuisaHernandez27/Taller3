

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
        <h1>Programas</h1>
        
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
                    <td class="celdita">Codigo Programa</td>
                    <td class="celdita">Descripcion</td>
                    <td class="celdita">Codigo Facultad</td>
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

