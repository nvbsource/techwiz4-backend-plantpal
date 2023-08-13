package vn.plantpal.mobile_backend.services.plants;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoAdDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.entities.*;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.LightRepository;
import vn.plantpal.mobile_backend.repositories.PlantRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.SpeciesRepository;
import vn.plantpal.mobile_backend.services.product_images.ProductImageService;
import vn.plantpal.mobile_backend.services.product_sizes.ProductSizeService;
import vn.plantpal.mobile_backend.services.stocks.StockService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.PlantCare;
import vn.plantpal.mobile_backend.utils.ProductType;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;
    private final LightRepository lightRepository;
    private final ProductRepository productRepository;
    private final SpeciesRepository speciesRepository;
    private final ProductSizeService productSizeService;
    private final ProductImageService productImageService;
    private final StockService stockService;

    @Override
    public Page<PlantInfoDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public PlantInfoDTO getOneById(String id) {
        return plantRepository.findById(id).map(p -> EntityMapper.mapToDto(p, PlantInfoDTO.class)).orElseThrow(() -> new ResourceNotFoundException("Plant", "id", id));
    }

    @Override
    public PlantInfoDTO getOneByName(String name) {
        return plantRepository.findByName(name).map(p -> EntityMapper.mapToDto(p, PlantInfoDTO.class)).orElseThrow(() -> new ResourceNotFoundException("Plant", "name", name));
    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public PlantInfoAdDTO create(PlantCreatUpdateDTO plantDTO) {
//        Optional.ofNullable(productService.getOneById(productId)).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        String name = plantDTO.getName();
        String description = plantDTO.getDescription();
        String instruction = plantDTO.getInstruction();
        String careLevel = PlantCare.valueOf(plantDTO.getCareLevel().toUpperCase()).toString();
        Boolean toxicity = plantDTO.getToxicity();
        Species species = speciesRepository.findById(plantDTO.getSpeciesId()).orElseThrow(() -> new BadRequestException("Species not found"));
        LightRequires lightRequires = lightRepository.findById(plantDTO.getLightRequireId()).orElseThrow(() -> new BadRequestException("Light not found"));

        Products products = this.productRepository.saveAndFlush(new Products(plantDTO.getName(), plantDTO.getDescription(), ProductType.PLANT.toString()));
        Plants plants = Plants.builder()
                .id(products.getId())
                .name(name)
                .description(description)
                .instruction(instruction)
                .careLevel(PlantCare.valueOf(careLevel).toString())
                .toxicity(toxicity)
                .specie(species)
                .lightRequire(lightRequires)
                .build();
        plantRepository.saveAndFlush(plants);
        PlantInfoAdDTO rs = EntityMapper.mapToEntity(plants, PlantInfoAdDTO.class);
        rs.setImages(productImageService.saveAllFromDto(plantDTO.getImages(), products).stream().map(i -> EntityMapper.mapToDto(i, ProductImageDTO.class)).toList());
        rs.setSizes(productSizeService.saveAllFromDto(plantDTO.getSizes(), products, ProductType.PLANT).stream().map(a -> EntityMapper.mapToDto(a, ProductSizeInfoDTO.class)).toList());
        return rs;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public PlantInfoAdDTO update(String id, PlantCreatUpdateDTO plantDTO) {

        if (!plantRepository.existsById(id) || !productRepository.existsById(id))
            throw new BadRequestException("Not found plant with provided id");
        LightRequires lightRequires = lightRepository.findById(plantDTO.getLightRequireId()).orElseThrow(() -> new BadRequestException("Not found Light type with provided id"));
        Species species = speciesRepository.findById(plantDTO.getSpeciesId()).orElseThrow(() -> new BadRequestException("Not found Species type with provided id"));
        Products prop = productRepository.saveAndFlush(new Products(id, plantDTO.getName(), plantDTO.getDescription(), ProductType.PLANT.toString()));
        Plants plants = Plants.builder()
                .id(prop.getId())
                .name(plantDTO.getName())
                .description(plantDTO.getDescription())
                .instruction(plantDTO.getInstruction())
                .careLevel(PlantCare.valueOf(plantDTO.getCareLevel()).toString())
                .toxicity(plantDTO.getToxicity())
                .specie(species)
                .lightRequire(lightRequires)
                .build();
        plants = plantRepository.saveAndFlush(plants);
        PlantInfoAdDTO rs = EntityMapper.mapToEntity(plants, PlantInfoAdDTO.class);
        rs.setImages(productImageService.updateAllFromDto(plantDTO.getImages(), prop).stream().map(i -> EntityMapper.mapToDto(i, ProductImageDTO.class)).toList());
        rs.setSizes(productSizeService.updateAllFromDto(plantDTO.getSizes(), prop, ProductType.PLANT).stream().map(a -> {
            Stocks stock = stockService.findByProductSizeId(a.getId());
            return ProductSizeInfoDTO.fromProductSizeEntity(a, stock);
        }).toList());
        return rs;
    }
}
