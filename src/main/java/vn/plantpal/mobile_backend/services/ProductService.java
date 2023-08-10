package vn.plantpal.mobile_backend.services;

import org.springframework.data.domain.Page;
import vn.plantpal.mobile_backend.dtos.ProductDTO;
import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;


public interface ProductService {
    List<ProductDTO> findAllByNameContainingOrDescriptionContaining(String keyword, Integer offset, Integer limit);
}
