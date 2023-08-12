package vn.plantpal.mobile_backend.services.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.ProductSize.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.SizeRepository;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSizeServiceImpl implements ProductSizeService {
    private final ProductSizeRepository productSizeRepository;
    private final SizeRepository sizeRepository;

    @Override
    public List<ProductSizes> saveAll(List<ProductSizes> productSizes) {
        return productSizeRepository.saveAll(productSizes);
    }

    @Override
    public List<ProductSizes> saveAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType) {
        List<ProductSizes> productSizes = productSizeCreateUpdateDTOS.stream().map(productSizeCreateUpdateDTO -> new ProductSizes(
                productSizeCreateUpdateDTO.getPrice(),
                productType.toString(),
                productSizeCreateUpdateDTO.getMadeOnDate(),
                productSizeCreateUpdateDTO.getHeight(),
                productSizeCreateUpdateDTO.getWidth(),
                products,
                sizeRepository.findById(productSizeCreateUpdateDTO.getSizeId()).orElseThrow(() -> new BadRequestException("Size not found"))
        )).toList();
        return productSizeRepository.saveAll(productSizes);
    }

    @Override
    public List<ProductSizes> updateAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType) {
        List<String> sizeId = new ArrayList<>();
        productSizeCreateUpdateDTOS.forEach((s) -> {
            if (!sizeId.contains(s.getSizeId())) sizeId.add(s.getSizeId());
        });
        sizeId.forEach((s) -> {
            if (!sizeRepository.existsById(s)) throw new BadRequestException("Size not found");
        });
        productSizeRepository.deleteAllByProduct_Id(products.getId());
        List<ProductSizes> productSizes = productSizeCreateUpdateDTOS.stream().map(productSizeCreateUpdateDTO -> new ProductSizes(
                productSizeCreateUpdateDTO.getPrice(),
                productType.toString(),
                productSizeCreateUpdateDTO.getMadeOnDate(),
                productSizeCreateUpdateDTO.getHeight(),
                productSizeCreateUpdateDTO.getWidth(),
                products,
                sizeRepository.findById(productSizeCreateUpdateDTO.getSizeId()).orElseThrow(() -> new BadRequestException("Size not found"))
        )).toList();
        productSizeRepository.flush();
        return productSizeRepository.saveAll(productSizes);
    }
}
