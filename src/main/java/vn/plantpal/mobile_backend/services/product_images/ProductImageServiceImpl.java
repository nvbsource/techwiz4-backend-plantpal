package vn.plantpal.mobile_backend.services.product_images;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.entities.ProductImages;
import vn.plantpal.mobile_backend.entities.ProductImages;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.repositories.ProductImageRepository;

import java.util.ArrayList;
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
    public List<ProductImages> saveAllFromDto(List<ProductImageDTO> productImagesDto, Products product) {
        List<ProductImages> productImages = productImagesDto.stream().map(productImageDTO -> new ProductImages(UUID.randomUUID().toString(), productImageDTO.getImage(), productImageDTO.isThumbnail(), false, product)).toList();
        return productImageRepository.saveAll(productImages);
    }

    @Override
    public List<ProductImages> updateAllFromDto(List<ProductImageDTO> productImagesDto, Products products) {
        List<ProductImages> updateProductsEntity = productImageRepository.findAllByProduct_Id(products.getId());
        List<ProductImageDTO> mirrorNewProductsDto = new ArrayList<>(productImagesDto);
        for (ProductImageDTO productImageCreateUpdateDTO : productImagesDto
        ) {
            for (ProductImages productImages : updateProductsEntity
            ) {
                if (productImages.getId().isEmpty() || productImages.getId().isBlank())
                    break;
                if (productImages.getId().equals(productImageCreateUpdateDTO.getId())) {
                    productImages.setProductImage(productImageCreateUpdateDTO.getImage());
                    productImages.setThumbnail(productImageCreateUpdateDTO.isThumbnail());
                    productImageRepository.saveAndFlush(productImages);
                    updateProductsEntity.remove(productImages);
                    mirrorNewProductsDto.remove(productImageCreateUpdateDTO);
                    break;
                }
            }
        }
        if (!mirrorNewProductsDto.isEmpty())
            saveAllFromDto(mirrorNewProductsDto, products);
        if (!updateProductsEntity.isEmpty()) {
            updateProductsEntity.forEach((s) -> s.setDeleted(true));
            productImageRepository.saveAllAndFlush(updateProductsEntity);
        }
        return productImageRepository.findAllByProduct_Id(products.getId());
    }
}
