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
    Page<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(String keyword, int offset, int limit);

    PlantCreatUpdateDTO updatePlant(PlantCreatUpdateDTO plantUpdateDTO);
    AccessoriesCreateUpdateDTO updateAccessories(AccessoriesCreateUpdateDTO accessoriesUpdateDTO);

    ProductBaseDTO getOneById(String productId);

    Page<String> findProductsBetweenPrice(double lowerValue, double upperValue, String type, Pageable pageable);

    List<PlantCreatUpdateDTO> createPlant(List<PlantCreatUpdateDTO> plantCreatDTOList);

    List<AccessoriesCreateUpdateDTO> createAccessories(List<AccessoriesCreateUpdateDTO> accessoriesCreateDTOList);
}
