package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.size.SizeCreateDTO;
import vn.plantpal.mobile_backend.dtos.size.SizeResponseDTO;
import vn.plantpal.mobile_backend.services.size.SizeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sizes")
public class SizeController {
    private final SizeService sizeService;

    @GetMapping
    public List<SizeResponseDTO> getAllSizes() {
        return sizeService.getAll();
    }

    @PostMapping
    public SizeResponseDTO createSize(@RequestBody SizeCreateDTO sizeCreateDTO) {
        return sizeService.create(sizeCreateDTO);
    }

    @PutMapping("/{id}")
    public SizeResponseDTO updateSize(@PathVariable String id, @RequestBody SizeCreateDTO sizeCreateDTO) {
        return sizeService.update(id, sizeCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSize(@PathVariable String id) {
        sizeService.delete(id);
    }
}
