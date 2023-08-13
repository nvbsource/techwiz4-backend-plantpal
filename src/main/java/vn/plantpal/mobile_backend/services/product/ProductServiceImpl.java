package vn.plantpal.mobile_backend.services.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.SpeciesDto;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;
import vn.plantpal.mobile_backend.dtos.lights.LightRequiresDto;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductDetailDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesMasterDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesTypeDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantMasterInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.entities.Accessories;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.*;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.accessories.AccessoryService;
import vn.plantpal.mobile_backend.services.plants.PlantService;
import vn.plantpal.mobile_backend.services.product_sizes.ProductSizeService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductSizeService productSizesService;
    private final PlantService plantService;
    private final AccessoryTypeRepository accessoryTypeRepository;
    private final AccessoryService accessoryService;
    private final SpeciesRepository speciesRepository;
    private final LightRepository lightRepository;
    private final ProductImageRepository productImageRepository;
    private final String PLANT = ProductType.PLANT.toString();
    private final String ACCESSORIES = ProductType.ACCESSORIES.toString();




    @Override
    public Page<ProductSearchDTO> findAllPlants(String species, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authentication, Pageable pageable) {
        return getProductSearchDTOS(species, keyword, priceFrom, priceTo, sortField, sortOrder, authentication, pageable,PLANT);
    }

    @Override
    public Page<ProductSearchDTO> findAllAccessories(String accessoriesType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authentication, Pageable pageable) {
        return getProductSearchDTOS(accessoriesType, keyword, priceFrom, priceTo, sortField, sortOrder, authentication, pageable,ACCESSORIES);
    }

    @Override
    public ProductDetailDTO getProductDetail(String id) {
        Products products = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        String type = products.getProductType();
        PlantInfoDTO plants = null;
        AccessoriesInfoDTO accessories = null;
        List<ProductSizeDetailDTO> sizesList = productSizesService.getAllProductSizeByProductId(products.getId());
        List<ProductImageDTO> images = products.getProductImages().stream().map(im-> EntityMapper.mapToDto(im, ProductImageDTO.class)).toList();
        if(type.equals(PLANT)){
             plants = plantService.getOneById(products.getId());
        }else{
             accessories = accessoryService.getAccessoryInfo(products.getId());
        }
        return ProductDetailDTO.builder()
                .id(products.getId())
                .name(products.getName())
                .description(products.getDescription())
                .productType(type)
                .plant(plants)
                .accessory(accessories)
                .images(images)
                .sizes(sizesList)
                .build();
    }

    @Override
    public List<PlantMasterInfoDTO> getAllPlantInfo() {
        return productRepository.getAllPlantInfo().stream()
                .map(pl -> {
                    pl.setSpecie(EntityMapper.mapToDto(speciesRepository.findByPlantId(pl.getId()), SpeciesDto.class));
                    pl.setLightRequire(EntityMapper.mapToDto(lightRepository.findByPlantId(pl.getId()), LightRequiresDto.class));
                    pl.setImages(productImageRepository.findAllPlantByProductId(pl.getId())
                            .stream()
                            .map(m -> EntityMapper.mapToDto(m, ProductImageDTO.class))
                            .toList());
                    pl.setSizes(productSizesService.getAllProductSizeByProductId(pl.getId()));
                    return pl;
                })
                .toList();
    }

    @Override
    public List<AccessoriesMasterDTO> getAllAccessoriesInfo() {
        return productRepository.getAllAccessoriesInfo().stream()
                .map(ac -> {
                    ac.setType(EntityMapper.mapToDto(accessoryTypeRepository.findByAccessoriesId(ac.getId()), AccessoriesTypeDTO.class));
                    ac.setImages(productImageRepository.findAllPlantByProductId(ac.getId())
                            .stream()
                            .map(m -> EntityMapper.mapToDto(m, ProductImageDTO.class))
                            .toList());
                    ac.setSizes(productSizesService.getAllProductSizeByProductId(ac.getId()));
                    return ac;
                })
                .toList();
    }

    private Page<ProductSearchDTO> getProductSearchDTOS(String typeFilter, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authentication, Pageable pageable,String typeProduct) {
        String userId = getUserIdFromAuthentication(authentication);
        return switch (typeProduct) {
            case "PLANT" ->
                    productRepository.findAllPlants(typeFilter, keyword, priceFrom, priceTo, sortField, sortOrder, userId, pageable);
            case "ACCESSORIES" ->
                    productRepository.findAllAccessories(typeFilter, keyword, priceFrom, priceTo, sortField, sortOrder, userId, pageable);
            default -> null;
        };
    }


    @Override
    public Page<ProductSearchDTO> getAllProductWithSearchAndFilter(ProductType productType, String search, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authentication, Pageable pageable) {

        String productTypeSTR = null;
        if(productType != null){
            productTypeSTR = productType.toString();
        }
        String userId = getUserIdFromAuthentication(authentication);
        return productRepository.searchAndFilterProducts(productTypeSTR,search, priceFrom, priceTo, sortField,sortOrder,userId,pageable);


    }

    private static String getUserIdFromAuthentication(Authentication authentication) {
        String userId = null;
        if(authentication != null){
            AuthUserDTO authUser = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
           userId = authUser.getUserID();
        }
        return userId;
    }


    @Override
    public ProductBaseDTO getOneById(String productId) {
        return productRepository.findById(productId).map(r-> EntityMapper.mapToDto(r,ProductBaseDTO.class)).orElseThrow(()-> new ResourceNotFoundException("Product","id",productId));
    }


}

