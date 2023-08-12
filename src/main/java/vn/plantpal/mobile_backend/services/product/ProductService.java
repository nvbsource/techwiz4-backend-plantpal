package vn.plantpal.mobile_backend.services.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;

import java.util.List;


public interface ProductService {
    PlantCreatUpdateDTO updatePlant(PlantCreatUpdateDTO plantUpdateDTO);
    AccessoriesCreateUpdateDTO updateAccessories(AccessoriesCreateUpdateDTO accessoriesUpdateDTO);

    ProductBaseDTO getOneById(String productId);

    Page<ProductSearchDTO> findAllProduct(int offset, int limit);

    List<PlantCreatUpdateDTO> createPlant(List<PlantCreatUpdateDTO> plantCreatDTOList);

    List<AccessoriesCreateUpdateDTO> createAccessories(List<AccessoriesCreateUpdateDTO> accessoriesCreateDTOList);

    Page<ProductSearchDTO> searchAndFilterProducts(String productType, String keyword,  Double priceFrom, Double priceTo, String sortField, String sortOrder, Pageable pageable);
}
