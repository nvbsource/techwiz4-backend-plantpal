package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductBaseDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer width;
    private Integer height;
    private String size;
    private String stock;
}
