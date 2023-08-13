package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.services.stock.StockService;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getAll() {
        return ResponseEntity.ok(stockService.getAll());
    }

    @PostMapping
    public ResponseEntity<StockResponseDTO> create(@RequestBody StockCreateDTO stockCreateDTO) {
        return ResponseEntity.ok(stockService.create(stockCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockResponseDTO> update(@PathVariable String id, @RequestBody StockCreateDTO sizeCreateDTO) {
        return ResponseEntity.ok(stockService.update(id, sizeCreateDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteSize(@PathVariable String id) {
        stockService.delete(id);
    }
}
