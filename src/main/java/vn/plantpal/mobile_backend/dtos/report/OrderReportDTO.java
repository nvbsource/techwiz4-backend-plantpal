package vn.plantpal.mobile_backend.dtos.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderReportDTO {
    private List<Long> plants;
    private List<Long> accessories;
}
