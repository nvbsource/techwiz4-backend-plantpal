package vn.plantpal.mobile_backend.services.product;

import vn.plantpal.mobile_backend.dtos.ProductSize.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

public interface ProductSizeService {
    List<ProductSizes> saveAll(List<ProductSizes> productSizes);

    public List<ProductSizes> saveAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType);


    List<ProductSizes> updateAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType);
}
