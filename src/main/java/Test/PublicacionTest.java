/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Entity.Dao.PublicacionDao;
import Model.Entity.Dao.UsuarioDao;
import Model.Entity.Publicacion;
import Model.Entity.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DANIELA
 */
public class PublicacionTest {
    public static void main(String[] args) {
        PublicacionDao pd = new PublicacionDao();
        
        //INSERTAR
        
        //Usuario usuario = new Usuario(117);
        //Publicacion p = new Publicacion( "post # 50 del día", "Yo en el trabajo", usuario, new java.sql.Date(new Date().getTime()), "imagen");
        //System.out.println(pd.insertar(p));
        
        //CONSULTAR
        List<Publicacion> publicaciones = pd.filtrarTitulo("la");
        for (Publicacion publicacione : publicaciones) {
            System.out.println(publicacione.toString());
        }
        
        //CONSULTAR POR ID
        //Publicacion p1 = new Publicacion(5);
        //System.out.println(pd.consultarId(p1).toString());
        // BORRAR
        
        //System.out.println(pd.borrar(p1));
        
        //ACTUALIZAR 
        /*Publicacion p = new Publicacion(7, "Era post #3 ", "Hola", "imagen nueva");
        System.out.println(pd.actualizar(p));*/
    }
}
