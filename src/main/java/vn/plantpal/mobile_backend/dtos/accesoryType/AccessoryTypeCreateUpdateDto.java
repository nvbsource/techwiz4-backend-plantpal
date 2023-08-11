package vn.plantpal.mobile_backend.dtos.accesoryType;

import lombok.Data;

@Data
public class AccessoryTypeCreateUpdateDto {
    private String name;
    private String description;
    private String fatherTypeId;
}
