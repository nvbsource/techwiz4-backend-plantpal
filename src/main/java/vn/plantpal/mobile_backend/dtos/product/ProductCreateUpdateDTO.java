package vn.plantpal.mobile_backend.dtos.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductSizeDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductImageDTO;
import vn.plantpal.mobile_backend.entities.Accessories;
import vn.plantpal.mobile_backend.entities.Plants;
import vn.plantpal.mobile_backend.entities.ProductImages;
import vn.plantpal.mobile_backend.entities.ProductSizes;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateUpdateDTO extends ProductBaseDTO {
    private String productType;
    private String name;
    private String description;
    private Collection <ProductSizeDTO> productSizes;
    private Collection<String> productImages;
}
