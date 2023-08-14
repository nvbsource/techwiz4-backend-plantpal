package vn.plantpal.mobile_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteCreateDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteDeleteDTO;
import vn.plantpal.mobile_backend.dtos.favorite.FavoriteResponseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.favorites.FavoriteService;
import vn.plantpal.mobile_backend.utils.ProductType;

@RestController
@RequestMapping("api/favorites")
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<Page<ProductSearchDTO>> getFavoritesList(
            @RequestParam(required = false) ProductType productType,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double priceFrom,
            @RequestParam(required = false) Double priceTo,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "10") int limit ,
            Authentication authentication
    ){
        Pageable pageable = PageRequest.of(offset,limit);
        return ResponseEntity.ok(favoriteService.getAllFavoritesByUserId(productType, keyword, priceFrom, priceTo, sortField, sortOrder, authentication, pageable));
    }

    @PostMapping
    public ResponseEntity<FavoriteResponseDTO> addFavorite(@RequestBody FavoriteCreateDTO favoriteCreateDTO, Authentication authentication){
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();

        return ResponseEntity.ok(favoriteService.create(favoriteCreateDTO, user.getUserID()));
    }

    @DeleteMapping
    public void delete(@RequestBody FavoriteDeleteDTO favoriteDeleteDTO, Authentication authentication){
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        favoriteService.delete(favoriteDeleteDTO, user.getUserID());
    }
}
