/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Entity.Comentario;
import Model.Entity.Dao.ComentarioDao;
import Model.Entity.Publicacion;
import java.util.List;

/**
 *
 * @author BRYAN VERA
 */
public class ComentarioTest {
    public static void main(String[] args) {
        ComentarioDao c = new ComentarioDao();
        Publicacion p = new Publicacion(8);
        
        
        //CONSULTAR 
        List<Comentario> comentarios = c.consultar(p);
        for (Comentario comentario : comentarios) {
            System.out.println(comentario.toString());
        }
        
    }
 
}
