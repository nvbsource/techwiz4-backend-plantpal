package vn.plantpal.mobile_backend.services.sizes;

import vn.plantpal.mobile_backend.dtos.size.SizeCreateDTO;
import vn.plantpal.mobile_backend.dtos.size.SizeResponseDTO;

import java.util.List;

public interface SizeService {
    List<SizeResponseDTO> getAll();
    SizeResponseDTO getOneById(String id);
    SizeResponseDTO create(SizeCreateDTO sizeCreateDTO);
    SizeResponseDTO update(String id, SizeCreateDTO sizeCreateDTO);
    void delete(String id);
}
