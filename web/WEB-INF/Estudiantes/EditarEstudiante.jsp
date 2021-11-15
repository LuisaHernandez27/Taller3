<%-- 
    Document   : EditarEstudiante
    Created on : 14 nov. 2021, 22:40:06
    Author     : Luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.Estudiantes"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Estudiantes estudiante = (Estudiantes)request.getAttribute("estudiante");
      %>
        <form action="Controladorestudiante" method="post">
            <div >
              <div>
                <h5 class="modal-title" id="exampleModalLabel">Editar Estudiante</h5>
              </div>
              <div class="modal-body">
                <label for="codigo"> Código </label>
                <input type="text" value="<%= estudiante.getCodEstudiante() %>" name="Codigo" readonly="true">
              </div>
              <div class="modal-body">
                <label for="des"> Nombre </label>
                <input type="text" value="<%= estudiante.getNombreEstudiante() %>" name="Nombre">
              </div>
              <div class="modal-body">
                <label for="des"> Apellido </label>
                <input type="text" value="<%= estudiante.getApellidoEstudiante() %>" name="Apellido">
              </div>
              <div class="modal-body">
                <label for="des"> Fecha de nacimiento </label>
                <input type="date" value="<%= estudiante.getFechaNacimiento() %>" name="Fecha">
              </div>
              <div class="modal-body">
                <label for="des"> Celular </label>
                <input type="number" value="<%= estudiante.getCeluar() %>" name="Celular">
              </div>
              <div class="modal-body">
                <label for="des"> Correo </label>
                <input type="text" value="<%= estudiante.getEmail() %>" name="Correo">
              </div>
              <div class="modal-body">
                <label for="des"> Estado </label>
                <select name="Estado" >
                    <option value="activo" ${"activo" == estudiante.getEstado()? "selected":""} >Activo</option>
                    <option value="inactivo" ${"inactivo" == estudiante.getEstado()? "selected":""} >Inactivo</option>
                </select>
              </div>
              <div class="modal-footer">
                <input type="submit" name="accion" value="Actualizar" class="">
                <input type="submit" name="accion" value="Cancelar" class="">
              </div>
            </div>
        </form>
    </body>
</html>
