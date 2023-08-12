package vn.plantpal.mobile_backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.billing.BillingDetailDTO;
import vn.plantpal.mobile_backend.dtos.checkout.CheckoutDTO;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.Billing.BillingService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private BillingService billingService;
    @PostMapping
    public ResponseEntity<BillingDetailDTO> checkout(@Valid @RequestBody CheckoutDTO data, Authentication authentication){
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        return ResponseEntity.ok(billingService.checkout(data, user.getUserID()));
    }
}
