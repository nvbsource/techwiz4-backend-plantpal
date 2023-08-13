package vn.plantpal.mobile_backend.dtos.report;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportDTO {
    private OrderReportDTO orders;
    private Long totalAccount;
    private Long totalProduct;
    private Long totalStock;
}
