package vn.plantpal.mobile_backend.dtos.checkout;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckoutResponseDTO {
    private String id;
    private String status;
}
