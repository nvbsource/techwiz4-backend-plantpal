package vn.plantpal.mobile_backend.dtos.checkout;

import lombok.*;

@Getter
@Setter
@Builder
public class CheckoutResponseDTO {
    private String id;
    private String status;
}
