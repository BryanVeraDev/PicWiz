/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;


import Model.Entity.Dao.PublicacionDao;
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
 * @author DANIELA
 */
@Path("/apipublicacion")
public class PublicacionResource {
     PublicacionDao publicacionDao = new PublicacionDao();
    @GET
    @Path("/publicacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar (){
        List<Publicacion> publicaciones = new ArrayList<>();
        publicaciones = publicacionDao.consultar();   
        return Response
                .status(200)
                .entity(publicaciones)
                .build();
        
    }     
    @GET
    @Path("/publicacion/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Publicacion publicacion = new Publicacion(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(publicacionDao.consultarId(publicacion))
                .build();
    }    
    @POST
    @Path("/publicacion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Publicacion publicacion)
    {
        System.out.println("titulo:"+ publicacion.getTitulo());
        try{
            publicacionDao.insertar(publicacion);
            return  Response
                .status(Response.Status.CREATED)
                .entity(publicacion)
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
    @Path("/publicacion/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") int id) {
        Publicacion publicacion = new Publicacion(id);
        int i = publicacionDao.borrar(publicacion);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No se encontró la publicacion")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    
    @Path("/publicacion")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Publicacion publicacion) {
       try{
            publicacionDao.actualizar(publicacion);
            return Response.status(Response.Status.CREATED).entity(publicacion).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
