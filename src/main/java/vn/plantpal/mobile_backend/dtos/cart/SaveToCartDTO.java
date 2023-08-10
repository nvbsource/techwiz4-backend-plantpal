package vn.plantpal.mobile_backend.dtos.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveToCartDTO {
    @NotBlank
    private String productId;
    @Min(value = 0, message = "Number quantity of invalid")
    private int quantity;
}
