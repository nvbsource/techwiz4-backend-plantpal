package vn.plantpal.mobile_backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.cart.CartBaseDTO;
import vn.plantpal.mobile_backend.dtos.cart.SaveCardResponseDTO;
import vn.plantpal.mobile_backend.dtos.cart.SaveToCartDTO;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.Cart.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/getCart")
    public ResponseEntity<List<CartBaseDTO>> getCarts(Authentication authentication) {
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        return ResponseEntity.ok(cartService.findByUserId(user.getUserID()));
    }
    @PostMapping("/save")
    public ResponseEntity<SaveCardResponseDTO> addProductToCart(@Valid @RequestBody SaveToCartDTO data, Authentication authentication) {
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        return ResponseEntity.ok(cartService.save(data, user.getUserID()));
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> addProductToCart(@PathVariable String productId, Authentication authentication) {
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        cartService.delete(productId, user.getUserID());
        return ResponseEntity.ok("Deleted successfully");
    }
}
