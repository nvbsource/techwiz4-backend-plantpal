package vn.plantpal.mobile_backend.services.billing;

import vn.plantpal.mobile_backend.dtos.billing.BillingDetailDTO;
import vn.plantpal.mobile_backend.dtos.billing.StatisticBillingDto;
import vn.plantpal.mobile_backend.dtos.billing.SummaryStatisticBillingDto;
import vn.plantpal.mobile_backend.dtos.checkout.CheckoutDTO;

import java.util.List;

public interface BillingService {
    BillingDetailDTO checkout(CheckoutDTO data, String userId);
    void callbackPaypal(String orderId, String userId);
    List<BillingDetailDTO> findBillByUser(String userId);

    StatisticBillingDto billingStatistics();
}
