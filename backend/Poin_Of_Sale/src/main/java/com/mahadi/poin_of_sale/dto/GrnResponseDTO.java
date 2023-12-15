package com.mahadi.poin_of_sale.dto;

import com.mahadi.poin_of_sale.model.grn.GrnItem;
import com.mahadi.poin_of_sale.model.grn.GrnPayment;
import com.mahadi.poin_of_sale.model.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GrnResponseDTO {
    private Long id;
    private LocalDateTime dateTime;

    private Supplier supplier;

    private UserDTO user;

    private GrnPayment grnPayment;

    private List<GrnItem> grnItems;
}
