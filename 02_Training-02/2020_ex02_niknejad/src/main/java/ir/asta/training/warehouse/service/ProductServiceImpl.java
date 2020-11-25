package ir.asta.training.warehouse.service;

import ir.asta.training.warehouse.dto.ProductDto;
import ir.asta.training.warehouse.manager.product.ProductManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductManager productManager;

    @Override
    public Response save(ProductDto productDto) {
        productManager.save(productDto);
        return Response.noContent().build();
    }
}
