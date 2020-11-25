package ir.asta.training.greeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Component
@Path("/greeting")
public class GreetingService {
    @Autowired
    private SpokesmanImpl spokesman;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String sayHello(@QueryParam("user") String user, @QueryParam("honorific") String honorific) {
        return spokesman.greet(user, honorific);
    }

}
