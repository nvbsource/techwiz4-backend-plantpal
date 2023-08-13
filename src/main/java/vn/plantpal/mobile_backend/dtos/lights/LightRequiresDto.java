package vn.plantpal.mobile_backend.dtos.lights;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LightRequiresDto {
    private String id;
    private String strength;
    private Integer orders;
}
