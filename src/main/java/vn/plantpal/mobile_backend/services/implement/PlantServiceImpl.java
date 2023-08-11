package vn.plantpal.mobile_backend.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.repositories.PlantRepository;


@Service
@RequiredArgsConstructor
public class PlantServiceImpl {
    private final PlantRepository plantRepository;

}
