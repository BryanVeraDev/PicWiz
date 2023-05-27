/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author DANIELA
 */
public class Usuario {

    private int id;
    private String nombreUsuario;
    private String contrasena;
    private String correo;
    private java.sql.Date fechaRegistro;
    private List<Seguidor> followers;
    private List<Seguidor> follows;
    
    /**
     * Constructor id
     */
    public Usuario(int id) {
        this.id = id;
    }
    
    /**
     * Constructor Nombre
     */
    public Usuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    /**
     * Constructor Nombre, id
     */
    public Usuario(int id, String nombreUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
    }
    
    /**
     * Constructor id, nombreUsuario, contrasena, correo
     */
    public Usuario(int id, String nombreUsuario, String contrasena, String correo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }
    
    /**
     * Constructor nombreUsuario, contrasena, correo, fechaRegistro
     */
    public Usuario(String nombreUsuario, String contrasena, String correo, Date fechaRegistro) {
        
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Constructor id, nombreUsuario, contrasena, correo, fechaRegistro
     */
    public Usuario(int id, String nombreUsuario, String contrasena, String correo, Date fechaRegistro) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Constructor id, nombreUsuario, contrasena, correo, fechaRegistro, followers
     */
    public Usuario(int id, String nombreUsuario, String contrasena, Date fechaRegistro, List<Seguidor> followers) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        //this.fechaRegistro = fechaRegistro;
        this.followers = followers;
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
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the fechaRegistro
     */
    public java.sql.Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(java.sql.Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the followers
     */
    public List<Seguidor> getFollowers() {
        return followers;
    }

    /**
     * @param followers the followers to set
     */
    public void setFollowers(List<Seguidor> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + getId() + ", nombreUsuario=" + getNombreUsuario() + ", contrasena=" + getContrasena() + ", fechaRegistro=" + getFechaRegistro() + '}';
    }

}
