package vn.plantpal.mobile_backend.services.lights;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.lights.LightRequiresDto;
import vn.plantpal.mobile_backend.entities.LightRequires;
import vn.plantpal.mobile_backend.repositories.LightRepository;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO Add Authentication
@Service
@RequiredArgsConstructor
public class LightServiceImpl implements LightService {

    private final LightRepository lightRepository;

    @Override
    public List<LightRequiresDto> getAll() {
        return this.lightRepository.findAll().stream().map(s -> EntityMapper.mapToDto(s, LightRequiresDto.class)).toList();
    }

    public Page<LightRequiresDto> getAll(Pageable pageable) {
        Page<LightRequires> data = this.lightRepository.findAllPage(pageable);
//        Page<LightRequiresDto> result= data.map(s -> EntityMapper.mapToDto(s, LightRequiresDto.class));
        return data.map(s -> EntityMapper.mapToDto(s, LightRequiresDto.class));
    }

    @Override
    public LightRequiresDto getOne(String id) {
        return this.lightRepository.findById(id).map(s -> EntityMapper.mapToDto(s, LightRequiresDto.class)).orElseThrow();
    }

    @Override
    public LightRequiresDto create(LightRequiresDto lightRequiresDto) {
        if (lightRepository.existsByStrength(lightRequiresDto.getStrength())) {
            throw new RuntimeException("LightRequires name already exists");
        }
        if (lightRepository.existsByOrders(lightRequiresDto.getOrders())) {
            throw new RuntimeException("Light Order conflict");
        }
        return EntityMapper.mapToDto(this.lightRepository.save(EntityMapper.mapToEntity(lightRequiresDto, LightRequires.class)), LightRequiresDto.class);
    }

    @Override
    public LightRequiresDto update(List<LightRequiresDto> lightRequiresDto) {
        Random random = new Random();
        List<LightRequires> lightRequiresNew = new ArrayList<>();
        lightRequiresDto.forEach(l -> lightRequiresNew.add(EntityMapper.mapToEntity(l, LightRequires.class)));
//        The below code is set order for all lightRequires to random in other to avoid conflict unique constraint
        lightRepository.findAll().forEach(l -> {
            l.setOrders(random.nextInt(1000, 9999));
            lightRepository.save(l);
        });
        return EntityMapper.mapToDto(this.lightRepository.saveAllAndFlush(lightRequiresNew), LightRequiresDto.class);
    }

    @Override
    public void delete(String id) {
        var lightRequires = this.lightRepository.findById(id).orElseThrow();
        this.lightRepository.delete(lightRequires);
        lightRepository.findAllByOrderLargerThanNum(
                lightRequires.getOrders()).forEach(l -> {
            l.setOrders(l.getOrders() - 1);
            lightRepository.save(l);
        });
    }

}
