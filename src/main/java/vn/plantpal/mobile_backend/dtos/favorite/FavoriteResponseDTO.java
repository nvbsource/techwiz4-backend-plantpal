package vn.plantpal.mobile_backend.dtos.favorite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteResponseDTO {
    private String id;
    private String userId;
    private String productId;
    private LocalDateTime createdAt;

}
