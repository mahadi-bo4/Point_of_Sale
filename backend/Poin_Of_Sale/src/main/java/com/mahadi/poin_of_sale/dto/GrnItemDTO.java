package com.mahadi.poin_of_sale.dto;

import com.mahadi.poin_of_sale.model.product.Product;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GrnItemDTO(
        Product product,
        Integer quantity,
        double buyingPrice,
        double sellingPrice,
        LocalDate manufactureDate,
        LocalDate expireDate
) {
}
