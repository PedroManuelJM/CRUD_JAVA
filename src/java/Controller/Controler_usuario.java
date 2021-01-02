/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCGAMING
 */
public class Controler_usuario extends HttpServlet {


   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String accion = request.getParameter("accion");
           /*Se establece para que haiga una conexion y no tenga problemas con el error 500 */
           Conexion con = new Conexion();
           usuario us = new usuario(con);

           if (accion.equals("Eliminar")) {
               int id_usuario = Integer.parseInt(request.getParameter("id"));
               us.EliminarUsuario(id_usuario);/*en esta parte se elimina el usuario hacia la BD */
               request.getRequestDispatcher("index.jsp").forward(request, response);  /* redirecciona a esa paágina */
           }
       }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
          try (PrintWriter out = response.getWriter()) {
            
            String accion = request.getParameter("accion");
            /*Se establece para que haiga una conexion y no tenga problemas con el error 500 */
            Conexion con=new Conexion();
            usuario u = new usuario(con);
            
            if(accion.equals("registrar")){
                 int idusuar=Integer.parseInt(request.getParameter("idusuarioo"));
                 String nomb =request.getParameter("nombress"); 
                 String apell=request.getParameter("apellidoss"); 
                 String cor=request.getParameter("correoo"); 
                 u.agregarusuario(idusuar,nomb,apell,cor); /*en esta parte se registra los usuarios hacia la BD */
                 request.getRequestDispatcher("index.jsp").forward(request, response); /* redirecciona a esa paágina */
            } 

           if(accion.equals("editar")){
                 int id=Integer.parseInt(request.getParameter("idusu"));
                 /*Los parametros que estan en comillas como "nomb" 
                   vienen del JSP que son nombres del name=" " 
                 */
                 String nom =request.getParameter("nomb"); 
                 String ape=request.getParameter("apell"); 
                 String co=request.getParameter("corr"); 
                 /*Ya creadas las variables ,tomando como ejemplo: nom  esta guardara la variable 
                   para mandar el dato hacia la base de datos .
                 OJO: Lo mismo se aplica en registrar y eliminar usuarios .
                 */
                 u.ActualizarDatos(id,nom,ape,co,id);/*en esta parte se actualiza  los datos del usuarios hacia la BD */
                 request.getRequestDispatcher("index.jsp").forward(request, response);  /* redirecciona a esa paágina */
            } 

      }
    
  }
}