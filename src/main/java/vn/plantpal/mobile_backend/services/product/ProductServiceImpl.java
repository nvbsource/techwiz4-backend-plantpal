package vn.plantpal.mobile_backend.services.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(String keyword, Integer offset, Integer limit) {
//        Pageable pageable = PageRequest.of(offset, limit);
//        return productRepository.findAllByNameContainingOrDescriptionContaining(keyword,keyword,pageable).map(e-> EntityMapper.mapToDto(e, ProductDTO.class));
        return productRepository.findAllByNameContainingOrDescriptionContaining(keyword,keyword).stream().map(e-> EntityMapper.mapToDto(e, ProductSearchDTO.class)).toList();
    }

}

