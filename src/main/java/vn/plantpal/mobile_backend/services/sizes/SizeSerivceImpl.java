package vn.plantpal.mobile_backend.services.sizes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.size.SizeCreateDTO;
import vn.plantpal.mobile_backend.dtos.size.SizeResponseDTO;
import vn.plantpal.mobile_backend.entities.Sizes;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.SizeRepository;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeSerivceImpl implements SizeService{
    private final SizeRepository sizeRepository;
    private final ProductSizeRepository productSizeRepository;

    @Override
    public List<SizeResponseDTO> getAll() {
        return sizeRepository.findAll().stream().map(size-> EntityMapper.mapToDto(size,SizeResponseDTO.class)).toList();
    }

    @Override
    public SizeResponseDTO getOneById(String id) {
        return sizeRepository.findById(id).map(size-> EntityMapper.mapToDto(size,SizeResponseDTO.class)).orElseThrow(()->new ResourceNotFoundException("Size","id",id));
    }

    @Override
    public SizeResponseDTO create(SizeCreateDTO sizeCreateDTO) {
        String sizeType = sizeCreateDTO.getSizeType();
        if(sizeRepository.existsBySizeType(sizeType)){
            throw new DuplicateRecordException("Size Type already exists");
        }
        Sizes sizes = Sizes.builder()
                .sizeType(sizeCreateDTO.getSizeType())
                .build();
        return EntityMapper.mapToDto(sizeRepository.save(sizes),SizeResponseDTO.class);
    }

    @Override
    public SizeResponseDTO update(String id, SizeCreateDTO sizeCreateDTO) {
        String sizeType = sizeCreateDTO.getSizeType();
        Sizes sizes = sizeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Size","id", id));
        if(sizeRepository.existsBySizeType(sizeType)){
            throw new DuplicateRecordException("Size Type already exists");
        }
        sizes.setSizeType(sizeCreateDTO.getSizeType());
        return EntityMapper.mapToDto(sizeRepository.save(sizes),SizeResponseDTO.class);
    }

    @Override
    public void delete(String id) {
        if(productSizeRepository.existsBySizeId(id)){
            throw new DuplicateRecordException("Size existing on another Product");
        }
        Sizes sizes = sizeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Size","id",id));
        sizeRepository.delete(sizes);
    }
}
