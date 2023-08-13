package vn.plantpal.mobile_backend.services.stocks;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.StockRepository;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ProductSizeRepository productSizeRepository;


    @Override
    public Page<StockResponseDTO> getAll(ProductType productType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Pageable pageable) {
        String productTypeSTR = null;
        if(productType != null){
            productTypeSTR = productType.toString();
        }
        Page<StockResponseDTO> response = stockRepository.getStocks(productTypeSTR,keyword,priceFrom,priceTo,sortField,sortOrder,pageable);
        return response;
    }

    @Override
    public StockResponseDTO getOneById(String id) {
        return null;
    }

    @Override
    public StockResponseDTO create(StockCreateDTO stockCreateDTO) {
        return null;
    }

    @Override
    public StockResponseDTO update(String id, StockCreateDTO stockCreateDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
