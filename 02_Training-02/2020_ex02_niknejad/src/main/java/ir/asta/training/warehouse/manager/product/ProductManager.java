package ir.asta.training.warehouse.manager.product;

import ir.asta.training.warehouse.dao.ProductDao;
import ir.asta.training.warehouse.dto.ProductDto;
import ir.asta.training.warehouse.entity.ProductEntity;
import ir.asta.training.warehouse.manager.product.helper.exception.InvalidProductSerialRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ProductManager {
    @Autowired
    private ProductDao productDao;

    @Transactional
    public void save(ProductDto productDto) {
        validate(productDto);
        ProductEntity productEntity = convertDtoToEntity(productDto);
        productDao.save(productEntity);
    }

    void validate(ProductDto productDto) {
        boolean serialIsValid = 98000000L <= productDto.getSerial() && productDto.getSerial() < 99000000L;
        if (!serialIsValid) {
            throw new InvalidProductSerialRangeException();
        }
    }

    private ProductEntity convertDtoToEntity(ProductDto productDto) {
        return ProductEntity.builder()
                .title(productDto.getTitle())
                .serial(productDto.getSerial())
                .build();
    }
}
