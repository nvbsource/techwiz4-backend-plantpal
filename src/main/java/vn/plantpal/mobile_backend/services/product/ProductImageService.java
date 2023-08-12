package vn.plantpal.mobile_backend.services.product;

import vn.plantpal.mobile_backend.dtos.ProductImageDTO;
import vn.plantpal.mobile_backend.entities.ProductImages;
import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;

public interface ProductImageService {
    List<ProductImages> saveAll(List<ProductImages> productImages);

    List<ProductImages> saveAllFromDto(List<ProductImageDTO> productImagesDto, Products product);

    List<ProductImages> updateAllFromDto(List<ProductImageDTO> productImagesDto, Products products);
}
