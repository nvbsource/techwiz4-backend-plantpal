package vn.plantpal.mobile_backend.services.accessory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeCreateUpdateDto;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;

import java.util.List;

public interface AccessoryTypeService {
    List<AccessoryTypeCreateUpdateDto> getAll();

    Page<AccessoryTypeInfoDto> getAll(Pageable pageable);

    AccessoryTypeInfoDto getOne(String id);

    AccessoryTypeInfoDto create(AccessoryTypeCreateUpdateDto accessoryTypeDto);

    AccessoryTypeInfoDto update(AccessoryTypeCreateUpdateDto accessoryTypeDto, String id);

    void delete(String id);
}
