/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity.Dao;

import static Model.Entity.Dao.ComentarioDao.SQL_CONSULTAR;
import Model.Entity.Publicacion;
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

/**
 *
 * @author DANIELA
 */
public class PublicacionDao implements IPublicacion {

    final static String SQL_CONSULTAR = "SELECT u.id, u.nombre, p.id, p.titulo, p.descripcion, p.fecha_publicacion, p.imagen_URL FROM usuario u, publicacion p WHERE u.id = p.id_usuario";
    final static String SQL_INSERTAR = "INSERT INTO publicacion(id,titulo,descripcion, id_usuario, fecha_publicacion, imagen_URL) VAlUES(?,?,?,?,?,?)";
    final static String SQL_BORRAR = "DELETE FROM publicacion WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT u.id, u.nombre, p.id, p.titulo, p.descripcion, p.fecha_publicacion, p.imagen_URL FROM usuario u, publicacion p WHERE u.id = p.id_usuario AND p.id = ?";
    final static String SQL_CONSULTARIDUSUARIO = "SELECT u.id, u.nombre, p.id, p.titulo, p.descripcion, p.fecha_publicacion, p.imagen_URL FROM usuario u, publicacion p WHERE u.id = p.id_usuario AND p.id_usuario = ?";
    final static String SQL_ACTUALIZAR = "UPDATE publicacion SET titulo = ?, descripcion = ?, imagen_URL = ? WHERE id = ?";
    final static String SQL_FILTRO = "SELECT u.id, u.nombre, p.id, p.titulo, p.descripcion, p.fecha_publicacion, p.imagen_URL FROM usuario u, publicacion p WHERE u.id = p.id_usuario AND titulo LIKE ";

    @Override
    public int insertar(Publicacion publicacion) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(4, publicacion.getId_usuario().getId());
            sentencia.setInt(1, publicacion.getId());
            sentencia.setString(2, publicacion.getTitulo());
            sentencia.setString(3, publicacion.getDescripcion());
            sentencia.setDate(5, new java.sql.Date(publicacion.getFecha_publicacion().getTime()));
            sentencia.setString(6, publicacion.getImagen_URL());

            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public List<Publicacion> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("p.id");
                String titulo = resultado.getString("titulo");
                String descripcion = resultado.getString("descripcion");
                int idUsuario = resultado.getInt("u.id");
                String nombreUsuario = resultado.getString("nombre");
                java.sql.Timestamp timestamp = resultado.getTimestamp("p.fecha_publicacion");
                java.util.Date fecha = new java.util.Date(timestamp.getTime());
                String imagen = resultado.getString("imagen_URL");
                Publicacion p = new Publicacion(id, titulo, descripcion, new Usuario(idUsuario,nombreUsuario), fecha, imagen);
                publicaciones.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return publicaciones;
    }
    
    public List<Publicacion> consultarIdUsuario(int idUsuarioPublicacion) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARIDUSUARIO, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, idUsuarioPublicacion);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("p.id");
                String titulo = resultado.getString("titulo");
                String descripcion = resultado.getString("descripcion");
                int idUsuario = resultado.getInt("u.id");
                String nombreUsuario = resultado.getString("nombre");
                java.sql.Timestamp timestamp = resultado.getTimestamp("p.fecha_publicacion");
                java.util.Date fecha = new java.util.Date(timestamp.getTime());
                String imagen = resultado.getString("imagen_URL");
                Publicacion p = new Publicacion(id, titulo, descripcion, new Usuario(idUsuario,nombreUsuario), fecha, imagen);
                publicaciones.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return publicaciones;
    }

    @Override
    public Publicacion consultarId(Publicacion publicacion) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Publicacion rPublicacion = null;
        try {
            
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, publicacion.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("p.id");
            String titulo = resultado.getString("p.titulo");
            String descripcion = resultado.getString("p.descripcion");
            String nombreUsuario = resultado.getString("u.nombre");
            int idUsuario = resultado.getInt("u.id");
            java.sql.Timestamp timestamp = resultado.getTimestamp("p.fecha_publicacion");
            java.util.Date fecha = new java.util.Date(timestamp.getTime());
            String imagen = resultado.getString("p.imagen_URL");

            rPublicacion = new Publicacion(id, titulo, descripcion, new Usuario(idUsuario,nombreUsuario), fecha, imagen);

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(resultado != null)
                    BaseDatos.close(resultado);
                if(sentencia != null)
                    BaseDatos.close(sentencia);
                if(connection != null)
                    BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return rPublicacion;
    }

    @Override
    public int borrar(Publicacion publicacion) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, publicacion.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDao.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Publicacion publicacion) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(4, publicacion.getId());
            sentencia.setString(1, publicacion.getTitulo());
            sentencia.setString(2, publicacion.getDescripcion());
            sentencia.setString(3, publicacion.getImagen_URL());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    
    public List<Publicacion> filtrarTitulo(String ref) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_FILTRO + "'%"+ref+"%'");
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("p.id");
                String titulo = resultado.getString("p.titulo");
                String descripcion = resultado.getString("p.descripcion");
                int idUsuario = resultado.getInt("u.id");
                String nombreUsuario = resultado.getString("u.nombre");
                java.sql.Timestamp timestamp = resultado.getTimestamp("p.fecha_publicacion");
                java.util.Date fecha = new java.util.Date(timestamp.getTime());
                String imagen = resultado.getString("imagen_URL");
                Publicacion p = new Publicacion(id, titulo, descripcion, new Usuario(idUsuario,nombreUsuario), fecha, imagen);
                publicaciones.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return publicaciones;
    }

}
