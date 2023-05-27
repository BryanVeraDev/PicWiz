/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author DANIELA
 */
public class Seguidor {
   
    private int id;
    private Usuario seguidor;
    private Usuario seguido;
    private java.sql.Date fechaSeguimiento;

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
    public java.sql.Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    /**
     * @param fechaSeguimiento the fechaSeguimiento to set
     */
    public void setFechaSeguimiento(java.sql.Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }
    
}
