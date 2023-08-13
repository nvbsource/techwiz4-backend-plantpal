package vn.plantpal.mobile_backend.services.product_images;

import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.entities.ProductImages;
import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;

public interface ProductImageService {
    List<ProductImages> saveAll(List<ProductImages> productImages);

    List<ProductImages> saveAllFromDto(List<ProductImageDTO> productImagesDto, String productId);

    List<ProductImages> updateAllFromDto(List<ProductImageDTO> productImagesDto, Products products);
}
