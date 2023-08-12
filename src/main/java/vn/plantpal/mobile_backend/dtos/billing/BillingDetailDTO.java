package vn.plantpal.mobile_backend.dtos.billing;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Collection;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillingDetailDTO extends BillingBaseDTO {
    private Collection<OrderItemBaseDTO> orderItems;
}
