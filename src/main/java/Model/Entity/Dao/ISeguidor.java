/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Entity.Dao;


import Model.Entity.Seguidor;
import java.util.List;

/**
 *
 * @author BRYAN VERA
 */
public interface ISeguidor {
    public int insertar(Seguidor seguidor);
    public List<Seguidor> consultar();
    public int borrar(Seguidor seguidor);
    
}
