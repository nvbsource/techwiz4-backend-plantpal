package vn.plantpal.mobile_backend.dtos.billing;

import jakarta.persistence.*;
import lombok.*;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInfoCartDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInfoDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemBaseDTO {
    private String id;
    private ProductInfoCartDTO product;
    private int quantity;
    private Double rate;
    private Double amount;
}
