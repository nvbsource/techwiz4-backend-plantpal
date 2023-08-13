package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.product_size.ProductSizeCreateDTO;
import vn.plantpal.mobile_backend.dtos.product_size.ProductSizeResponseDTO;
import vn.plantpal.mobile_backend.services.product_sizes.ProductSizesService;

import java.util.List;

@RestController
@RequestMapping("api/productSizes")
@RequiredArgsConstructor
public class ProductSizesController {
    private final ProductSizesService productSizesService;

    @GetMapping
    public ResponseEntity<List<ProductSizeResponseDTO>> getAllSizes() {
        return ResponseEntity.ok(productSizesService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductSizeResponseDTO> createSize(@RequestBody ProductSizeCreateDTO productSizeCreateDTO) {
        return ResponseEntity.ok(productSizesService.create(productSizeCreateDTO));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ProductSizeResponseDTO> updateSize(@PathVariable String id, @RequestBody ProductSizeCreateDTO productSizeCreateDTO) {
//        return ResponseEntity.ok(productSizesService.update(id, productSizeCreateDTO));
//    }

    @DeleteMapping("/{id}")
    public void deleteSize(@PathVariable String id) {
        productSizesService.delete(id);
    }
}
