/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Entity.Dao;

import Model.Entity.Comentario;
import Model.Entity.Publicacion;
import java.util.List;

/**
 *
 * @author BRYAN VERA
 */
public interface IComentario {
    public int insertar(Comentario comentario);
    public List<Comentario> consultar(Publicacion id);
    public Comentario consultarId(Comentario comentario);
    public int borrar(Comentario comentario);
    public int actualizar(Comentario comentario);
    
}
