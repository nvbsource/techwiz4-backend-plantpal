package vn.plantpal.mobile_backend.dtos.favorite;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FavoriteResponseDTO {
    private String id;
    private String userId;
    private String productId;
}
