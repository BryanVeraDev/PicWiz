/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DANIELA
 */
public class Publicacion {
    
    private int id;
    private String titulo;
    private String descripcion;
    private Usuario id_usuario;
    private java.util.Date fecha_publicacion;
    private String imagen_URL;
    private List<Comentario> comentarios;

    public Publicacion() {
    }

    
    public Publicacion(int id) {
        this.id = id;
    }

    public Publicacion(int id, String titulo, String descripcion, String imagen_URL) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen_URL = imagen_URL;
    }
    
    public Publicacion(String titulo, String descripcion, Usuario id_usuario, Date fecha_publicacion, String imagen_URL) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_usuario = id_usuario;
        this.fecha_publicacion = fecha_publicacion;
        this.imagen_URL = imagen_URL;
    }

    public Publicacion(int id, String titulo, String descripcion, Usuario id_usuario, Date fecha_publicacion, String imagen_URL) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_usuario = id_usuario;
        this.fecha_publicacion = fecha_publicacion;
        this.imagen_URL = imagen_URL;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getImagen_URL() {
        return imagen_URL;
    }

    public void setImagen_URL(String imagen_URL) {
        this.imagen_URL = imagen_URL;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", autor=" + id_usuario.getNombre() + ", fechaPublicacion=" + fecha_publicacion + ", imagenURL=" + imagen_URL + '}';
    }
    
    
    public boolean descargar(){
        return false;
    }
    
    public String comentar(){
        return null;
    }
    
    public void likear(){
        
    }
}
