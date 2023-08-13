package vn.plantpal.mobile_backend.services.cart;

import vn.plantpal.mobile_backend.dtos.cart.SaveCardResponseDTO;
import vn.plantpal.mobile_backend.dtos.cart.SaveToCartDTO;
import vn.plantpal.mobile_backend.dtos.cart.CartBaseDTO;

import java.util.List;

public interface CartService {
    List<CartBaseDTO> findByUserId(String userId);
    SaveCardResponseDTO save(SaveToCartDTO data, String userId);
    void delete(String productSizeId, String userId);
}
