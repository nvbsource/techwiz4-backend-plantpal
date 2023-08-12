package vn.plantpal.mobile_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.billing.BillingDetailDTO;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.Billing.BillingService;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
    @Autowired
    private BillingService billingService;
    @GetMapping("/getBillingOfUser")
    public ResponseEntity<List<BillingDetailDTO>> getBillingOfUser(Authentication authentication) {
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        return ResponseEntity.ok(billingService.findBillByUser(user.getUserID()));
    }
}
