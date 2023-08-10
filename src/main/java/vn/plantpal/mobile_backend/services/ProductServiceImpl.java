package vn.plantpal.mobile_backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.ProductDTO;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllByNameContainingOrDescriptionContaining(String keyword, Integer offset, Integer limit) {
//        Pageable pageable = PageRequest.of(offset, limit);
//        return productRepository.findAllByNameContainingOrDescriptionContaining(keyword,keyword,pageable).map(e-> EntityMapper.mapToDto(e, ProductDTO.class));
        return productRepository.findAllByNameContainingOrDescriptionContaining(keyword,keyword).stream().map(e-> EntityMapper.mapToDto(e, ProductDTO.class)).toList();
    }

}

