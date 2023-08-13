package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.plantpal.mobile_backend.dtos.report.ReportDTO;
import vn.plantpal.mobile_backend.services.report.ReportService;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<ReportDTO> getReport(@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate){
       if(startDate == null && endDate == null){
           Calendar calendar = Calendar.getInstance();
           calendar.add(Calendar.DAY_OF_MONTH, -7); // Subtract 7 days
            endDate = new Date(); // Current date
            startDate = calendar.getTime(); // Calculated star
       }
        return ResponseEntity.ok(reportService.getReport(startDate,endDate));
    }
}
