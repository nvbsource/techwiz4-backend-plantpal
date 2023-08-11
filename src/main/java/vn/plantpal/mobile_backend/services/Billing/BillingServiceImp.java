package vn.plantpal.mobile_backend.services.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.billing.BillingDetailDTO;
import vn.plantpal.mobile_backend.dtos.checkout.CheckoutDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInCartDTO;
import vn.plantpal.mobile_backend.entities.Billings;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Users;
import vn.plantpal.mobile_backend.exceptions.CartNotExistsProductException;
import vn.plantpal.mobile_backend.exceptions.UserNotFoundException;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.UserRepository;
import vn.plantpal.mobile_backend.utils.BillingStatusType;
import vn.plantpal.mobile_backend.utils.PaymentStatusType;
import vn.plantpal.mobile_backend.utils.Utils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class BillingServiceImp implements BillingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Override
    public BillingDetailDTO checkout(CheckoutDTO data, String userId) {
        Map<String, Map<String, String>> listError = new HashMap<>();


        Users userByBill = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        //Get Object cart of client
        List<ProductInCartDTO> listProductInCart = data.getProductList();

        //Products Id of client send in carts
        List<String> productSizeIds = listProductInCart.stream()
                .map(ProductInCartDTO::getProductSizeId)
                .toList();

        //Find all products in database
        List<ProductSizes> listProductSizesFromDB = productSizeRepository.findByIdIn(productSizeIds);

        //Product id mapping with database
        List<String> productSizesIdsFound = listProductSizesFromDB.stream()
                .map(ProductSizes::getId)
                .toList();

        //Check if client send product not found in database
        if(productSizeIds.size() != productSizesIdsFound.size()) {
            Set<String> clientSendProductIds = new HashSet<>(productSizeIds);
            clientSendProductIds.removeAll(Arrays.asList(productSizesIdsFound));
            List<String> listProductSizeNotFound = new ArrayList<>(clientSendProductIds);
            for (String productSizeIdNotFound : listProductSizeNotFound) {
                listError.put(productSizeIdNotFound, Map.of("NOT_FOUND", "Product not found"));
            }
        }
        //Check if error
        if(!listError.isEmpty()) {
            throw new CartNotExistsProductException("Data not exists", listError);
        }

        for (ProductInCartDTO productSizeInCart : listProductInCart) {
            ProductSizes productSizeFromDB = listProductSizesFromDB.stream()
                    .filter(p -> p.getId().equals(productSizeInCart.getProductSizeId()))
                    .findFirst().orElse(null);
            if(productSizeInCart.getQuantity() <= 0) {
                listError.put(productSizeInCart.getProductSizeId(), Map.of("ZERO_QUANTITY", "Quantity must be greater than or equal to 1"));
                continue;
            }
            if(productSizeFromDB.getStock() == null){
                listError.put(productSizeInCart.getProductSizeId(), Map.of("STOCK_ERROR", "The product has not been created in stock"));
                continue;
            }
            //Check stock
            if(productSizeFromDB != null && productSizeFromDB.getStock().getQuantity() < productSizeInCart.getQuantity()) {
                listError.put(productSizeInCart.getProductSizeId(),  Map.of("EXCEED_QUANTITY", "Not enough quantity to sell"));
            }
        }

        //Check if error
        if(!listError.isEmpty()) {
            throw new CartNotExistsProductException("Error quantity", listError);
        }

        Double totalAmount = 0.0;
        String billCode = Utils.generateCode();
        Billings billingNew = Billings.builder()
                .phone(data.getPhoneNumber())
                .address(data.getAddress())
                .fullName(data.getFullName())
                .orderDate(LocalDateTime.now())
                .totalAmount(totalAmount)
                .user(userByBill)
                .paymentMethod(data.getPaymentMethod())
                .status(BillingStatusType.PENDING.name())
                .paymentStatus(PaymentStatusType.PENDING.name())
                .billCode(billCode)
                .build();
        return null;
    }
}
