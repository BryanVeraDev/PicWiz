/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Entity.Comentario;
import Model.Entity.Dao.ComentarioDao;
import Model.Entity.Publicacion;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author BRYAN VERA
 */
public class ComentarioTest {
    public static void main(String[] args) {
        ComentarioDao cdao = new ComentarioDao();
        Publicacion p = new Publicacion(9);
        Comentario c = new Comentario(2);
        
        Comentario c1 = cdao.consultarId(c);
        System.out.println(c1.toString());
        Comentario c2 = new Comentario(4, "Lugar muy lindo", c1.getFecha());
        //System.out.println(c1.toString());
        
        //System.out.println(cdao.borrar(c));
        
        System.out.println(cdao.actualizar(c2));
        
        
        //CONSULTAR 
        List<Comentario> comentarios = cdao.consultar(p);
        for (Comentario comentario : comentarios) {
            System.out.println(comentario.toString());
        }
        
    }
 
}
