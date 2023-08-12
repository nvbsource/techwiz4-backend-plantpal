package vn.plantpal.mobile_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDTO {
    private String id;
    private String image;
    private boolean isThumbnail;
}
