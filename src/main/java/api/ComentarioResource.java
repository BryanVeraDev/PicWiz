/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;


import Model.Entity.Dao.ComentarioDao;
import Model.Entity.Comentario;
import Model.Entity.Publicacion;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lionel Andrés
 */
@Path("/apicomentario")
public class ComentarioResource {
    
     ComentarioDao comentarioDao = new ComentarioDao();
    
    /*
     Método consultar en el cual se necesita SOLO el id de la publicación
     */
    @GET
    @Path("/comentario/idpublicacion/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar (@PathParam("id") int id){
        List<Comentario> comentarios = new ArrayList<>();
        comentarios = comentarioDao.consultarPublicacionId(id);
        return Response
                .status(200)
                .entity(comentarios)
                .build();
        
    }
    
    /*
     Método consultar en el cual se necesita SOLO el id de la publicación
     */
    @GET
    @Path("/comentario/idusuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarIdUsuario (@PathParam("id") int id){
        List<Comentario> comentarios = new ArrayList<>();
        comentarios = comentarioDao.consultarIdUsuario(id);
        return Response
                .status(200)
                .entity(comentarios)
                .build();
        
    }
    
    /*
     Método consultar en el cual se necesita todo el objeto publicación
    */
    @GET
    @Path("/comentario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar (Publicacion publicacion){
        List<Comentario> comentarios = new ArrayList<>();
        comentarios = comentarioDao.consultar(publicacion);
        return Response
                .status(200)
                .entity(comentarios)
                .build();
        
    }
     
    @GET
    @Path("/comentario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Comentario comentario = new Comentario (id);
        return Response
                .status(200)
                .entity(comentarioDao.consultarId(comentario))
                .build();
    }    
    @POST
    @Path("/comentario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Comentario comentario)
    {
        try{
            comentarioDao.insertar(comentario);
            return  Response
                .status(Response.Status.CREATED)
                .entity(comentario)
                .build();
                   
        }
        catch(Exception ex)
        {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        } 
    }    
    @DELETE
    @Path("/comentario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") int id) {
        Comentario comentario = new Comentario(id);
        int i = comentarioDao.borrar(comentario);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No se encontró la publicacion")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    
    @Path("/comentario")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Comentario comentario) {
       try{
            comentarioDao.actualizar(comentario);
            return Response.status(Response.Status.CREATED).entity(comentario).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
