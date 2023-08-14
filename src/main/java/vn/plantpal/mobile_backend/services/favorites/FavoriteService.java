package vn.plantpal.mobile_backend.services.favorites;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteCreateDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteDeleteDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteResponseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.utils.ProductType;

public interface FavoriteService {
    FavoriteResponseDTO create(FavoriteCreateDTO favoriteCreateDTO, String userId);

    void delete(FavoriteDeleteDTO favoriteDeleteDTO, String userId);

    Page<ProductSearchDTO> getAllFavoritesByUserId(ProductType productType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authUser, Pageable pageable);

}
