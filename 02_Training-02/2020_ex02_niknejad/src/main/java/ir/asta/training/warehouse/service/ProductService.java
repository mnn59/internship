package ir.asta.training.warehouse.service;

import ir.asta.training.warehouse.dto.ProductDto;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/product")
public interface ProductService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    Response save(ProductDto productDto);
}
