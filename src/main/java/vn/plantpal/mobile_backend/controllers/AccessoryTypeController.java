package vn.plantpal.mobile_backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeCreateUpdateDto;
import vn.plantpal.mobile_backend.services.accessories.AccessoryTypeService;

@RestController
@RequestMapping("/api/accessory-type")
public class AccessoryTypeController {

    private final AccessoryTypeService accessoryTypeService;

    @Autowired
    public AccessoryTypeController(AccessoryTypeService accessoryTypeService) {
        this.accessoryTypeService = accessoryTypeService;
    }

    @GetMapping()
    public Object getAccessoryType(Pageable pageable) {
        try {
            return accessoryTypeService.getAll(pageable);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("{id}")
    public Object getAccessoryTypeById(@PathVariable("id") String id) {
        try {
            return accessoryTypeService.getOne(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping()
    public Object createAccessoryType(AccessoryTypeCreateUpdateDto accessoryTypeDto) {
        try {
            return accessoryTypeService.create(accessoryTypeDto);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping("{id}")
    public Object updateAccessoryType(AccessoryTypeCreateUpdateDto accessoryTypeDto, @PathVariable String id) {
        try {
            return accessoryTypeService.update(accessoryTypeDto,id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("{id}")
    public Object deleteAccessoryType(@PathVariable("id") String id) {
        try {
            accessoryTypeService.delete(id);
            return "Delete success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
