package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedList;
import Model.usuario;
import Model.Conexion;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>CRUD-JAVA</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilos.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <section class=\"section_item flex-container color-3\">\n");
      out.write("            <img src=\"image/crud.png\" class=\"centro\"> \n");
      out.write("         </section>\n");
      out.write("         ");
  Conexion con=new Conexion();
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
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-4\">\n");
      out.write("                    <h3>Datos del Usuario </h3>\n");
      out.write("                    <form name=\"form_usuario\" method=\"post\" action=\"Controler_usuario\" >\n");
      out.write("                        <input type=\"hidden\"  name=\"idusuarioo\" value=\"");
      out.print(cont);
      out.write("\" >\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                          <label class=\"form-label\">Nombre </label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\"  name=\"nombress\" placeholder=\"Ingrese el nombre\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                          <label class=\"form-label\">Apellido </label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" name=\"apellidoss\" placeholder=\"Ingrese el apellido\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                          <label  class=\"form-label\">Correo </label>\n");
      out.write("                          <input type=\"email\" class=\"form-control\" name=\"correoo\" placeholder=\"Ingrese el correo\">\n");
      out.write("                        </div>\n");
      out.write("                        <button class=\"btn btn-success\" type=\"submit\" name=\"accion\" value=\"registrar\">Registrar</button>\n");
      out.write("                    </form>\n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("                 ");
 
                            Conexion con1=new Conexion();
                            usuario user=new usuario(con1);
                            LinkedList<usuario> listausuarios= user.ListarUsuarios();
                               
                 
      out.write("         \n");
      out.write("                <div class=\"col-8\">\n");
      out.write("                   <div class=\"card-body\">\n");
      out.write("                      \n");
      out.write("                        <table id=\"example1\" class=\"table table-bordered table-striped\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th class=\"text-center\" >ID</th>\n");
      out.write("                                    <th class=\"text-center\" >Nombre</th>\n");
      out.write("                                    <th class=\"text-center\" >Apellido</th>\n");
      out.write("                                    <th class=\"text-center\" >Correo</th>\n");
      out.write("                                    <th class=\"text-center\" >Acciones</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                          \n");
      out.write("                            <tbody>\n");
      out.write("                              ");
for (int i = 0; i < listausuarios.size(); i++) { 
      out.write("  \n");
      out.write("                                  <tr>\n");
      out.write("                                      <td>");
      out.print(listausuarios.get(i).getIdusuario());
      out.write(" </td>\n");
      out.write("                                      <td>");
      out.print(listausuarios.get(i).getNombre());
      out.write("  </td>\n");
      out.write("                                      <td>");
      out.print(listausuarios.get(i).getApellido());
      out.write("  </td>\n");
      out.write("                                      <td>");
      out.print(listausuarios.get(i).getCorreo());
      out.write("  </td>\n");
      out.write("                                      <td class=\"text-center\">             \n");
      out.write("                                          <!-- En esta parte se pasa parámetros entre JSP -->\n");
      out.write("                                          <form method=\"post\" action=\"editar_usuario.jsp\" >\n");
      out.write("                                              <input type=\"hidden\" value=\"");
      out.print(listausuarios.get(i).getIdusuario());
      out.write("\" name=\"id_enviado\">  \n");
      out.write("                                              <input type=\"hidden\" value=\"");
      out.print(listausuarios.get(i).getNombre());
      out.write("\" name=\"nombre_enviado\">\n");
      out.write("                                              <input type=\"hidden\" value=\"");
      out.print(listausuarios.get(i).getApellido());
      out.write("\" name=\"apellido_enviado\">\n");
      out.write("                                              <input type=\"hidden\" value=\"");
      out.print(listausuarios.get(i).getCorreo());
      out.write("\" name=\"correo_enviado\">  \n");
      out.write("                                              <button type=\"submit\" class=\"btn btn-warning\" style=\"margin-right:100px;\">Editar</button>\n");
      out.write("                                          </form>\n");
      out.write("                                          <!-- FIN PASAR PARÁMETRO -->\n");
      out.write("                                          <a class=\" btn btn-danger\" href=\"Controler_usuario?accion=Eliminar&id=");
      out.print(lista.get(i).getIdusuario());
      out.write("\"\n");
      out.write("                                             style=\"margin-left:80px;margin-top:-68px\"\n");
      out.write("                                           >Eliminar</a>\n");
      out.write("                                      </td>   \n");
      out.write("\n");
      out.write("                                  </tr>\n");
      out.write("                                  ");
}
      out.write("     \n");
      out.write("                             </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </div>\n");
      out.write("         \n");
      out.write("        </div>                 \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
