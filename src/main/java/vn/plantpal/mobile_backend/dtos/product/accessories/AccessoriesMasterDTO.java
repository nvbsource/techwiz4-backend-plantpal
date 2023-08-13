package vn.plantpal.mobile_backend.dtos.product.accessories;

import lombok.Data;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;

import java.util.List;

@Data
public class AccessoriesMasterDTO {
    private String id;
    private String name;
    private String description;
    private String instruction;
    private AccessoriesTypeDTO type;
    private List<ProductImageDTO> images;
    private List<ProductSizeDetailDTO> sizes;

    public AccessoriesMasterDTO(String id, String name, String description, String instruction) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instruction = instruction;
    }
}
