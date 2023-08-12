package vn.plantpal.mobile_backend.services.plant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoAdDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;

public interface PlantService {
    Page<PlantInfoDTO> getAll(Pageable pageable);
    PlantInfoDTO getOneById(String id);
    PlantInfoDTO getOneByName(String name);

    PlantInfoAdDTO create(PlantCreatUpdateDTO plantDTO);
    PlantInfoAdDTO update(String productId, PlantCreatUpdateDTO plantDTO);

}
