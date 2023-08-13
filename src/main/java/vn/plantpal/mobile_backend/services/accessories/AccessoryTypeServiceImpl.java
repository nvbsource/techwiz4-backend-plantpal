package vn.plantpal.mobile_backend.services.accessories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeCreateUpdateDto;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;
import vn.plantpal.mobile_backend.entities.AccessoriesTypes;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.repositories.AccessoryTypeRepository;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccessoryTypeServiceImpl implements AccessoryTypeService {

    private final AccessoryTypeRepository accessoryTypeRepository;

    @Override
    public List<AccessoryTypeCreateUpdateDto> getAll() {
        return this.accessoryTypeRepository.findAll().stream().map(s -> EntityMapper.mapToDto(s, AccessoryTypeCreateUpdateDto.class)).toList();
    }

    @Override
    public Page<AccessoryTypeInfoDto> getAll(Pageable pageable) {
        Page<AccessoriesTypes> data = this.accessoryTypeRepository.findAllFatherPage(pageable);
        return data.map(AccessoryTypeInfoDto::fromAccessoriesTypes);
    }

    @Override
    public AccessoryTypeInfoDto getOne(String id) {
        return this.accessoryTypeRepository.findById(id).map(s -> EntityMapper.mapToDto(s, AccessoryTypeInfoDto.class)).orElseThrow(() -> new BadRequestException("Not found accessoryType with provided id"));
    }

    @Override
    public AccessoryTypeInfoDto create(AccessoryTypeCreateUpdateDto accessoryTypeDto) {
        if (accessoryTypeRepository.existsByName(accessoryTypeDto.getName())) {
            throw new RuntimeException("AccessoriesTypes name already exists");
        }
        if (accessoryTypeDto.getFatherTypeId() != null && !accessoryTypeDto.getFatherTypeId().isEmpty()) {

            if (!accessoryTypeRepository.existsById(accessoryTypeDto.getFatherTypeId())) {
                throw new BadRequestException("AccessoriesTypes fatherTypeId not exists");
            }
            //        Prevent circular reference and child in child
            if (accessoryTypeRepository.existsByIdAndFatherAccessoriesTypesIsNotNull(accessoryTypeDto.getFatherTypeId())) {
                throw new BadRequestException("It is a child of another parent");
            }
        }
        AccessoriesTypes accessoryType = EntityMapper.mapToEntity(accessoryTypeDto, AccessoriesTypes.class);
        AccessoriesTypes fatherAccess = new AccessoriesTypes();
        fatherAccess.setId(accessoryTypeDto.getFatherTypeId());
        accessoryType.setFatherAccessoriesTypes(fatherAccess);

        return AccessoryTypeInfoDto.fromAccessoriesTypes(this.accessoryTypeRepository.save(EntityMapper.mapToEntity(accessoryType, AccessoriesTypes.class)));
    }

    @Override
    public AccessoryTypeInfoDto update(AccessoryTypeCreateUpdateDto accessoryTypeDto, String id) {
        AccessoriesTypes oldAccessoryType = this.accessoryTypeRepository.findById(id).orElseThrow(() -> new BadRequestException("Not found accessoryType with provided id"));
        if (accessoryTypeRepository.existsByNameAndIdNot(accessoryTypeDto.getName(), id)) {
            throw new RuntimeException("AccessoriesTypes name already exists");
        } else {
            oldAccessoryType.setName(accessoryTypeDto.getName());
        }
        oldAccessoryType.setDescription(accessoryTypeDto.getDescription());
        if (accessoryTypeDto.getFatherTypeId() != null && !accessoryTypeDto.getFatherTypeId().isEmpty()) {
            if (!Objects.equals(accessoryTypeDto.getFatherTypeId(), oldAccessoryType.getFatherAccessoriesTypes().getId()) && !accessoryTypeRepository.existsById(accessoryTypeDto.getFatherTypeId())) {
                throw new RuntimeException("AccessoriesTypes fatherTypeId not exists");
            } else {
                oldAccessoryType.setFatherAccessoriesTypes(
                        accessoryTypeRepository.findById(Objects.requireNonNull(accessoryTypeDto.getFatherTypeId()))
                                .orElseThrow(() -> new BadRequestException("Not found provided father type based on Id")));
            }
        } else {
            oldAccessoryType.setFatherAccessoriesTypes(null);
        }
        return AccessoryTypeInfoDto.fromAccessoriesTypes(this.accessoryTypeRepository.save(oldAccessoryType));
    }

    @Override
    public void delete(String id) {
        accessoryTypeRepository.findById(id).orElseThrow(() -> new BadRequestException("Not found accessoryType with provided id")).getAccessoriesTypesChild().forEach(s -> {
            s.setFatherAccessoriesTypes(null);
            accessoryTypeRepository.save(s);
        });
        this.accessoryTypeRepository.deleteById(id);
    }
}
