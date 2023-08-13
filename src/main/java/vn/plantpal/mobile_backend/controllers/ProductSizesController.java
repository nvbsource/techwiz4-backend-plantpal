package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.services.product_sizes.ProductSizeService;

import java.util.List;

@RestController
@RequestMapping("api/productSizes")
@RequiredArgsConstructor
public class ProductSizesController {
    private final ProductSizeService productSizesService;

    @GetMapping
    public ResponseEntity<List<ProductSizeInfoDTO>> getAllSizes() {
        return ResponseEntity.ok(productSizesService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductSizeInfoDTO> createSize(@RequestBody ProductSizeCreateUpdateDTO productSizeCreateDTO) {
        return ResponseEntity.ok(productSizesService.create(productSizeCreateDTO));
    }


    @DeleteMapping("/{id}")
    public void deleteSize(@PathVariable String id) {
        productSizesService.delete(id);
    }
}
