package vn.plantpal.mobile_backend.dtos.product.accessories;

import lombok.Data;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;

import java.util.List;

@Data
public class AccessoriesInfoDTO {
    private String id;
    private String name;
    private String description;
    private String instruction;
    private AccessoryTypeInfoDto type;
    private List<ProductImageDTO> images;
    private List<ProductSizeInfoDTO> sizes;

    public AccessoriesInfoDTO(String id, String name, String description, String instruction) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instruction = instruction;
    }
}
