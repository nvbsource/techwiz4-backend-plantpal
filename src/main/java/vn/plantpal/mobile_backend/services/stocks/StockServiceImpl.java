package vn.plantpal.mobile_backend.services.stocks;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Stocks;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.StockRepository;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ProductSizeRepository productSizeRepository;


    @Override
    public Page<StockResponseDTO> getAll(ProductType productType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Pageable pageable) {
        String productTypeSTR = null;
        if (productType != null) {
            productTypeSTR = productType.toString();
        }
        Page<StockResponseDTO> response = stockRepository.getStocks(productTypeSTR, keyword, priceFrom, priceTo, sortField, sortOrder, pageable);
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
    public StockResponseDTO create(StockCreateDTO stockCreateDTO, Products products) {
        return null;
    }

    @Override
    public List<Stocks> createListToListSize(List<ProductSizeCreateUpdateDTO> productSizesList, List<ProductSizes> productSizes) {
        List<Stocks> listStock = new ArrayList<>(productSizes.size());
        productSizes.forEach(ps -> productSizesList.stream().filter(psDto -> ps.getSize().getId().equals(psDto.getSizeId())).findFirst().ifPresent(psDto -> listStock.add(new Stocks(psDto.getQuantity(), ps, ps.getId(), LocalDateTime.now(), LocalDateTime.now()))));
        return stockRepository.saveAllAndFlush(listStock);
    }

    @Override
    public Stocks save(Stocks stock) {
        return stockRepository.saveAndFlush(stock);
    }

    @Override
    public Stocks updateByField(int quantity, ProductSizes productSize) {
        Stocks stocks = stockRepository.getFirstByProductSize_Id(productSize.getId());
        stocks.setQuantity(quantity);
//        stocks.setProductSize(productSize);
//        stocks.setProductSizesId(productSize.getId());
        return stockRepository.saveAndFlush(stocks);
    }

    @Override
    public Stocks findByProductSizeId(String productSizeId) {
        return stockRepository.getFirstByProductSize_Id(productSizeId);
    }

    @Override
    public StockResponseDTO update(String id, StockCreateDTO stockCreateDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
