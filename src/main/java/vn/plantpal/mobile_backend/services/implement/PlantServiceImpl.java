package vn.plantpal.mobile_backend.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.PlantDTO;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.PlantRepository;
import vn.plantpal.mobile_backend.services.PlantService;
import vn.plantpal.mobile_backend.utils.EntityMapper;


@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;
    public Page<PlantDTO> search(String text){
        return null;
    }

    @Override
    public Page<PlantDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public PlantDTO getOneById(String id) {
        return plantRepository.findById(id).map(p-> EntityMapper.mapToDto(p, PlantDTO.class)).orElseThrow(()-> new ResourceNotFoundException("Plant","id",id));
    }

    @Override
    public PlantDTO getOneByName(String name) {
        return plantRepository.findByName(name).map(p-> EntityMapper.mapToDto(p, PlantDTO.class)).orElseThrow(()-> new ResourceNotFoundException("Plant","name",name));
    }

    @Override
    public Page<PlantDTO> filterByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PlantDTO> filterByPrice(String price, Pageable pageable) {
        return null;
    }

    @Override
    public PlantDTO create(PlantDTO plantDTO) {
        return null;
    }

    @Override
    public PlantDTO update(PlantDTO plantDTO) {
        return null;
    }

    @Override
    public void delete(String plantId) {

    }
}
