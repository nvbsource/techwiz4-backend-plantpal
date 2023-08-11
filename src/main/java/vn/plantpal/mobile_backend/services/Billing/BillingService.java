package vn.plantpal.mobile_backend.services.Billing;

import vn.plantpal.mobile_backend.dtos.billing.BillingDetailDTO;
import vn.plantpal.mobile_backend.dtos.checkout.CheckoutDTO;

public interface BillingService {
    BillingDetailDTO checkout(CheckoutDTO data, String userId);
}
