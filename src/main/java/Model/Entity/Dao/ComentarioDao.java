/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity.Dao;

import Model.Entity.Comentario;
import Model.Entity.Publicacion;
import Model.Entity.Usuario;
import Red.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BRYAN VERA
 */
public class ComentarioDao implements IComentario{
    
    /*;*/
    
    final static String SQL_CONSULTAR = "SELECT u1.id, u1.nombre, u2.id, u2.nombre, p.id, p.titulo, p.descripcion,p.id_usuario"
            + ", p.fecha_publicacion, p.imagen_URL, c.id, c.texto_comentario, c.id_publicacion, c.fecha "
            + "FROM usuario u1, usuario u2, publicacion p, comentario c "
            + "WHERE u1.id = c.id_usuario AND u2.id = p.id_usuario AND p.id = c.id_publicacion AND p.id = ?";
    final static String SQL_INSERTAR = "INSERT INTO comentario(texto_comentario,fecha,id_usuario ,id_publicacion) VAlUES(?,?,?,?)";
    final static String SQL_BORRAR = "DELETE FROM comentario WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT u1.id, u1.nombre, u2.id, u2.nombre, p.id, p.titulo, p.descripcion,p.id_usuario"
            + ", p.fecha_publicacion, p.imagen_URL, c.id, c.texto_comentario, c.id_publicacion, c.fecha "
            + "FROM usuario u1, usuario u2, publicacion p, comentario c "
            + "WHERE u1.id = c.id_usuario AND u2.id = p.id_usuario AND p.id = c.id_publicacion AND c.id = ?";
    final static String SQL_CONSULTARIDUSUARIO = "SELECT u1.id, u1.nombre, u2.id, u2.nombre, p.id, p.titulo, p.descripcion,p.id_usuario"
            + ", p.fecha_publicacion, p.imagen_URL, c.id, c.texto_comentario, c.id_publicacion, c.fecha "
            + "FROM usuario u1, usuario u2, publicacion p, comentario c "
            + "WHERE u1.id = c.id_usuario AND u2.id = p.id_usuario AND p.id = c.id_publicacion AND u1.id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE comentario SET texto_comentario = ?, fecha = ? WHERE id = ?";

    @Override
    public int insertar(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);        
            //sentencia.setInt(1, comentario.getId());
            sentencia.setString(1, comentario.getTexto());
            sentencia.setDate(2, new java.sql.Date(comentario.getFecha().getTime()));
            sentencia.setInt(3, comentario.getIdUsuario().getId());
            sentencia.setInt(4, comentario.getIdPublicacion().getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    
    @Override
    public List<Comentario> consultar(Publicacion publicacion) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Comentario> comentarios = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            //sentencia = connection.prepareStatement(SQL_CONSULTAR);
            //sentencia.setInt(1, publicacion.getId());
            //resultado = sentencia.executeQuery();
            sentencia = connection.prepareStatement(SQL_CONSULTAR, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, publicacion.getId());
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                //Comentario
                int idComentario = resultado.getInt("c.id");
                String texto = resultado.getString("c.texto_comentario");
                java.sql.Timestamp timestamp = resultado.getTimestamp("c.fecha");
                Date fecha = new java.util.Date(timestamp.getTime());

                
                //Usuario Comentario
                int idUsuario = resultado.getInt("u1.id");
                String nombreUsuario= resultado.getString("u1.nombre");     
                Usuario u1 = new Usuario(idUsuario, nombreUsuario);
                
                //Publicacion  
                int idPublicacion = resultado.getInt("p.id");
                String tituloPublicacion = resultado.getString("p.titulo");
                String descripcionPublicacion = resultado.getString("p.descripcion");
                java.sql.Timestamp timestamp2 = resultado.getTimestamp("fecha_publicacion");
                Date fechaPublicacion = new java.util.Date(timestamp2.getTime());
                String urlImagen = resultado.getString("p.imagen_URL");
                
                //Usuario Publicacion
                int idUsuarioPublicacion = resultado.getInt("u2.id");
                String nombreUsuarioPublicacion = resultado.getString("u2.nombre");
                Usuario u2 = new Usuario(idUsuarioPublicacion, nombreUsuarioPublicacion);          
                Publicacion p = new Publicacion(idPublicacion,tituloPublicacion, descripcionPublicacion, u2, fechaPublicacion, urlImagen);

                Comentario c = new Comentario(idComentario,p , u1, texto, fecha);
                comentarios.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
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

        return comentarios;
    }
    
    /*
    Método el cual permite obtener los comentarios de una publicación mediante su id, lo que permite mayor facilidad al momento
    de realizar la búsqueda, ya que no se necesita cargar el objeto completo
    */
    @Override
    public List<Comentario> consultarPublicacionId(int id) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Comentario> comentarios = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                //Comentario
                int idComentario = resultado.getInt("c.id");
                String texto = resultado.getString("c.texto_comentario");
                java.sql.Timestamp timestamp = resultado.getTimestamp("c.fecha");
                Date fecha = new java.util.Date(timestamp.getTime());
                
                //Usuario Comentario
                int idUsuario = resultado.getInt("u1.id");
                String nombreUsuario= resultado.getString("u1.nombre");     
                Usuario u1 = new Usuario(idUsuario, nombreUsuario);
                
                //Publicacion  
                int idPublicacion = resultado.getInt("p.id");
                String tituloPublicacion = resultado.getString("p.titulo");
                String descripcionPublicacion = resultado.getString("p.descripcion");
                java.sql.Timestamp timestamp2 = resultado.getTimestamp("fecha_publicacion");
                Date fechaPublicacion = new java.util.Date(timestamp2.getTime());
                String urlImagen = resultado.getString("p.imagen_URL");
                
                //Usuario Publicacion
                int idUsuarioPublicacion = resultado.getInt("u2.id");
                String nombreUsuarioPublicacion = resultado.getString("u2.nombre");
                Usuario u2 = new Usuario(idUsuarioPublicacion, nombreUsuarioPublicacion);          
                Publicacion p = new Publicacion(idPublicacion,tituloPublicacion, descripcionPublicacion, u2, fechaPublicacion, urlImagen);

                Comentario c = new Comentario(idComentario,p , u1, texto, fecha);
                comentarios.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
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

        return comentarios;
    }
    
    @Override
    public Comentario consultarId(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Comentario c = null;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, comentario.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int idComentario = resultado.getInt("c.id");
                String texto = resultado.getString("c.texto_comentario");
                java.sql.Timestamp timestamp = resultado.getTimestamp("c.fecha");
                Date fecha = new java.util.Date(timestamp.getTime());
                
                //Usuario Comentario
                int idUsuario = resultado.getInt("u1.id");
                String nombreUsuario= resultado.getString("u1.nombre");     
                Usuario u1 = new Usuario(idUsuario, nombreUsuario);
                
                //Publicacion  
                int idPublicacion = resultado.getInt("p.id");
                String tituloPublicacion = resultado.getString("p.titulo");
                String descripcionPublicacion = resultado.getString("p.descripcion");
                java.sql.Timestamp timestamp2 = resultado.getTimestamp("fecha_publicacion");
                Date fechaPublicacion = new java.util.Date(timestamp2.getTime());
                String urlImagen = resultado.getString("p.imagen_URL");
                
                //Usuario Publicacion
                int idUsuarioPublicacion = resultado.getInt("u2.id");
                String nombreUsuarioPublicacion = resultado.getString("u2.nombre");
                Usuario u2 = new Usuario(idUsuarioPublicacion, nombreUsuarioPublicacion);          
                Publicacion p = new Publicacion(idPublicacion,tituloPublicacion, descripcionPublicacion, u2, fechaPublicacion, urlImagen);

                c = new Comentario(idComentario,p , u1, texto, fecha);

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return c;
    }

    @Override
    public int borrar(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, comentario.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(3, comentario.getId());
            sentencia.setString(1, comentario.getTexto());
            sentencia.setDate(2, new java.sql.Date(comentario.getFecha().getTime()));
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    public List<Comentario> consultarIdUsuario(int idUsuarioEntrada) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Comentario> comentarios = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            //sentencia = connection.prepareStatement(SQL_CONSULTAR);
            //sentencia.setInt(1, publicacion.getId());
            //resultado = sentencia.executeQuery();
            sentencia = connection.prepareStatement(SQL_CONSULTARIDUSUARIO, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, idUsuarioEntrada);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                //Comentario
                int idComentario = resultado.getInt("c.id");
                String texto = resultado.getString("c.texto_comentario");
                java.sql.Timestamp timestamp = resultado.getTimestamp("c.fecha");
                Date fecha = new java.util.Date(timestamp.getTime());

                
                //Usuario Comentario
                int idUsuario = resultado.getInt("u1.id");
                String nombreUsuario= resultado.getString("u1.nombre");     
                Usuario u1 = new Usuario(idUsuario, nombreUsuario);
                
                //Publicacion  
                int idPublicacion = resultado.getInt("p.id");
                String tituloPublicacion = resultado.getString("p.titulo");
                String descripcionPublicacion = resultado.getString("p.descripcion");
                java.sql.Timestamp timestamp2 = resultado.getTimestamp("fecha_publicacion");
                Date fechaPublicacion = new java.util.Date(timestamp2.getTime());
                String urlImagen = resultado.getString("p.imagen_URL");
                
                //Usuario Publicacion
                int idUsuarioPublicacion = resultado.getInt("u2.id");
                String nombreUsuarioPublicacion = resultado.getString("u2.nombre");
                Usuario u2 = new Usuario(idUsuarioPublicacion, nombreUsuarioPublicacion);          
                Publicacion p = new Publicacion(idPublicacion,tituloPublicacion, descripcionPublicacion, u2, fechaPublicacion, urlImagen);

                Comentario c = new Comentario(idComentario,p , u1, texto, fecha);
                comentarios.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
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

        return comentarios;
    }

}
