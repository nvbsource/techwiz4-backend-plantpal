package vn.plantpal.mobile_backend.services.stocks;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Stocks;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

public interface StockService {
    Page<StockResponseDTO> getAll(ProductType productType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Pageable pageable);

    StockResponseDTO getOneById(String id);
    StockResponseDTO create(StockCreateDTO stockCreateDTO);
    StockResponseDTO create(StockCreateDTO stockCreateDTO, Products products);

    List<Stocks> createListToListSize(List<ProductSizeCreateUpdateDTO> productSizesList, List<ProductSizes> productSizes);

    Stocks save(Stocks stock);

    Stocks updateByField(int quantity, ProductSizes productSize);

    Stocks findByProductSizeId(String productSizeId);

    StockResponseDTO update(String id, StockCreateDTO stockCreateDTO);
    void delete(String id);
}
