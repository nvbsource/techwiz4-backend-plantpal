package vn.plantpal.mobile_backend.dtos.accesoryType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessoryTypeCreateUpdateDto {
    private String name;
    private String description;
    private String fatherTypeId;
}
