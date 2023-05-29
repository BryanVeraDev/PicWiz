/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author DANIELA
 */

@ApplicationPath("/apiPicWiz")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        //classes.add(CorsFilter.class);
        classes.add(UsuarioResource.class);
        classes.add(PublicacionResource.class);
                
        // Agrega aquí tus clases de recursos (endpoints son las que dicen Resource) adicionales
        return classes;
    }
    
}
