package vn.plantpal.mobile_backend.services.species;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.SpeciesDto;

import java.util.List;

public interface SpeciesService {

    List<SpeciesDto>  getAll();
    Page<SpeciesDto> getAll(Pageable pageable);

    SpeciesDto getOne(String id);

    SpeciesDto create(SpeciesDto speciesDto);

    SpeciesDto update(SpeciesDto speciesDto);

    void delete(String id);
}
