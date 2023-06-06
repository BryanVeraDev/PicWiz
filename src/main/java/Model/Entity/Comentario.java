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
public class Comentario {
    
    private int id;
    private Publicacion idPublicacion;
    private Usuario idUsuario;
    private String texto;
    private java.sql.Date fecha;
    
    
    public Comentario() {
    }

    
    public Comentario(int id, Publicacion idPublicacion, Usuario idUsuario, String texto, Date fecha) {
        this.id = id;
        this.idPublicacion = idPublicacion;
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.fecha = (java.sql.Date) fecha;
    }

    public Comentario(int id) {
        this.id = id;
    }
    
    public Comentario(int id, String texto, Date fecha) {
        this.id = id;
        this.texto = texto;
        this.fecha = (java.sql.Date) fecha;
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
     * @return the idPublicacion
     */
    public Publicacion getIdPublicacion() {
        return idPublicacion;
    }

    /**
     * @param idPublicacion the idPublicacion to set
     */
    public void setIdPublicacion(Publicacion idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    /**
     * @return the idUsuario
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = (java.sql.Date) fecha;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", Publicacion=" + "id: "+ idPublicacion.getId()+ ", titulo: " + idPublicacion.getTitulo() 
                + ", Usuario=" + "id: " + idUsuario.getId() + ", nombre: " + idUsuario.getNombre() + ", texto=" + texto + ", fecha=" + fecha + '}';
    }
    
    
    
}
