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
public class Usuario {

    private int id;
    private String nombre;
    private String contrasena;
    private String correo;
    private java.util.Date fecha_registro;
    private List<Seguidor> followers;
    private List<Seguidor> follows;

    public Usuario() {
    }
    
    
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
        this.nombre = nombre;
    }

    /**
     * Constructor Nombre, id
     */
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    /**
     * Constructor id, nombreUsuario, contrasena, correo
     */
    public Usuario(int id, String nombre, String contrasena, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
    }
    
    /**
     * Constructor nombreUsuario, contrasena, correo, fechaRegistro
     */
    public Usuario(String nombre, String contrasena, String correo, Date fechaRegistro) {
        
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.fecha_registro = fechaRegistro;
    }

    /**
     * Constructor id, nombreUsuario, contrasena, correo, fechaRegistro
     */
    public Usuario(int id, String nombre, String contrasena, String correo, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.fecha_registro = fechaRegistro;
    }

    /**
     * Constructor id, nombreUsuario, contrasena, correo, fechaRegistro, followers
     */
    public Usuario(int id, String nombreUsuario, String contrasena, Date fechaRegistro, List<Seguidor> followers) {
        this.id = id;
        this.nombre = nombreUsuario;
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
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombre(String nombreUsuario) {
        this.nombre = nombreUsuario;
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
     * @return the fecha_registro
     */
    public java.util.Date getFecha_registro() {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(java.util.Date fecha_registro) {
        this.fecha_registro = fecha_registro;
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
        return "Usuario{" + "id=" + getId() + ", nombreUsuario=" + getNombre() + ", contrasena=" + getContrasena() + ", fechaRegistro=" + getFecha_registro() + '}';
    }

    

}
