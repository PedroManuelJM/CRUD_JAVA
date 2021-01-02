
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class usuario {

    //Atributos
    private int idusuario;
    private String nombre;
    private String apellido;
    private String correo;

    Conexion conn ;
    //Cosntructor
    public usuario() {
        
    }
    public usuario(Conexion conn) {
         this.conn = conn;
    }
        
 

    public usuario(int idusuario, String nombre, String apellido, String correo) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 

    public LinkedList<usuario> ListarUsuarios(){
      
        try{
            String query = "select * from usuario";
            LinkedList<usuario> lista; 
            Statement sentencia = conn.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(query);
            
            lista= new LinkedList<usuario>();
            
            while(resultado.next()){    
                usuario u = new usuario();
                u.setIdusuario(resultado.getInt("idusuario"));
                u.setNombre(resultado.getString("nombres"));
                u.setApellido(resultado.getString("apellidos"));
                u.setCorreo(resultado.getString("correo"));
                lista.add(u);
            }
              sentencia.close();  // cerrando 
              conn.desconectar(); // termina la conexion 
            return lista;
            
        }catch(Exception ex){
            System.out.print("problemas en conexion ");
        }
        return null;
    }
    
     public void agregarusuario(int idusuario, String nombres, String apellidos,String correo) {
        try{
            String query = "insert into usuario values (?,?,?,?);";
            PreparedStatement sentencia= conn.getConnection().prepareStatement(query);
            sentencia.setInt(1,idusuario);
            sentencia.setString(2,nombres);
            sentencia.setString(3,apellidos);
            sentencia.setString(4,correo);
            sentencia.executeUpdate();
            sentencia.close(); // cerrando consulta
            conn.desconectar(); // termina la conexion 
            
        }catch(Exception ex){
            System.out.print("problemas en conexion a la hora de registrar ");
        }
        
    }
     
    public void ActualizarDatos(int idusuario2,String nombres,String apellidos,String correo,int idusuario){
          try {
             
                String query = "UPDATE usuario SET idusuario=?, ";
                query = query + "nombres=?, ";
                query = query + "apellidos=?, ";
                query = query + "correo=? ";
                query = query + "WHERE idusuario=? ;";
                PreparedStatement sentencia= conn.getConnection().prepareStatement(query);
                sentencia.setInt(1,idusuario2);
                sentencia.setString(2,nombres);
                sentencia.setString(3,apellidos);
                sentencia.setString(4,correo);
                sentencia.setInt(5,idusuario);       
                sentencia.executeUpdate();
                sentencia.close(); // cerrando
                conn.desconectar();
          } catch (Exception ex) {  
              System.out.println("Problemas en ActualizarDatos");
          }
      } 

  public void EliminarUsuario(int idusuario){
        try {
            String query = "DELETE FROM usuario WHERE idusuario=?; ";
            PreparedStatement sentencia = conn.getConnection().prepareStatement(query);
            sentencia.setInt(1, idusuario);
            sentencia.executeUpdate();
            sentencia.close(); // cerrando
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("Problemas en EliminarUsuario");
        }
    }      
     
    public LinkedList<usuario> generarid(){
       String query = "select * from usuario";
       LinkedList<usuario> lista; 
        try{  
            Statement sentencia = conn.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(query);
            lista= new LinkedList<usuario>();

            while(resultado.next()){ 
                usuario u = new usuario();
                u.setIdusuario(resultado.getInt("idusuario"));
                lista.add(u);
            } 
              sentencia.close();  // cerrando 
              conn.desconectar(); // termina la conexion 
            return lista;
            
        }catch(Exception ex){
            System.out.print("problemas en conexion Generar ID");
        }
        return null;
    }
    
    
}
