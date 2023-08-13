package vn.plantpal.mobile_backend.services.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesMasterDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantMasterInfoDTO;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;


public interface ProductService {
    ProductBaseDTO getOneById(String productId);
    Page<ProductSearchDTO> getAllProductWithSearchAndFilter(ProductType productType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authUser, Pageable pageable);

    Page<ProductSearchDTO> findAllPlants(String species, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authentication, Pageable pageable);
    Page<ProductSearchDTO> findAllAccessories(String species, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authentication, Pageable pageable);

    Object getProductDetail(String id);

    List<PlantMasterInfoDTO> getAllPlantInfo();

    List<AccessoriesMasterDTO> getAllAccessoriesInfo();
}
