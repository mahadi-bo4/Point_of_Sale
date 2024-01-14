package com.mahadi.poin_of_sale.controller;

import com.mahadi.poin_of_sale.model.product.Product;
import com.mahadi.poin_of_sale.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/test")
@RequiredArgsConstructor
public class TestController {


    private final InvoiceRepository invoiceRepository;

    @GetMapping
    public List<Product> getAll() {
        return invoiceRepository.findTopSellingProducts();
    }

}
