<%-- 
    Document   : index
    Created on : 31-dic-2020, 17:47:20
    Author     : PCGAMING
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="Model.usuario"%>
<%@page import="Model.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD-JAVA</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
         <section class="section_item flex-container color-3">
            <img src="image/crud.png" class="centro"> 
         </section>
         <%  Conexion con=new Conexion();
            int cont=0;
            usuario us1=new usuario(con);
            LinkedList<usuario> lista= us1.generarid();
            if(lista.size()>=1){
                cont=lista.size();cont++;
                for (int i = 0; i <lista.size(); i++) {
                   if(lista.get(i).getIdusuario()==cont)cont++;
                }
            }else{
                cont++;  
            }
        %>
        <div class="container">
            <div class="row">
                <div class="col-4">
                    <h3>Datos del Usuario </h3>
                    <form name="form_usuario" method="post" action="Controler_usuario" >
                        <input type="hidden"  name="idusuarioo" value="<%=cont%>" >
                        <div class="mb-3">
                          <label class="form-label">Nombre </label>
                          <input type="text" class="form-control"  name="nombress" placeholder="Ingrese el nombre">
                        </div>
                        <div class="mb-3">
                          <label class="form-label">Apellido </label>
                          <input type="text" class="form-control" name="apellidoss" placeholder="Ingrese el apellido">
                        </div>
                        <div class="mb-3">
                          <label  class="form-label">Correo </label>
                          <input type="email" class="form-control" name="correoo" placeholder="Ingrese el correo">
                        </div>
                        <button class="btn btn-success" type="submit" name="accion" value="registrar">Registrar</button>
                    </form>
                
                </div>
                 <% 
                            Conexion con1=new Conexion();
                            usuario user=new usuario(con1);
                            LinkedList<usuario> listausuarios= user.ListarUsuarios();
                               
                 %>         
                <div class="col-8">
                   <div class="card-body">
                      
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th class="text-center" >ID</th>
                                    <th class="text-center" >Nombre</th>
                                    <th class="text-center" >Apellido</th>
                                    <th class="text-center" >Correo</th>
                                    <th class="text-center" >Acciones</th>
                                </tr>
                            </thead>
                          
                            <tbody>
                              <%for (int i = 0; i < listausuarios.size(); i++) { %>  
                                  <tr>
                                      <td><%=listausuarios.get(i).getIdusuario()%> </td>
                                      <td><%=listausuarios.get(i).getNombre()%>  </td>
                                      <td><%=listausuarios.get(i).getApellido()%>  </td>
                                      <td><%=listausuarios.get(i).getCorreo()%>  </td>
                                      <td class="text-center">             
                                          <!-- En esta parte se pasa parámetros entre JSP -->
                                          <form method="post" action="editar_usuario.jsp" >
                                              <input type="hidden" value="<%=listausuarios.get(i).getIdusuario()%>" name="id_enviado">  
                                              <input type="hidden" value="<%=listausuarios.get(i).getNombre()%>" name="nombre_enviado">
                                              <input type="hidden" value="<%=listausuarios.get(i).getApellido()%>" name="apellido_enviado">
                                              <input type="hidden" value="<%=listausuarios.get(i).getCorreo()%>" name="correo_enviado">  
                                              <button type="submit" class="btn btn-warning" style="margin-right:100px;">Editar</button>
                                          </form>
                                          <!-- FIN PASAR PARÁMETRO -->
                                          <a class=" btn btn-danger" href="Controler_usuario?accion=Eliminar&id=<%=lista.get(i).getIdusuario()%>"
                                             style="margin-left:80px;margin-top:-68px"
                                           >Eliminar</a>
                                      </td>   

                                  </tr>
                                  <%}%>     
                             </tbody>
                        </table>
                    </div>
                </div>
            
            </div>
         
        </div>                 
    </body>
</html>
