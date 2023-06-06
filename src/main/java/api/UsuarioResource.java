/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import Model.Entity.Dao.UsuarioDao;
import Model.Entity.Usuario;
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
@Path("/apiusuario")
public class UsuarioResource {
    

    UsuarioDao usuarioDao = new UsuarioDao();
    @GET
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar (){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioDao.consultar();   
        return Response
                .status(200)
                .entity(usuarios)
                .build();
        
    }     
    @GET
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Usuario usuario = new Usuario(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(usuarioDao.consultarId(usuario))
                .build();
    }    
    @POST
    @Path("/usuario/registrar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Usuario usuario)
    {
        try{
            usuarioDao.insertar(usuario);
            return  Response
                .status(Response.Status.CREATED)
                .entity(usuario)
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
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") int id) {
        Usuario usuario = new Usuario(id);
        int i = usuarioDao.borrar(usuario);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No se encontró al usuario")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    
    @Path("/usuario")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Usuario usuario) {
       try{
            usuarioDao.actualizar(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
    
    @POST
    @Path("/usuario/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Usuario usuario) {

        // Aquí puedes llamar al método login de UsuarioDao para verificar las credenciales del usuario
        Usuario aux = usuarioDao.login(usuario);

        if (aux != null) {
            // Si el inicio de sesión es exitoso, puedes generar el token JWT y devolverlo en la respuesta
            //String token = generarTokenJWT(usuario);
            try {
                return  Response
                .status(Response.Status.FOUND)
                .entity(aux)
                .build();
         
            } catch (Exception e) {
                 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
                    } else {
            // Si el inicio de sesión falla, puedes devolver una respuesta de error
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
}
