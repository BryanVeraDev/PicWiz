/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Entity.Dao.UsuarioDao;
import Model.Entity.Usuario;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DANIELA
 */
public class UsuarioTest {
    public static void main(String[] args) {
        UsuarioDao u = new UsuarioDao();
        /* CONSULTAR 
        List<Usuario> usuarios = u.consultar();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }*/
        
        //INSERTAR
        
        Usuario usuario = new Usuario( 124,"Omar Jaimes", "123456", "omar@gmail.com", new java.sql.Date(new Date().getTime()));
        //System.out.println(u.insertar(usuario));
        
        //ELIMINAR
        
        System.out.println(u.login(usuario).toString());
        
        //System.out.println(u.borrar(usuario));
        
        //System.out.println(u.consultarId(usuario).toString());
        
        //ACTUALIZAR
        //System.out.println(u.actualizar(new Usuario(117, "Lizeth Vargas", "123", "danielavarga")));
    }
}
