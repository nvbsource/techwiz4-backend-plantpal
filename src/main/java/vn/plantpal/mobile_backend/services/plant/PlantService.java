package vn.plantpal.mobile_backend.services.plant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;

public interface PlantService {
    Page<PlantInfoDTO> getAll(Pageable pageable);
    PlantInfoDTO getOneById(String id);
    PlantInfoDTO getOneByName(String name);

    Page<PlantInfoDTO> filterByName(String name, Pageable pageable);
    Page<PlantInfoDTO> filterByPrice(String price,Pageable pageable);

    PlantCreatUpdateDTO create(PlantCreatUpdateDTO plantDTO);
    PlantCreatUpdateDTO update(PlantCreatUpdateDTO plantDTO);
    void delete(String plantId);
}
