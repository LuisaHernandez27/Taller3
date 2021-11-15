<%-- 
    Document   : EditarPrograma
    Created on : 14 nov. 2021, 18:38:34
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.Programa"%>
<%@page import="Entidades.Facultad"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          
        Programa programa = (Programa)request.getAttribute("programa");
        List<Facultad> facultades = (List<Facultad>)request.getAttribute("facultades");
      
        %>
        <form action="ControladorProgramas" method="post">
            <div >
                <div>
                    <h5 class="modal-title" id="exampleModalLabel">Editar Programa</h5>
                </div>
                <div class="modal-body">
                    <label for="codigo"> Código </label>
                    <input type="text" value="<%= programa.getCodPrograma() %>" name="Codigo" readonly="true">
                </div>
                <div class="modal-body">
                    <label for="des"> Descripción </label>
                    <input type="text" value="<%= programa.getDescripcion() %>" name="Descripcion">
                </div>
                <div class="modal-body">
                    <label for="des"> Código de facultad </label>

                    <select name="listaFacultades" >
                        <%
                        for(Facultad facultad: facultades){
                        %>
                        <option value="<%= facultad.getCodFacultad() %>" ${programa.getCodFacultad() == facultad.getCodFacultad()?"selected":""}>
                            <%= facultad.getDescripcion() %></option>
                        <%
                            }
                        %>
                    </select>

                    <input type="text" value="<%= programa.getCodFacultad() %>" name="CodFacultad">
                </div>
                <div class="modal-footer">
                    <input type="submit" name="accion" value="Actualizar" class="">
                    <input type="submit" name="accion" value="Cancelar" class="">
                </div>
            </div>
        </form>
    </body>
</html>
