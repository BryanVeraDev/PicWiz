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
    private Publicacion id_publicacion;
    private Usuario id_usuario;
    private String texto_comentario;
    private java.util.Date fecha;
    
    
    public Comentario() {
    }

    
    public Comentario(int id, Publicacion idPublicacion, Usuario idUsuario, String texto, Date fecha) {
        this.id = id;
        this.id_publicacion = idPublicacion;
        this.id_usuario = idUsuario;
        this.texto_comentario = texto;
        this.fecha = fecha;
    }

    public Comentario(int id) {
        this.id = id;
    }
    
    public Comentario(int id, String texto, Date fecha) {
        this.id = id;
        this.texto_comentario = texto;
        this.fecha =  fecha;
    }

    public Comentario(Publicacion id_publicacion, Usuario id_usuario, String texto_comentario, Date fecha) {
        this.id_publicacion = id_publicacion;
        this.id_usuario = id_usuario;
        this.texto_comentario = texto_comentario;
        this.fecha = fecha;
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
        return id_publicacion;
    }

    /**
     * @param idPublicacion the idPublicacion to set
     */
    public void setIdPublicacion(Publicacion idPublicacion) {
        this.id_publicacion = idPublicacion;
    }

    /**
     * @return the idUsuario
     */
    public Usuario getIdUsuario() {
        return id_usuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.id_usuario = idUsuario;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto_comentario;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto_comentario = texto;
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
        this.fecha = fecha;
    }

    
    
    
    
}
