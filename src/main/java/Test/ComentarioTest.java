/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Entity.Comentario;
import Model.Entity.Dao.ComentarioDao;
import Model.Entity.Publicacion;
import Model.Entity.Usuario;
import java.util.Date;
import java.util.List;


/**
 *
 * @author BRYAN VERA
 */
public class ComentarioTest {
    public static void main(String[] args) {
        ComentarioDao cdao = new ComentarioDao();
        Publicacion p = new Publicacion(9);
        Date fecha = new Date();
        long f = fecha.getTime();
        System.out.println(f);
        Comentario c = new Comentario(5,"Lindo diseño de arte conceptual", new java.sql.Date(f));
 
        
        //Comentario c1 = cdao.consultarId(c);
        //System.out.println(c1.toString());
  
        //System.out.println(c1.toString());
        
        //System.out.println(cdao.borrar(c));
        
        System.out.println(cdao.actualizar(c));
        
        
        
        /*//CONSULTAR 
        List<Comentario> comentarios = cdao.consultar(p);
        for (Comentario comentario : comentarios) {
            System.out.println(comentario.toString());
        }*/
        
    }
 
}
