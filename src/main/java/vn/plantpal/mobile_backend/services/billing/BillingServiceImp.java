package vn.plantpal.mobile_backend.services.billing;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.plantpal.mobile_backend.dtos.billing.BillingDetailDTO;
import vn.plantpal.mobile_backend.dtos.billing.OrderItemBaseDTO;
import vn.plantpal.mobile_backend.dtos.cart.CartMappingProductSizeDTO;
import vn.plantpal.mobile_backend.dtos.checkout.CheckoutDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInCartDTO;
import vn.plantpal.mobile_backend.entities.*;
import vn.plantpal.mobile_backend.exceptions.*;
import vn.plantpal.mobile_backend.repositories.*;
import vn.plantpal.mobile_backend.utils.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BillingServiceImp implements BillingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityMapper entityMapper;
    @Autowired
    private CartRepository cartRepository;
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public BillingDetailDTO checkout(CheckoutDTO data, String userId) {
        Map<String, Map<String, String>> listError = new HashMap<>();

        Users userByBill = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        //Get Object cart of client
        List<ProductInCartDTO> listProductInCart = cartRepository.findByUserId(userId).stream().map(c -> new ProductInCartDTO(c.getProductSizeId(), c.getQuantity())).toList();
        if(listProductInCart.size() == 0) {
            throw new ResourceNotFoundException("You have no products in your cart");
        }
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
        if (productSizeIds.size() != productSizesIdsFound.size()) {
            Set<String> clientSendProductIds = new HashSet<>(productSizeIds);
            clientSendProductIds.removeAll(Arrays.asList(productSizesIdsFound));
            List<String> listProductSizeNotFound = new ArrayList<>(clientSendProductIds);
            for (String productSizeIdNotFound : listProductSizeNotFound) {
                listError.put(productSizeIdNotFound, Map.of("NOT_FOUND", "Product not found"));
            }
        }
        //Check if error
        if (!listError.isEmpty()) {
            throw new CartNotExistsProductException("Data not exists", listError);
        }

        List<CartMappingProductSizeDTO> productSizeDTOS = new ArrayList<>();

        for (ProductInCartDTO productSizeInCart : listProductInCart) {
            ProductSizes productSizeFromDB = listProductSizesFromDB.stream()
                    .filter(p -> p.getId().equals(productSizeInCart.getProductSizeId()))
                    .findFirst().orElse(null);
            if (productSizeInCart.getQuantity() <= 0) {
                listError.put(productSizeInCart.getProductSizeId(), Map.of("ZERO_QUANTITY", "Quantity must be greater than or equal to 1"));
                continue;
            }
            if (productSizeFromDB.getStock() == null) {
                listError.put(productSizeInCart.getProductSizeId(), Map.of("STOCK_ERROR", "The product has not been created in stock"));
                continue;
            }
            //Check stock
            if (productSizeFromDB.getStock().getQuantity() < productSizeInCart.getQuantity()) {
                listError.put(productSizeInCart.getProductSizeId(), Map.of("EXCEED_QUANTITY", "Not enough quantity to sell"));
            }
            productSizeDTOS.add(CartMappingProductSizeDTO.builder()
                    .productSizes(productSizeFromDB)
                    .quantity(productSizeInCart.getQuantity())
                    .build());
        }

        //Check if error
        if (!listError.isEmpty()) {
            throw new CartNotExistsProductException("Error quantity", listError);
        }

        Double totalAmount = productSizeDTOS.stream().mapToDouble(p -> p.getProductSizes().getPrice() * p.getQuantity()).sum();

        String billCode = Utils.generateCode();
        BillingStatusType status = data.getPaymentMethod().equals(PaymentMethodType.CASH.name())
                ? BillingStatusType.PROCESSING : BillingStatusType.PENDING;

        Billings billingNew = Billings.builder()
                .phone(data.getPhoneNumber())
                .address(data.getAddress())
                .fullName(data.getFullName())
                .orderDate(LocalDateTime.now())
                .totalAmount(totalAmount)
                .user(userByBill)
                .paymentMethod(data.getPaymentMethod())
                .status(status.name())
                .paymentStatus(PaymentStatusType.PENDING.name())
                .billCode(billCode)
                .build();
        billingRepository.save(billingNew);

        List<OrderItems> orderItems = productSizeDTOS.stream().map(p -> {
            OrderItemsPK pk = OrderItemsPK.builder()
                    .id(UUID.randomUUID().toString())
                    .billId(billingNew.getId())
                    .productSizeId(p.getProductSizes().getId())
                    .build();

            return OrderItems.builder()
                    .id(pk)
                    .billing(billingNew)
                    .productSize(p.getProductSizes())
                    .productType(p.getProductSizes().getType())
                    .quantity(p.getQuantity())
                    .rate(0.0)
                    .amount(p.getProductSizes().getPrice() * p.getQuantity())
                    .build();
        }).toList();

        orderItemRepository.saveAll(orderItems);
        BillingDetailDTO billingResponse =  modelMapper.map(billingNew, BillingDetailDTO.class);
        billingResponse.setOrderItems(entityMapper.mapList(orderItems, OrderItemBaseDTO.class));
//        Check and update stock
        if(status.equals(BillingStatusType.PROCESSING)) {
            productSizeDTOS.forEach(p -> {
                Stocks stock = p.getProductSizes().getStock();
                stock.setQuantity(stock.getQuantity() - p.getQuantity());
                stockRepository.save(stock);
            });
        }
        cartRepository.deleteAllByUserId(userId);
        return billingResponse;
    }

    @Override
    public void callbackPaypal(String orderId, String userId) {

    }

    @Override
    public List<BillingDetailDTO> findBillByUser(String userId) {
        List<Billings> billingsOfUser = billingRepository.findByUserId(userId);
        List<BillingDetailDTO> billingDetailDTO = entityMapper.mapList(billingsOfUser, BillingDetailDTO.class);
        AtomicInteger index = new AtomicInteger(0);
        return billingDetailDTO.stream().map(b -> {
            List<OrderItemBaseDTO> orderItems = b.getOrderItems().stream().toList();
            List<OrderItems> orderItemsFromDB = billingsOfUser.get(index.get()).getOrderItems().stream().toList();
            for(int i = 0; i < orderItems.size(); i++) {
                if(orderItems.get(i).getProduct().getPlant() != null){
                    modelMapper.map(orderItemsFromDB.get(i).getProductSize(), orderItems.get(i).getProduct().getPlant());
                }
                if(orderItems.get(i).getProduct().getAccessory() != null){
                    modelMapper.map(orderItemsFromDB.get(i).getProductSize(), orderItems.get(i).getProduct().getAccessory());
                }
            }
            index.incrementAndGet();
            return b;
        }).toList();
    }
}
