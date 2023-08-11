package vn.plantpal.mobile_backend.services.product;

import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;

import java.util.List;


public interface ProductService {
    List<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(String keyword, Integer offset, Integer limit);
}
