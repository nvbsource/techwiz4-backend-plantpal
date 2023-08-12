package vn.plantpal.mobile_backend.services.accessory;

import jakarta.transaction.Transactional;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;

import java.awt.print.Pageable;
import java.util.List;

public interface AccessoryService {
    AccessoriesInfoDTO getAccessoryInfo(String accessoryId);

    List<AccessoriesInfoDTO> getList(Pageable pageable);

    @Transactional(rollbackOn = Exception.class)
    AccessoriesInfoDTO create(AccessoriesCreateUpdateDTO accessoryDto);

    @Transactional(rollbackOn = Exception.class)
    AccessoriesInfoDTO update(String id, AccessoriesCreateUpdateDTO accessoryDto);
}
