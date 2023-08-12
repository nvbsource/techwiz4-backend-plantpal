package vn.plantpal.mobile_backend.dtos.product.accessories;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.plantpal.mobile_backend.dtos.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.ProductSize.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;

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
}
