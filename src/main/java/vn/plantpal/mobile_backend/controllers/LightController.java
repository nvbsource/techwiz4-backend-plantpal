package vn.plantpal.mobile_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.lights.LightRequiresDto;
import vn.plantpal.mobile_backend.services.lights.LightService;

import java.util.List;

@RestController()
@RequestMapping("/api/light")
public class LightController {

    private final LightService LightsService;

    @Autowired
    public LightController(LightService LightsService) {
        this.LightsService = LightsService;
    }

    @GetMapping()
    public Object getAll() {
        try {
            return LightsService.getAll();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("{id}")
    public Object getLightsById(@PathVariable("id") String id) {
        try {
            var rs = LightsService.getOne(id);
            return rs;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping()
    public Object createLights(@RequestBody LightRequiresDto LightRequiresDto) {
        try {
            validateOrder(LightRequiresDto.getOrders());
            return LightsService.create(LightRequiresDto);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping()
    public Object updateLights(@RequestBody List<LightRequiresDto> lightRequiresDto) {
//        try {
        lightRequiresDto.forEach(lightRequiresDto1 -> validateOrder(lightRequiresDto1.getOrders()));
        return LightsService.update(lightRequiresDto);
//        } catch (Exception e) {
//            return e.getMessage();
//        }
    }

    @DeleteMapping("{id}")
    public Object deleteLights(@PathVariable("id") String id) {
        try {
            LightsService.delete(id);
        return "Delete success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private void validateOrder(int order) {
        if (order < 0) {
            throw new RuntimeException("Order must be greater than 0");
        }
    }
}
