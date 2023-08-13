package vn.plantpal.mobile_backend.services.favorite;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteCreateDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteDeleteDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteResponseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.entities.Favorites;
import vn.plantpal.mobile_backend.entities.FavoritesPK;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Users;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.FavoriteRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.UserRepository;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService{
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final FavoriteRepository favoriteRepository;

    @Override
    public FavoriteResponseDTO create(FavoriteCreateDTO favoriteCreateDTO){
        String productId = favoriteCreateDTO.getProductId();
        String userId = favoriteCreateDTO.getUserId();
        if(favoriteRepository.existsByUserIdAndProductId(userId,productId)){
            throw new DuplicateRecordException("Favorite Item already exists");
        }

        Products product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","id",productId));
        Users user = userRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        Favorites favorites = Favorites.builder()
                .userId(user.getId())
                .productId(product.getId())
                .createdAt(LocalDateTime.now())
                .build();
        return EntityMapper.mapToDto(favoriteRepository.save(favorites),FavoriteResponseDTO.class);

    }

    @Override
    public void delete(FavoriteDeleteDTO favoriteDeleteDTO){
        FavoritesPK favoritesPK = new FavoritesPK(favoriteDeleteDTO.getId(),favoriteDeleteDTO.getUserId(), favoriteDeleteDTO.getProductId());

        Favorites favorites = favoriteRepository.findById(favoritesPK).orElseThrow(() -> new ResourceNotFoundException("Cannot found favorite item"));

        favoriteRepository.delete(favorites);
    }

    @Override
    public Page<ProductSearchDTO> getAllFavoritesByUserId(ProductType productType, String keyword, Double priceFrom, Double priceTo, String sortField, String sortOrder, Authentication authentication, Pageable pageable) {
        String userId = null;
        String productTypeSTR = null;
        if(productType != null){
            productTypeSTR = productType.toString();
        }
        if(authentication != null){
            AuthUserDTO authUser = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
            userId = authUser.getUserID();
        }
        return favoriteRepository.getFavoritesByUserId(productTypeSTR,keyword, priceFrom, priceTo, sortField,sortOrder,userId,pageable);
    }
}

