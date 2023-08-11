package vn.plantpal.mobile_backend.dtos.lights;

import lombok.Data;

@Data
public class LightRequiresDto {
    private String id;
    private String strength;
    private Integer orders;

}
