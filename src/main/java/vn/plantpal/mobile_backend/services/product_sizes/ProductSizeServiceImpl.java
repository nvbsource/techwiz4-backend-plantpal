package vn.plantpal.mobile_backend.services.product_sizes;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Sizes;
import vn.plantpal.mobile_backend.entities.Stocks;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.SizeRepository;
import vn.plantpal.mobile_backend.services.sizes.SizeService;
import vn.plantpal.mobile_backend.services.stocks.StockService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSizeServiceImpl implements ProductSizeService {
    private final ProductSizeRepository productSizeRepository;
    private final SizeRepository sizeRepository;
    private final SizeService sizeService;
    private final ProductRepository productRepository;
    private final StockService stockService;


    @Override
    public List<ProductSizeDetailDTO> getAllProductSizeByProductId(String productId) {
        return productSizeRepository.getAllProductSizeByProductId(productId).stream().map(ps -> EntityMapper.mapToDto(ps, ProductSizeDetailDTO.class)).toList();
    }

    @Override
    public ProductSizeInfoDTO getOneById(String id) {
        return productSizeRepository.findById(id).map(ps -> EntityMapper.mapToDto(ps, ProductSizeInfoDTO.class)).orElseThrow(() -> new ResourceNotFoundException("ProductSize", "id", id));
    }

    @Override
    public ProductSizeInfoDTO create(ProductSizeCreateUpdateDTO productSizeCreateDTO) {
        String productId = productSizeCreateDTO.getId();
        String sizeId = productSizeCreateDTO.getSizeId();
        String type = productSizeCreateDTO.getType();
        Integer width = productSizeCreateDTO.getWidth();
        Integer height = productSizeCreateDTO.getHeight();
        Double price = productSizeCreateDTO.getPrice();

        boolean productSizeHasExisted = productSizeRepository.existsByProductIdAndSizeId(productId, sizeId);
        if (productSizeHasExisted) {
            throw new DuplicateRecordException("Product with provided Size already exists");
        }
        Products products = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        Sizes sizes = EntityMapper.mapToEntity(sizeService.getOneById(sizeId), Sizes.class);
        ProductSizes productSizes = ProductSizes.builder()
                .product(products)
                .size(sizes)
                .height(height)
                .width(width)
                .price(price)
                .type(type)
                .build();

        return EntityMapper.mapToDto(productSizeRepository.save(productSizes), ProductSizeInfoDTO.class);
    }


    @Override
    public void delete(String id) {
        if (productSizeRepository.existsBySizeId(id)) {
            throw new DuplicateRecordException("Size existing on another Product");
        }
        ProductSizes sizes = productSizeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductSize", "id", id));
        productSizeRepository.delete(sizes);
    }

    @Override
    public List<ProductSizes> saveAll(List<ProductSizes> productSizes) {
        return productSizeRepository.saveAll(productSizes);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public List<ProductSizeInfoDTO> saveAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType) {
        List<ProductSizes> productSizes = productSizeCreateUpdateDTOS.stream().map(productSizeCreate -> new ProductSizes(
                productSizeCreate.getPrice(),
                productType.toString(),
                productSizeCreate.getMadeOnDate(),
                productSizeCreate.getHeight(),
                productSizeCreate.getWidth(),
                products,
                sizeRepository.findById(productSizeCreate.getSizeId()).orElseThrow(() -> new BadRequestException("Size not found")))
        ).toList();
        productRepository.flush();
        productSizes = productSizeRepository.saveAllAndFlush(productSizes);
        List<ProductSizeInfoDTO> response = new ArrayList<>();
        productSizes.forEach(ps -> productSizeCreateUpdateDTOS.stream().filter(psDto -> ps.getSize().getId()
                .equals(psDto.getSizeId())).findFirst().ifPresent(psDto -> {
            Stocks stocks = new Stocks(psDto.getQuantity(), ps, ps.getId(), LocalDateTime.now(), LocalDateTime.now());
            stocks = stockService.save(stocks);
            response.add(ProductSizeInfoDTO.fromProductSizeEntity(ps, stocks));
        }));

        return response;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public List<ProductSizes> updateAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType) {
        List<String> sizeId = new ArrayList<>();
        productSizeCreateUpdateDTOS.forEach((s) -> {
            if (!sizeId.contains(s.getSizeId())) sizeId.add(s.getSizeId());
        });
        sizeId.forEach((s) -> {
            if (!sizeRepository.existsById(s)) throw new BadRequestException("Size not found");
        });
        List<ProductSizes> updateProductsEntity = productSizeRepository.findAllByProduct_Id(products.getId());
        List<ProductSizeCreateUpdateDTO> mirrorNewProductsDto = new ArrayList<>(productSizeCreateUpdateDTOS);
        for (ProductSizeCreateUpdateDTO productSizeCreateUpdateDTO : productSizeCreateUpdateDTOS
        ) {
            for (ProductSizes productSizes : updateProductsEntity
            ) {
                if (productSizes.getId().isEmpty() || productSizes.getId().isBlank())
                    break;
                if (productSizes.getId().equals(productSizeCreateUpdateDTO.getId())) {
                    stockService.updateByField(productSizeCreateUpdateDTO.getQuantity(), productSizes);
                    productSizes.setSize(sizeRepository.findById(productSizeCreateUpdateDTO.getSizeId()).orElseThrow(() -> new BadRequestException("Size not found")));
                    productSizes.setPrice(productSizeCreateUpdateDTO.getPrice());
                    productSizes.setMadeOnDate(productSizeCreateUpdateDTO.getMadeOnDate());
                    productSizes.setHeight(productSizeCreateUpdateDTO.getHeight());
                    productSizes.setWidth(productSizeCreateUpdateDTO.getWidth());
                    productSizeRepository.saveAndFlush(productSizes);

//                    Update stock
                    updateProductsEntity.remove(productSizes);
                    mirrorNewProductsDto.remove(productSizeCreateUpdateDTO);
                    break;
                }
            }
        }
        if (!mirrorNewProductsDto.isEmpty())
            saveAllFromDto(mirrorNewProductsDto, products, productType);
        if (!updateProductsEntity.isEmpty()) {
            updateProductsEntity.forEach((s) -> s.setDeleted(true));
            productSizeRepository.saveAllAndFlush(updateProductsEntity);
        }
        productSizeRepository.flush();
        return productSizeRepository.findAllByProduct_Id(products.getId());
    }
}
