package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.services.stocks.StockService;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @GetMapping
    public ResponseEntity<Page<StockResponseDTO>> getAll(
            @RequestParam(required = false) ProductType productType,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double priceFrom,
            @RequestParam(required = false) Double priceTo,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {
        Pageable pageable = PageRequest.of(offset,limit);
        return ResponseEntity.ok(stockService.getAll(productType, keyword, priceFrom, priceTo, sortField, sortOrder, pageable));
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
