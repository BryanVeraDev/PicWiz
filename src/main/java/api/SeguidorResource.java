/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import Model.Entity.Dao.SeguidorDao;
import Model.Entity.Seguidor;
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
@Path("/apiseguidor")
public class SeguidorResource {
    

    SeguidorDao seguidorDao = new SeguidorDao();
    @GET
    @Path("/seguidor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar (){
        List<Seguidor> seguidores = new ArrayList<>();
        seguidores = seguidorDao.consultar();
        return Response
                .status(200)
                .entity(seguidores)
                .build();
        
    }     
      
    @POST
    @Path("/seguidor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Seguidor seguidor)
    {
        System.out.println("id:"+ seguidor.getId());
        try{
            seguidorDao.insertar(seguidor);
            return  Response
                .status(Response.Status.CREATED)
                .entity(seguidor)
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
    @Path("/seguidor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") int id) {
        
        Seguidor seguidor = new Seguidor(id);
        int i = seguidorDao.borrar(seguidor);
        
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No se encontró el seguidor")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
  
    
}
