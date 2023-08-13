package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.product.ProductCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesMasterDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantMasterInfoDTO;
import vn.plantpal.mobile_backend.services.product.ProductService;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPlantDetail(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductDetail(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductSearchDTO>> searchAndFilterProducts(
            @RequestParam(required = false) ProductType productType,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double priceFrom,
            @RequestParam(required = false) Double priceTo,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "10") int limit ,
            Authentication authentication
    ) {
        Pageable pageable = PageRequest.of(offset,limit);
        return ResponseEntity.ok(productService.getAllProductWithSearchAndFilter(productType, keyword, priceFrom, priceTo, sortField, sortOrder, authentication, pageable));
    }


    @GetMapping("/search/plants")
    public ResponseEntity<Page<ProductSearchDTO>> findAllPlants(
            @RequestParam(required = false) String species,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double priceFrom,
            @RequestParam(required = false) Double priceTo,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "10") int limit ,
            Authentication authentication
    ) {
        Pageable pageable = PageRequest.of(offset,limit);
        return ResponseEntity.ok(productService.findAllPlants(species, keyword, priceFrom, priceTo, sortField, sortOrder, authentication, pageable));
    }

    @GetMapping("/search/accessories")
    public ResponseEntity<Page<ProductSearchDTO>> findAllAccessories(
            @RequestParam(required = false) String accessoriesType,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double priceFrom,
            @RequestParam(required = false) Double priceTo,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "10") int limit ,
            Authentication authentication
    ) {
        Pageable pageable = PageRequest.of(offset,limit);
        return ResponseEntity.ok(productService.findAllAccessories(accessoriesType, keyword, priceFrom, priceTo, sortField, sortOrder, authentication, pageable));
    }
    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductCreateUpdateDTO> update(@PathVariable String productId,ProductCreateUpdateDTO productCreateUpdateDTO){
        return null;
    }

    @GetMapping("/plants")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PlantMasterInfoDTO>> getAllPlantInfo(){
        return ResponseEntity.ok(productService.getAllPlantInfo());
    }

    @GetMapping("/accessories")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AccessoriesMasterDTO>> getAllAccessoriesInfo(){
        return ResponseEntity.ok(productService.getAllAccessoriesInfo());
    }

}
