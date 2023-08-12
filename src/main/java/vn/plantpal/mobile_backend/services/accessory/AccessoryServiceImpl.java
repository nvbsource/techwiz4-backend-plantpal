package vn.plantpal.mobile_backend.services.accessory;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.ProductSize.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.entities.Accessories;
import vn.plantpal.mobile_backend.entities.AccessoriesTypes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.repositories.AccessoryRepository;
import vn.plantpal.mobile_backend.repositories.AccessoryTypeRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.services.product.ProductImageService;
import vn.plantpal.mobile_backend.services.product.ProductSizeService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessoryServiceImpl implements AccessoryService {
    private final AccessoryRepository accessoryRepository;
    private final ProductRepository productRepository;
    private final AccessoryTypeRepository accessoryTypeRepository;
    private final ProductSizeService productSizeService;
    private final ProductImageService productImageService;

    @Override
    public AccessoriesInfoDTO getAccessoryInfo(String accessoryId) {
        return EntityMapper.mapToEntity(accessoryRepository
                .findById(accessoryId).orElseThrow(() ->
                        new BadRequestException("Not found accessory with provided id")), AccessoriesInfoDTO.class);
    }

    @Override
    public List<AccessoriesInfoDTO> getList(Pageable pageable) {
        return accessoryRepository.findAll().stream().map(acc -> EntityMapper.mapToEntity(acc, AccessoriesInfoDTO.class)).toList();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AccessoriesInfoDTO create(AccessoriesCreateUpdateDTO accessoryDto) {
        AccessoriesTypes acc = accessoryTypeRepository.findById(accessoryDto.getTypeId()).orElseThrow(() -> new BadRequestException("Not found accessory type with provided id"));
        Products prop = this.productRepository.save(new Products(accessoryDto.getName(), accessoryDto.getDescription(), ProductType.ACCESSORIES.toString()));
        Accessories accessory = new Accessories(prop.getId(), accessoryDto.getName(), accessoryDto.getInstruction(), accessoryDto.getDescription(), acc);
        accessory = accessoryRepository.save(accessory);
        var rs = EntityMapper.mapToEntity(accessory, AccessoriesInfoDTO.class);
        rs.setImages(productImageService.saveAllFromDto(accessoryDto.getImages(), prop.getId()).stream().map(i -> EntityMapper.mapToDto(i, ProductImageDTO.class)).toList());
        rs.setSizes(productSizeService.saveAllFromDto(accessoryDto.getSizes(), prop, ProductType.ACCESSORIES).stream().map(a -> EntityMapper.mapToDto(a, ProductSizeInfoDTO.class)).toList());
        return rs;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AccessoriesInfoDTO update(String id, AccessoriesCreateUpdateDTO accessoryDto) {
        if (!accessoryRepository.existsById(id) || !productRepository.existsById(id))
            throw new BadRequestException("Not found accessory with provided id");
        AccessoriesTypes acc = accessoryTypeRepository.findById(accessoryDto.getTypeId()).orElseThrow(() -> new BadRequestException("Not found accessory type with provided id"));
        Accessories accessory = new Accessories(id, accessoryDto.getName(), accessoryDto.getInstruction(), accessoryDto.getDescription(), acc);
        Products prop = productRepository.save(new Products(id, accessoryDto.getName(), accessoryDto.getDescription(), ProductType.ACCESSORIES.toString()));
        accessory = accessoryRepository.save(accessory);
        var rs = EntityMapper.mapToEntity(accessory, AccessoriesInfoDTO.class);
        rs.setImages(productImageService.updateAllFromDto(accessoryDto.getImages(), prop).stream().map(i -> EntityMapper.mapToDto(i, ProductImageDTO.class)).toList());
        rs.setSizes(productSizeService.updateAllFromDto(accessoryDto.getSizes(), prop, ProductType.ACCESSORIES).stream().map(a -> EntityMapper.mapToDto(a, ProductSizeInfoDTO.class)).toList());
        return rs;
    }


//        public void delete (String id){
//            accessoryRepository.deleteById(id);
////        TODO delete product image
//            productRepository.deleteById(id);
//        }
}
