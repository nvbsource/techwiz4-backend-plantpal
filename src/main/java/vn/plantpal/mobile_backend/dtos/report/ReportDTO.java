package vn.plantpal.mobile_backend.dtos.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDTO {
    private OrderReportDTO orders;
    private Long totalAccount;
    private Long totalProduct;
    private Long totalStock;
}
