package vn.plantpal.mobile_backend.services.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.size.SizeCreateDTO;
import vn.plantpal.mobile_backend.dtos.size.SizeResponseDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.repositories.StockRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;


    @Override
    public List<StockResponseDTO> getAll() {
//        return stockRepository.getAll();
        return null;
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
