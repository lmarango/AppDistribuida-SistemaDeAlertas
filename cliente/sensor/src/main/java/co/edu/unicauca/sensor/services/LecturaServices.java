package co.edu.unicauca.sensor.services;

import co.edu.unicauca.sensor.models.LecturaDTO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author User
 */
public class LecturaServices {
    private String endPoint;
    private Client cliente;
    
    public LecturaServices(){
        this.endPoint = "http://localhost:8085/api/lecturas";
        this.cliente = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
     public LecturaDTO registrarLectura(LecturaDTO objLecturaRegistrar){
        LecturaDTO objLectura = null;
        WebTarget target = this.cliente.target(this.endPoint);
        Entity<LecturaDTO> data = Entity.entity(objLecturaRegistrar, MediaType.APPLICATION_JSON_TYPE);
        objLectura = target.request(MediaType.APPLICATION_JSON_TYPE).post(data, LecturaDTO.class);
        return objLectura;
    }
}
