package cz.aag.ndc.testcontainer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource {
    
    @GET
    @Operation(summary = "Loads available air offers from provider") 
    public String test() {
        return "{\"_id\" : \"1234567890\"}";
    }
}
