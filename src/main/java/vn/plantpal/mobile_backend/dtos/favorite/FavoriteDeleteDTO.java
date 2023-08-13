package vn.plantpal.mobile_backend.dtos.favorite;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FavoriteDeleteDTO {
    private String id;
    private String userId;
    private String productId;
}
