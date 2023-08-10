package vn.plantpal.mobile_backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.PlantDTO;

public interface PlantService {
    Page<PlantDTO> getAll(Pageable pageable);
    PlantDTO getOneById(String id);
    PlantDTO getOneByName(String name);

    Page<PlantDTO> filterByName(String name,Pageable pageable);
    Page<PlantDTO> filterByPrice(String price,Pageable pageable);

    PlantDTO create(PlantDTO plantDTO);
    PlantDTO update(PlantDTO plantDTO);
    void delete(String plantId);
}
