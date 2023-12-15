package com.mahadi.poin_of_sale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GRNReport {
    private Integer id;
    private String productName;
    private Integer quantity;
    private String price;
    private String total;
}