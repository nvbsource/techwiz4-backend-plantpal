package vn.plantpal.mobile_backend.services.Billing;

import vn.plantpal.mobile_backend.dtos.billing.BillingBaseDTO;
import vn.plantpal.mobile_backend.dtos.billing.BillingDetailDTO;
import vn.plantpal.mobile_backend.dtos.checkout.CheckoutDTO;

import java.util.List;

public interface BillingService {
    BillingDetailDTO checkout(CheckoutDTO data, String userId);
    void callbackPaypal(String orderId, String userId);
    List<BillingDetailDTO> findBillByUser(String userId);
}
