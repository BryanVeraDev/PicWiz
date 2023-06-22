/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Entity.Dao.SeguidorDao;
import Model.Entity.Seguidor;
import Model.Entity.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BRYAN VERA
 */
public class SeguidorTest {
    public static void main(String[] args) {
        SeguidorDao sdao = new SeguidorDao();
        List<Seguidor> seguidor = sdao.consultarSeguidores(135);
        for (Seguidor usuario : seguidor) {
            System.out.println(usuario.toString());
        }
        
        //Seguidor s = new Seguidor(2);
        //System.out.println(sdao.borrar(s));
        
        Date fecha = new Date();
        long f = fecha.getTime();
        
        Usuario u1 = new Usuario(122);
        Usuario u2 = new Usuario(123);
        
        Seguidor s = new Seguidor(2,u1, u2, new java.sql.Date(f));
        System.out.println(sdao.insertar(s));
        
        seguidor = sdao.consultarSeguidores(135);
        for (Seguidor usuario : seguidor) {
            System.out.println(usuario.toString());
        }
        
    }
    
}
