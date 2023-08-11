package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.services.product.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<ProductSearchDTO>> searchProductByKeyword(@RequestParam String keyword, @RequestParam Integer offset, @RequestParam Integer limit){
        return ResponseEntity.ok(productService.findAllByNameContainingOrDescriptionContaining(keyword,offset,limit));
    }
}
