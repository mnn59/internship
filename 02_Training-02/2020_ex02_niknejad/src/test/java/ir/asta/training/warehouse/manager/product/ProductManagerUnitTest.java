package ir.asta.training.warehouse.manager.product;

import ir.asta.training.warehouse.dto.ProductDto;
import ir.asta.training.warehouse.manager.product.helper.exception.InvalidProductSerialRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductManagerUnitTest {
    ProductManager productManager = new ProductManager();

    @Test
    public void testValidProductSerialHappyPath() {
        ProductDto productDto = ProductDto.builder()
                .title("Book")
                .serial(98123456L)
                .build();
        productManager.validate(productDto);
    }

    @Test
    public void testInValidProductSerialThrowsException() {
        ProductDto productDto = ProductDto.builder()
                .title("Book")
                .serial(9812345L)
                .build();
        Assertions.assertThrows(InvalidProductSerialRangeException.class, () -> productManager.validate(productDto));
    }


}
