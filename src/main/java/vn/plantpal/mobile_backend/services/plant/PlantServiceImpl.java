package vn.plantpal.mobile_backend.services.plant;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;
import vn.plantpal.mobile_backend.repositories.PlantRepository;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService{
    private final PlantRepository plantRepository;


    @Override
    public Page<PlantInfoDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public PlantInfoDTO getOneById(String id) {
        return null;
    }

    @Override
    public PlantInfoDTO getOneByName(String name) {
        return null;
    }

    @Override
    public Page<PlantInfoDTO> filterByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PlantInfoDTO> filterByPrice(String price, Pageable pageable) {
        return null;
    }

    @Override
    public PlantCreatUpdateDTO create(PlantCreatUpdateDTO plantDTO) {
        return null;
    }

    @Override
    public PlantCreatUpdateDTO update(PlantCreatUpdateDTO plantDTO) {
        return null;
    }

    @Override
    public void delete(String plantId) {

    }
}
