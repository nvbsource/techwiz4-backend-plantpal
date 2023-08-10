package vn.plantpal.mobile_backend.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.SpeciesDto;
import vn.plantpal.mobile_backend.entities.Species;
import vn.plantpal.mobile_backend.repositories.SpeciesRepository;
import vn.plantpal.mobile_backend.services.SpeciesService;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

//TODO Add Authentication
@Service
@RequiredArgsConstructor
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepository;

    @Override
    public List<SpeciesDto> getAll() {
        return this.speciesRepository.findAll().stream().map(s -> EntityMapper.mapToDto(s, SpeciesDto.class)).toList();
    }

    public Page<SpeciesDto> getAll(Pageable pageable) {
        Page<Species> data = this.speciesRepository.findAllPage(pageable);
//        Page<SpeciesDto> result= data.map(s -> EntityMapper.mapToDto(s, SpeciesDto.class));
        return data.map(s -> EntityMapper.mapToDto(s, SpeciesDto.class));
    }

    @Override
    public SpeciesDto getOne(String id) {
        return this.speciesRepository.findById(id).map(s -> EntityMapper.mapToDto(s, SpeciesDto.class)).orElseThrow();
    }

    @Override
    public SpeciesDto create(SpeciesDto speciesDto) {
        if (speciesRepository.existsByName(speciesDto.getName())) {
            throw new RuntimeException("Species name already exists");
        }
        return EntityMapper.mapToDto(this.speciesRepository.save(EntityMapper.mapToEntity(speciesDto, Species.class)), SpeciesDto.class);
    }

    @Override
    public SpeciesDto update(SpeciesDto speciesDto) {
        Species speciesNew = EntityMapper.mapToEntity(speciesDto, Species.class);
        Species speciesOld = this.speciesRepository.findById(speciesNew.getId()).orElseThrow();
        if (speciesRepository.existsByNameAndIdNot(speciesNew.getName(), speciesNew.getId())) {
            throw new RuntimeException("Species name already exists");
        }
        if (speciesNew.getName() == null) speciesNew.setName(speciesOld.getName());
        if (speciesNew.getId() == null) speciesNew.setDescription(speciesOld.getName());

        return EntityMapper.mapToDto(this.speciesRepository.save(speciesNew), SpeciesDto.class);
    }

    @Override
    public void delete(String id) {
        this.speciesRepository.deleteById(id);
    }

}
