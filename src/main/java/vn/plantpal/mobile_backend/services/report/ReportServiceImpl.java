package vn.plantpal.mobile_backend.services.report;

import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.report.OrderReportDTO;
import vn.plantpal.mobile_backend.dtos.report.ReportDTO;
import vn.plantpal.mobile_backend.repositories.AccountRepository;
import vn.plantpal.mobile_backend.repositories.OrderItemRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.StockRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

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
    public ReportDTO getReport(Date startDate, Date endDate){
        //get order report
        OrderReportDTO orderReportDTO = getOrderReport(startDate, endDate);

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

    public OrderReportDTO getOrderReport(Date startDate, Date endDate){
        List<Long> orderByPlantsCount = new ArrayList<>();
        List<Long> orderByAccessoriesCount = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        String localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();

        while (!calendar.after(endDate)) {
              Long countPlants = orderItemRepository.getOrderByTypeAndDate(localStartDate, PLANT.name());
              orderByPlantsCount.add(countPlants);
              Long countAccessories = orderItemRepository.getOrderByTypeAndDate(localStartDate, ACCESSORIES.name());
            orderByAccessoriesCount.add(countAccessories);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
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
