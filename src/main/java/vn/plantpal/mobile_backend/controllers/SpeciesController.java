package vn.plantpal.mobile_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.SpeciesDto;
import vn.plantpal.mobile_backend.services.SpeciesService;

@RestController()
@RequestMapping("/api/species")
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

//    @GetMapping()
//    public Object getSpecies() {
//        return speciesService.getAll();
//    }

    @GetMapping()
    public Object getSpecies(Pageable pageable) {
//    public Page<?> getSpecies(Pageable pageable) {

        try {
            return speciesService.getAll(pageable);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("{id}")
    public Object getSpeciesById(@PathVariable("id") String id) {
        try {
            var rs = speciesService.getOne(id);
            return rs;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping()
    public Object createSpecies(SpeciesDto speciesDto) {
        try {
            return speciesService.create(speciesDto);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping()
    public Object updateSpecies(SpeciesDto speciesDto) {
        try {
            return speciesService.update(speciesDto);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("{id}")
    public Object deleteSpecies(@PathVariable("id") String id) {
        try {
            speciesService.delete(id);
            return "Delete success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
