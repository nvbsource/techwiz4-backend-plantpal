package vn.plantpal.mobile_backend.dtos.favorite;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FavoriteCreateDTO {
    private String userId;
    private String productId;
}
