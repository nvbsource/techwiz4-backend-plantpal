package vn.plantpal.mobile_backend.dtos.product.accessories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessoriesTypeDTO {
    private String id;
    private String name;
    private String description;
}
