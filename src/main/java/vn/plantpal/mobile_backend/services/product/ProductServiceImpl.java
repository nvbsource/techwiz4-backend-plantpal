package vn.plantpal.mobile_backend.services.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantCreatUpdateDTO;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final String PLANT = ProductType.PLANT.toString();
    private final String ACCESSORIES = ProductType.ACCESSORIES.toString();


    @Override
    public Page<ProductSearchDTO> findAllProduct(int offset, int limit) {

        Pageable pageable = PageRequest.of(offset, limit);
        Page<ProductSearchDTO> result = productRepository.findAllProduct(pageable);
        if(result.hasContent()){
            return result;
        }else{
            return Page.empty();
        }
    }

    @Override
    public List<PlantCreatUpdateDTO> createPlant(List<PlantCreatUpdateDTO> plantCreatDTOList) {
        return null;
    }

    @Override
    public List<AccessoriesCreateUpdateDTO> createAccessories(List<AccessoriesCreateUpdateDTO> accessoriesCreateDTOList) {
        return null;
    }

    @Override
    public Page<ProductSearchDTO> searchAndFilterProducts(ProductType productType,String search,Double priceFrom, Double priceTo, String sortField, String sortOrder, Pageable pageable) {
       String productTypeSTR = null;
        if(productType != null){
            productTypeSTR = productType.toString();
        }
        return productRepository.searchAndFilterProducts(productTypeSTR,search, priceFrom, priceTo, sortField,sortOrder,pageable);
    }

    @Override
    public PlantCreatUpdateDTO updatePlant(PlantCreatUpdateDTO plantUpdateDTO) {
        return null;
    }

    @Override
    public AccessoriesCreateUpdateDTO updateAccessories(AccessoriesCreateUpdateDTO accessoriesUpdateDTO) {
        return null;
    }


    @Override
    public ProductBaseDTO getOneById(String productId) {
        return null;
    }


}

