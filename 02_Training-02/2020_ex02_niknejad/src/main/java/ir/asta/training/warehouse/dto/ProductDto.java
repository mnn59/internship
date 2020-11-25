package ir.asta.training.warehouse.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {
    private String title;
    private Long serial;
}
