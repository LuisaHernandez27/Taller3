

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
                    <li><a href="kilometraje.html"> Facultades</a></li>
                    <li><a href="notas.html">Programa</a></li>
                </ul> 
            </nav>
            <h1>Estudiante</h1>

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
                        <td class="celdita">Codigo Estudiante</td>
                        <td class="celdita">Nombre Estudiante</td>
                        <td class="celdita">Apellido Estudiante</td>
                        <td class="celdita">Fecha nacimiento</td>
                        <td class="celdita">Celular</td>
                        <td class="celdita">Correo</td>
                        <td class="celdita">Usuario</td>
                        <td class="celdita">Contraseña</td>
                        <td class="celdita">Estado</td>


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
