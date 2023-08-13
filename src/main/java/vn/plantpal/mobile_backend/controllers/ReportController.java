package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.plantpal.mobile_backend.dtos.report.ReportDTO;
import vn.plantpal.mobile_backend.services.report.ReportService;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<ReportDTO> getReport(){
        return ResponseEntity.ok(reportService.getReport());
    }
}
