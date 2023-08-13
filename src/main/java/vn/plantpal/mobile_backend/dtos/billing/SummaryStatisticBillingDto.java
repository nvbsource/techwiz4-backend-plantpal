package vn.plantpal.mobile_backend.dtos.billing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SummaryStatisticBillingDto {
    int[] statistics;
    String[] labels;
}
