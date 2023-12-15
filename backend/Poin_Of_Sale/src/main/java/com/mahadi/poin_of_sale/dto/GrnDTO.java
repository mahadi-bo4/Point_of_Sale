package com.mahadi.poin_of_sale.dto;

import com.mahadi.poin_of_sale.model.grn.GrnPayment;
import com.mahadi.poin_of_sale.model.supplier.Supplier;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record GrnDTO(
        @NotNull(message = "Supplier is required")
        Supplier supplier,
        @NotNull(message = "Grn Payment is required")
        GrnPayment grnPayment,
        @NotNull(message = "Grn Items are required")
        List<GrnItemDTO> grnItems
) {
}
