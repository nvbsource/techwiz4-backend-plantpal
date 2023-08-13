package vn.plantpal.mobile_backend.controllers;

import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesCreateUpdateDTO;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.services.accessories.AccessoryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/accessories")
public class AccessoryController {
    private final AccessoryService accessoryService;

    public AccessoryController(AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    @PostMapping("/create")
    public Object create(@RequestBody AccessoriesCreateUpdateDTO accessoryDto) {
        checkDuplicateSizeType(accessoryDto);
        return accessoryService.create(accessoryDto);
    }

    @PutMapping("/update/{id}")
    public Object update(@PathVariable("id") String id, @RequestBody AccessoriesCreateUpdateDTO accessoryDto) {
        checkDuplicateSizeType(accessoryDto);
        return accessoryService.update(id, accessoryDto);
    }

    private void checkDuplicateSizeType(AccessoriesCreateUpdateDTO accessoryDto) {
        Set<String> uniqueStrings = new HashSet<>();
        List<String> checkList = accessoryDto.getSizes().stream().map(ProductSizeCreateUpdateDTO::getSizeId).toList();
        for (String str : checkList) {
            if (!uniqueStrings.add(str)) {
                throw new BadRequestException("Duplicate size type");
            }
        }
    }
}
