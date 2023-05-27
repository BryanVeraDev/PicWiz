/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Entity.Dao;

import Model.Entity.Publicacion;
import java.util.List;

/**
 *
 * @author DANIELA
 */
public interface IPublicacion {
    public int insertar(Publicacion publicacion);
    public List<Publicacion> consultar();
    public Publicacion consultarId(Publicacion publicacion);
    public int borrar(Publicacion publicacion);
    public int actualizar(Publicacion publicacion);
}
