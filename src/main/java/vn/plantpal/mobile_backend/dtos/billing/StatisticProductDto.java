package vn.plantpal.mobile_backend.dtos.billing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticProductDto {
    String name;
    int[] data;
}
