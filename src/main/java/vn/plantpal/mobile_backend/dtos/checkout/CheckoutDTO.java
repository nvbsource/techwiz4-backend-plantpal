package vn.plantpal.mobile_backend.dtos.checkout;

import jakarta.persistence.Entity;
import lombok.*;
import vn.plantpal.mobile_backend.dtos.product.ProductInCartDTO;
import vn.plantpal.mobile_backend.utils.PaymentMethodType;
import vn.plantpal.mobile_backend.validators.ValidEnum;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckoutDTO {
    @ValidEnum(targetClassType = PaymentMethodType.class, message = "Invalid payment method (PAYPAL, CASH)")
    private String paymentMethod;
    private List<ProductInCartDTO> productList;
    private String fullName;
    private String address;
    private String phoneNumber;
}
