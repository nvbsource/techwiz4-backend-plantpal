package vn.plantpal.mobile_backend.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessoryBaseDTO {
    private String id;
    private String name;
    private String instruction;
    private String description;
    private Double price;
}
