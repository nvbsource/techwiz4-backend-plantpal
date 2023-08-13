package vn.plantpal.mobile_backend.services.report;

import vn.plantpal.mobile_backend.dtos.report.ReportDTO;

import java.time.LocalDateTime;
import java.util.Date;

public interface ReportService {
    ReportDTO getReport(Date startDate, Date endDate);
}
