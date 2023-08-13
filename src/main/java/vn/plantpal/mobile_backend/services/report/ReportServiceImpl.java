package vn.plantpal.mobile_backend.services.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.report.OrderReportDTO;
import vn.plantpal.mobile_backend.dtos.report.ReportDTO;
import vn.plantpal.mobile_backend.repositories.AccountRepository;
import vn.plantpal.mobile_backend.repositories.OrderItemRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.StockRepository;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static vn.plantpal.mobile_backend.utils.ProductType.ACCESSORIES;
import static vn.plantpal.mobile_backend.utils.ProductType.PLANT;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements  ReportService{
    private final OrderItemRepository orderItemRepository;
    private final AccountRepository accountRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    @Override
    public ReportDTO getReport(){
        //get order report
        OrderReportDTO orderReportDTO = getOrderReport();

        //total account
        Long totalAccount = getTotalAccount();
        //total product
        Long totalProduct = getTotalProduct();
        //total stock
        Long totalStock = getTotalStock();
        return ReportDTO.builder()
                .orders(orderReportDTO)
                .totalAccount(totalAccount)
                .totalProduct(totalProduct)
                .totalStock(totalStock)
                .build();
    }

    public OrderReportDTO getOrderReport(){
        // Calculate the start date (7 days ago)
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusDays(7);
        // Calculate the end date (today)

        List<Long> orderByPlantsCount = orderItemRepository.getOrderByTypeLast7days(startDate, endDate,PLANT.toString());
        List<Long> orderByAccessoriesCount = orderItemRepository.getOrderByTypeLast7days(startDate, endDate,ACCESSORIES.toString());
        return  OrderReportDTO.builder()
                .plants(orderByAccessoriesCount)
                .accessories(orderByPlantsCount)
                .build();
    }

    public Long getTotalAccount(){
        return accountRepository.count();
    }

    public Long getTotalProduct(){
        return productRepository.count();
    }
    public Long getTotalStock(){
        return stockRepository.getTotalStocks();
    }
}
