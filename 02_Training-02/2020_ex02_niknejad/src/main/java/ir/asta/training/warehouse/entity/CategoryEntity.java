package ir.asta.training.warehouse.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false , unique = true)
    private String code;
    @NotNull
    private String subject;
    @ManyToMany(mappedBy = "categories")
    private Set<ProductEntity> products;
    {
        products = new HashSet<>();
    }
}
