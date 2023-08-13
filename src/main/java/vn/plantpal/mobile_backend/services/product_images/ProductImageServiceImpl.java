package vn.plantpal.mobile_backend.services.product_images;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.entities.ProductImages;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.repositories.ProductImageRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;

    @Override
    public List<ProductImages> saveAll(List<ProductImages> productImages) {
        return productImageRepository.saveAll(productImages);
    }

    @Override
    public List<ProductImages> saveAllFromDto(List<ProductImageDTO> productImagesDto, String productId) {
        Products product = new Products();
        product.setId(productId);
        List<ProductImages> productImages = productImagesDto.stream().map(productImageDTO -> new ProductImages(UUID.randomUUID().toString(), productImageDTO.getImage(), productImageDTO.isThumbnail(), product)).toList();
        return productImageRepository.saveAll(productImages);
    }

    @Override
    public List<ProductImages> updateAllFromDto(List<ProductImageDTO> productImagesDto, Products products) {
        productImageRepository.deleteAllByProduct_Id(products.getId());
        List<ProductImages> productImages = productImagesDto.stream().map(productImageDTO -> new ProductImages(UUID.randomUUID().toString(), productImageDTO.getImage(), productImageDTO.isThumbnail(), products)).toList();
        return productImageRepository.saveAll(productImages);
    }
}
