package vn.plantpal.mobile_backend.services.lights;

import vn.plantpal.mobile_backend.dtos.lights.LightRequiresDto;

import java.util.List;

public interface LightService {

    List<LightRequiresDto>  getAll();

    LightRequiresDto getOne(String id);

    LightRequiresDto create(LightRequiresDto LightRequiresDto);

    LightRequiresDto update(List<LightRequiresDto> LightRequiresDto);

    void delete(String id);
}
