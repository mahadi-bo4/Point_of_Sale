package com.mahadi.poin_of_sale.dto;

import lombok.Builder;

@Builder
public record ClientResponse(boolean success, Object message) {
}
