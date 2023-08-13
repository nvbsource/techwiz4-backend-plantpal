package vn.plantpal.mobile_backend.services.stocks;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

public interface StockService {
    Page<StockResponseDTO> getAll(ProductType productType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Pageable pageable);

    StockResponseDTO getOneById(String id);
    StockResponseDTO create(StockCreateDTO stockCreateDTO);
    StockResponseDTO update(String id, StockCreateDTO stockCreateDTO);
    void delete(String id);
}
