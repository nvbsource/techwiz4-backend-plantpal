package vn.plantpal.mobile_backend.controllers;

import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.services.plants.PlantService;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping("/create")
    public Object create(@RequestBody PlantCreatUpdateDTO plantDto) {

        return plantService.create(plantDto);
    }

    @PutMapping("/update/{id}")
    public Object update(@PathVariable("id") String id, @RequestBody PlantCreatUpdateDTO plantDto) {
        return plantService.update(id, plantDto);
    }

}
