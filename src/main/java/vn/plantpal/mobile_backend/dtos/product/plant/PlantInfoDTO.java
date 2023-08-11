package vn.plantpal.mobile_backend.dtos.product.plant;

import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;

import java.sql.Date;

public class PlantInfoDTO extends ProductBaseDTO {
    private String careLevel;
    private Boolean toxicity;
    private Date planted;
    private Integer height;
    private Integer width;
}
