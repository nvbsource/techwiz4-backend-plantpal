package vn.plantpal.mobile_backend.services.stock;

import vn.plantpal.mobile_backend.dtos.stock.StockCreateDTO;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;

import java.util.List;

public interface StockService {
    List<StockResponseDTO> getAll();
    StockResponseDTO getOneById(String id);
    StockResponseDTO create(StockCreateDTO stockCreateDTO);
    StockResponseDTO update(String id, StockCreateDTO stockCreateDTO);
    void delete(String id);
}
