package ir.asta.training.warehouse.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @Column(nullable = false, unique = true)
    private Long serial;
    @NotNull

    private BigDecimal price;
    @ManyToMany
    private Set<CategoryEntity> categories;
    {
        categories = new HashSet<>();
    }

}
