package vn.plantpal.mobile_backend.controllers;

import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesCreateUpdateDTO;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.services.accessory.AccessoryService;

import java.util.ArrayList;
import java.util.List;

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
        List<String> sizeTypes = new ArrayList<>(accessoryDto.getSizes().size());
        accessoryDto.getSizes().forEach(size -> {
            if (sizeTypes.contains(size.getType())) {
                throw new BadRequestException("Duplicate size type");
            }
            sizeTypes.add(size.getType());
        });
    }
}
