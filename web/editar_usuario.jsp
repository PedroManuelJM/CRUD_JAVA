<%-- 
    Document   : editar_usuario
    Created on : 01-ene-2021, 18:20:45
    Author     : PCGAMING
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>Editar Usuario</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <!-- En esta parte recibe los parámetros del index.jsp -->
        <%
            int id_recibido = Integer.parseInt(request.getParameter("id_enviado"));
            String nombre_recibido = (String)request.getParameter("nombre_enviado");
            String apellido_recibido = request.getParameter("apellido_enviado");
            String correo_recibido = request.getParameter("correo_enviado");
        %>
        <!-- Fin -->
        <section class="section_item flex-container color-3">      
            <h5>Editar datos Usuario </h5>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-6">
                     <img src="image/crud.png" class="centro"> 
                </div>
                <div class="col-6">
                    <form name="form_usuario" method="post" action="Controler_usuario" >
                        <input type="hidden"  name="idusu" value="<%=id_recibido%>">
                        <div class="mb-3">
                            <label class="form-label">Nombre </label>
                            <input type="text" class="form-control" name="nomb" value="<%=nombre_recibido%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Apellido </label>
                            <input type="text" class="form-control" name="apell" value="<%=apellido_recibido%>">
                        </div>
                        <div class="mb-3">
                            <label  class="form-label">Correo </label>
                            <input type="email" class="form-control" name="corr" value="<%=correo_recibido%>">
                        </div>
                        <button class="btn btn-info" type="submit" name="accion" value="editar">Actualizar</button>
                        <a class="btn btn-danger" href="index.jsp">Cancelar</a>
                    </form>
                </div>
            </div>        
        </div>

    </body>
</html>
