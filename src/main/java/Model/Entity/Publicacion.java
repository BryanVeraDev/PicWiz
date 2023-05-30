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
    private Usuario autor;
    private java.sql.Date fechaPublicacion;
    private String imagenURL;
    private List<Comentario> comentarios;

    public Publicacion() {
    }

    
    public Publicacion(int id) {
        this.id = id;
    }

    public Publicacion(int id, String titulo, String descripcion, String imagenURL) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenURL = imagenURL;
    }
    
    public Publicacion(String titulo, String descripcion, Usuario autor, Date fechaPublicacion, String imagenURL) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = (java.sql.Date) fechaPublicacion;
        this.imagenURL = imagenURL;
    }

    public Publicacion(int id, String titulo, String descripcion, Usuario autor, Date fechaPublicacion, String imagenURL) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = (java.sql.Date) fechaPublicacion;
        this.imagenURL = imagenURL;
        
    }

    /*
    public int getIdPublicacion() {
        return id;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.id = idPublicacion;
    }*/

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

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = (java.sql.Date) fechaPublicacion;
    }

    
    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", autor=" + autor.getNombreUsuario() + ", fechaPublicacion=" + fechaPublicacion + ", imagenURL=" + imagenURL + '}';
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
