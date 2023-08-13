package vn.plantpal.mobile_backend.dtos.billing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticBillingDto {
    private SummaryStatisticBillingDto summary;
    private List<StatisticProductDto> products;
    private long totalAccount;
    private long totalProduct;
    private long totalStock;
}
