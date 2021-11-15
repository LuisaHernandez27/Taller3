<%-- 
    Document   : EditarFacultad
    Created on : 14 nov. 2021, 17:44:49
    Author     : Luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.Facultad"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edición de Facultad</title>
    </head>
    <body>
        <%
          
        Facultad cat = (Facultad)request.getAttribute("facultad");
      
      %>
        <form action="ControladorFacultad" method="post">
            <div >
              <div>
                <h5 class="modal-title" id="exampleModalLabel">Editar Facultad</h5>
              </div>
              <div class="modal-body">
                <label for="codigo"> Código </label>
                <input type="text" value="<%= cat.getCodFacultad() %>" name="Codigo" readonly="true">
              </div>
              <div class="modal-body">
                <label for="des"> Descripción </label>
                <input type="text" value="<%= cat.getDescripcion() %>" name="Descripcion">
              </div>
              <div class="modal-footer">
                <input type="submit" name="accion" value="Actualizar" class="">
                <input type="submit" name="accion" value="Cancelar" class="">
              </div>
            </div>
        </form>
    </body>
</html>
