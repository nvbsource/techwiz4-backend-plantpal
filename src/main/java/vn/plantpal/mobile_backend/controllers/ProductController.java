package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.product.ProductCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.services.plant.PlantService;
import vn.plantpal.mobile_backend.services.product.ProductService;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/search")
    public ResponseEntity<Page<ProductSearchDTO>> searchProductByKeyword(@RequestParam String keyword, @RequestParam Integer offset, @RequestParam Integer limit){
       return ResponseEntity.ok(productService.findAllByNameContainingOrDescriptionContaining(keyword,offset,limit));
    }

    @GetMapping("/search/all")
    public ResponseEntity<Page<ProductSearchDTO>> findAllProduct(@RequestParam Integer offset, @RequestParam Integer limit){
        return ResponseEntity.ok(productService.findAllProduct(offset,limit));
    }
    @PostMapping("/plants")
    public ResponseEntity<List<PlantCreatUpdateDTO>> createPlant(@RequestBody List<PlantCreatUpdateDTO> plantCreatDTOList){
        return ResponseEntity.ok(productService.createPlant(plantCreatDTOList));
    }

    @PostMapping("/accessories")
    public ResponseEntity<List<AccessoriesCreateUpdateDTO>> createAccessories(@RequestBody List<AccessoriesCreateUpdateDTO> accessoriesCreateDTOList){
        return ResponseEntity.ok(productService.createAccessories(accessoriesCreateDTOList));
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductCreateUpdateDTO> update(@PathVariable String productId,ProductCreateUpdateDTO productCreateUpdateDTO){
        return null;
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> delete(@PathVariable String productId){
        return null;
    }

    @DeleteMapping
    public String delete(@RequestBody List<String> productIdList){
        return null;
    }
}
