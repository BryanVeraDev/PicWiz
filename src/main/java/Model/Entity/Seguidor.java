/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import java.util.Date;

/**
 *
 * @author DANIELA
 */
public class Seguidor {
   
    private int id;
    private Usuario seguidor;
    private Usuario seguido;
    private java.util.Date fechaSeguimiento;
    
    
    public Seguidor() {
    }
    
    public Seguidor(int id, Usuario seguidor, Usuario seguido, Date fechaSeguimiento) {
        this.id = id;
        this.seguidor = seguidor;
        this.seguido = seguido;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Seguidor(int id) {
        this.id = id;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the seguidor
     */
    public Usuario getSeguidor() {
        return seguidor;
    }

    /**
     * @param seguidor the seguidor to set
     */
    public void setSeguidor(Usuario seguidor) {
        this.seguidor = seguidor;
    }

    /**
     * @return the seguido
     */
    public Usuario getSeguido() {
        return seguido;
    }

    /**
     * @param seguido the seguido to set
     */
    public void setSeguido(Usuario seguido) {
        this.seguido = seguido;
    }

    /**
     * @return the fechaSeguimiento
     */
    public java.util.Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    /**
     * @param fechaSeguimiento the fechaSeguimiento to set
     */
    public void setFechaSeguimiento(java.util.Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    @Override
    public String toString() {
        return "Seguidor{" + "id=" + id + ", seguidor=" + seguidor.getId() + ", " + seguidor.getNombre() + ", seguido=" + seguido.getId() + ", " + seguido.getNombre() + ", fechaSeguimiento=" + fechaSeguimiento + '}';
    }
    
    
    
}
