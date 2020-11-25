package ir.asta.training.warehouse.dao;

import ir.asta.training.warehouse.entity.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Slf4j
public class ProductDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(ProductEntity productEntity) {
        log.info("going to save ProductEntity to db :{}", productEntity);
        entityManager.persist(productEntity);
        log.info("product entity is saved to database. Id is : {}", productEntity.getId());
    }
}
