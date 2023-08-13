package vn.plantpal.mobile_backend.services.plant;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;
import vn.plantpal.mobile_backend.entities.LightRequires;
import vn.plantpal.mobile_backend.entities.Plants;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Species;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.PlantRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.services.SpeciesService;
import vn.plantpal.mobile_backend.services.lights.LightService;
import vn.plantpal.mobile_backend.services.product.ProductService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService{
    private final ProductRepository productRepository;
    private final PlantRepository plantRepository;
    private final SpeciesService speciesService;
    private final LightService lightService;
    private final String PLANT = ProductType.PLANT.toString();

    @Override
    public Page<PlantInfoDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public PlantInfoDTO getOneById(String id) {
        return plantRepository.findById(id).map(p-> EntityMapper.mapToDto(p,PlantInfoDTO.class)).orElseThrow(()-> new ResourceNotFoundException("Plant","id",id));
    }

    @Override
    public PlantInfoDTO getOneByName(String name) {
        return plantRepository.findByName(name).map(p-> EntityMapper.mapToDto(p,PlantInfoDTO.class)).orElseThrow(()-> new ResourceNotFoundException("Plant","name",name));
    }

    @Override
    public Page<ProductSearchDTO> filterByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductSearchDTO> filterByPrice(double lowerValue, double upperValue, int offset, int limit) {
//        Pageable pageable = PageRequest.of(offset,limit);
//        Page<String> listProductId =  productService.findProductsBetweenPrice(lowerValue,upperValue, PLANT, pageable);
//        Page<Plants> plantsList = plantRepository
//                .findAllByIdIn(listProductId.getContent().stream().toList(),pageable);
//
//        List<ProductSearchDTO> productSearchDTOS = plantsList.getContent()
//                .stream()
//                .map(r -> ProductSearchDTO.builder()
//                        .id(r.getId())
//                        .productImage(r.getProduct().getProductImages())
//                        .price()
//                        .stockCount()
//                        .build())
//                .toList();
        return null;
    }

    @Override
    public PlantInfoDTO create(String productId, PlantCreatUpdateDTO plantCreatUpdateDTO) {
        Products products = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","id",productId));
        String name = plantCreatUpdateDTO.getName();
        String description = plantCreatUpdateDTO.getDescription();
        String careLevel = plantCreatUpdateDTO.getCareLevel();
        Boolean toxicity = plantCreatUpdateDTO.getToxicity();
        String speciesId = plantCreatUpdateDTO.getSpeciesId();
        String lightRequireId = plantCreatUpdateDTO.getLightRequireId();

        Species species = EntityMapper.mapToEntity(speciesService.getOne(speciesId), Species.class);
        LightRequires lightRequires = EntityMapper.mapToEntity(lightService.getOne(lightRequireId), LightRequires.class);


        Plants plants = Plants.builder()
                .id(products.getId())
                .name(name)
                .description(description)
                .careLevel(careLevel)
                .toxicity(toxicity)
                .specie(species)
                .lightRequire(lightRequires)
                .build();


        return EntityMapper.mapToDto(plantRepository.save(plants),PlantInfoDTO.class);
    }

    @Override
    public PlantInfoDTO update(String productId, PlantCreatUpdateDTO plantDTO) {
        return null;
    }
}
