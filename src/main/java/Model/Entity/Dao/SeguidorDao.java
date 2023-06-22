/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity.Dao;

import Model.Entity.Seguidor;
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
 * @author BRYAN VERA
 */
public class SeguidorDao implements ISeguidor{
    
    final static String SQL_CONSULTAR_SEGUIDORES = "SELECT u1.id, u1.nombre, u2.id, u2.nombre, s.id, s.fecha_seguimiento "
            + "FROM usuario u1, usuario u2, seguidor s "
            + "WHERE u1.id = s.id_usuario_seguidor AND u2.id = s.id_usuario_seguido AND s.id_usuario_seguido = ?";
    final static String SQL_CONSULTAR_SEGUIDOS = "SELECT u1.id, u1.nombre, u2.id, u2.nombre, s.id, s.fecha_seguimiento "
            + "FROM usuario u1, usuario u2, seguidor s "
            + "WHERE u1.id = s.id_usuario_seguidor AND u2.id = s.id_usuario_seguido AND s.id_usuario_seguidor = ?";
    final static String SQL_CONSULTAR_EXISTENCIA_RELACION = "SELECT COUNT(*) FROM seguidor WHERE id_usuario_seguidor = ? AND id_usuario_seguido = ?";
    final static String SQL_INSERTAR = "INSERT INTO seguidor(id, id_usuario_seguidor, id_usuario_seguido, fecha_seguimiento) VAlUES(?,?,?,?)";
    final static String SQL_BORRAR = "DELETE FROM seguidor WHERE id = ?";

    @Override
    public int insertar(Seguidor seguidor) {
        int resultado = 0;
        System.out.println("ExisteRelacion: " + existeRelacion(seguidor));
        if (existeRelacion(seguidor)) {
            return resultado;
        }
        Connection connection = null;
        PreparedStatement sentencia = null;
            try {
                connection = BaseDatos.getConnection();
                sentencia = connection.prepareStatement(SQL_INSERTAR);        
                sentencia.setInt(1, seguidor.getId());
                sentencia.setInt(2, seguidor.getSeguidor().getId());
                sentencia.setInt(3, seguidor.getSeguido().getId());
                sentencia.setDate(4, new java.sql.Date(seguidor.getFechaSeguimiento().getTime()));

                resultado = sentencia.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    BaseDatos.close(sentencia);
                    BaseDatos.close(connection);
                } catch (SQLException ex) {
                    Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        return resultado;
    }
    
    private boolean existeRelacion(Seguidor seguidor){
    Connection connection = null;
    PreparedStatement sentencia = null;
    ResultSet resultado = null;
    try {
        connection = BaseDatos.getConnection();
        sentencia = connection.prepareStatement(SQL_CONSULTAR_EXISTENCIA_RELACION, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
        sentencia.setInt(1, seguidor.getSeguidor().getId());
        sentencia.setInt(2, seguidor.getSeguido().getId());
        resultado = sentencia.executeQuery();
        if (resultado.next()) {
            int count = resultado.getInt(1);
            System.out.println("Count: " + count);
            return count == 1; // Si count es mayor a 0, la relación ya existe
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    

       

    @Override
    public List<Seguidor> consultarSeguidores(int usuarioSeguido) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Seguidor> seguidores = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            //sentencia = connection.prepareStatement(SQL_CONSULTAR);
            //sentencia.setInt(1, idUsuarioSeguido);
            //resultado = sentencia.executeQuery();
            sentencia = connection.prepareStatement(SQL_CONSULTAR_SEGUIDORES, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, usuarioSeguido);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                //Seguidor
                int idSeguidor = resultado.getInt("s.id");
                java.sql.Timestamp timestamp = resultado.getTimestamp("s.fecha_seguimiento");
                java.util.Date fecha = new java.util.Date(timestamp.getTime());
                
                //Usuario Seguidor
                int idUsuarioSeguidor = resultado.getInt("u1.id");
                String nombreUsuarioSeguidor= resultado.getString("u1.nombre");     
                Usuario u1 = new Usuario(idUsuarioSeguidor, nombreUsuarioSeguidor);
                
                //Usuario Seguido 
                int idUsuarioSeguido = resultado.getInt("u2.id");
                String nombreUsuarioSeguido = resultado.getString("u2.nombre");
                Usuario u2 = new Usuario(idUsuarioSeguido, nombreUsuarioSeguido);          
                

                Seguidor s = new Seguidor(idSeguidor, u1, u2, fecha);
                seguidores.add(s);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return seguidores;
    }
    
    public List<Seguidor> consultarSeguidos(int usuarioSeguido) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Seguidor> seguidores = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            //sentencia = connection.prepareStatement(SQL_CONSULTAR);
            //sentencia.setInt(1, idUsuarioSeguido);
            //resultado = sentencia.executeQuery();
            sentencia = connection.prepareStatement(SQL_CONSULTAR_SEGUIDOS, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, usuarioSeguido);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                //Seguidor
                int idSeguidor = resultado.getInt("s.id");
                java.sql.Timestamp timestamp = resultado.getTimestamp("s.fecha_seguimiento");
                java.util.Date fecha = new java.util.Date(timestamp.getTime());
                
                //Usuario Seguidor
                int idUsuarioSeguidor = resultado.getInt("u1.id");
                String nombreUsuarioSeguidor= resultado.getString("u1.nombre");     
                Usuario u1 = new Usuario(idUsuarioSeguidor, nombreUsuarioSeguidor);
                
                //Usuario Seguido 
                int idUsuarioSeguido = resultado.getInt("u2.id");
                String nombreUsuarioSeguido = resultado.getString("u2.nombre");
                Usuario u2 = new Usuario(idUsuarioSeguido, nombreUsuarioSeguido);          
                

                Seguidor s = new Seguidor(idSeguidor, u1, u2, fecha);
                seguidores.add(s);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeguidorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(PublicacionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return seguidores;
    }

    @Override
    public int borrar(Seguidor seguidor) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, seguidor.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SeguidorDao.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeguidorDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(SeguidorDao.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
        
    }
    
}
