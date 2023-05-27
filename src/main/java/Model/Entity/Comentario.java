/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import java.sql.Date;

/**
 *
 * @author DANIELA
 */
public class Comentario {
    
    private int id;
    private int idUsuario;
    private int idPublicacion;
    private Usuario usuario;
    private String texto;
    private java.sql.Date fecha;

    public Comentario() {
    }

    public Comentario(int id, int idUsuario, int idPublicacion, Usuario usuario, String texto, Date fecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idPublicacion = idPublicacion;
        this.usuario = usuario;
        this.texto = texto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    
}
