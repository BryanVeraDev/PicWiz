/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity.Dao;

import Model.Entity.Usuario;
import Red.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DANIELA
 */
public class UsuarioDao implements IUsuario {

    final static String SQL_CONSULTAR = "SELECT * FROM usuario";
    final static String SQL_INSERTAR = "INSERT INTO usuario(id,nombre,contrasena,correo,fecha_registro) VAlUES(?,?,?,?,?)";
    final static String SQL_BORRAR = "DELETE FROM usuario WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM usuario WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE usuario SET nombre = ?, contrasena = ?, correo = ? WHERE id = ?";

    @Override
    public int insertar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(1, usuario.getId());
            sentencia.setString(2, usuario.getNombreUsuario());
            sentencia.setString(3, usuario.getContrasena());
            sentencia.setString(4, usuario.getCorreo());
            sentencia.setDate(5, new java.sql.Date(usuario.getFechaRegistro().getTime()));
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public List<Usuario> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String contrasena = resultado.getString("contrasena");
                String correo = resultado.getString("correo");
                long f = resultado.getTime("fecha_registro").getTime();
                java.sql.Date fecha = new java.sql.Date(f);

                Usuario usuario = new Usuario(id, nombre, contrasena, correo, fecha);
                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return usuarios;
    }

    @Override
    public Usuario consultarId(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Usuario rUsuario = null;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, usuario.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String contrasena = resultado.getString("contrasena");
            String correo = resultado.getString("correo");
            long f = resultado.getTime("fecha_registro").getTime();
            java.sql.Date fecha = new java.sql.Date(f);
            java.util.Date fech = new java.util.Date(fecha.getTime());

            rUsuario = new Usuario(id, nombre, contrasena, correo, fecha);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return rUsuario;
    }

    @Override
    public int borrar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, usuario.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(4, usuario.getId());
            sentencia.setString(1, usuario.getNombreUsuario());
            sentencia.setString(2, usuario.getContrasena());
            sentencia.setString(3, usuario.getCorreo());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    public boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return correo.matches(regex);
    }
    
    public void encriptarContraseña(String contraseña) {
        String salt = BCrypt.gensalt();
        BCrypt.hashpw(contraseña, salt);
    }
    
    public boolean verificarContraseña(String contraseña, Usuario usuario) {
        return BCrypt.checkpw(contraseña, usuario.getContrasena());
    }
    
    public boolean subirImagen() {
        return false;
    }

    public boolean eliminarImagen() {
        return false;
    }

    /*public void encriptarContraseña() {
        String salt = BCrypt.gensalt();
        this.contrasena = BCrypt.hashpw(this.contrasena, salt);
    }*/

    /*public boolean verificarContraseña(String contraseña) {
        return BCrypt.checkpw(contraseña, this.contrasena);
    }*/

}
