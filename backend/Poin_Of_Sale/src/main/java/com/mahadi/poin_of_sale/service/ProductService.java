package com.mahadi.poin_of_sale.service;

import com.mahadi.poin_of_sale.dto.ClientResponse;
import com.mahadi.poin_of_sale.dto.ProductDTO;
import com.mahadi.poin_of_sale.model.product.Brand;
import com.mahadi.poin_of_sale.model.product.Product;
import com.mahadi.poin_of_sale.model.product.Unit;
import com.mahadi.poin_of_sale.repository.BrandRepository;
import com.mahadi.poin_of_sale.repository.ProductRepository;
import com.mahadi.poin_of_sale.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final UnitRepository unitRepository;
    private final BrandRepository brandRepository;

    public Page<Product> searchProducts(int page, int size, String text) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productRepository.findByNameContaining(text, pageRequest);
    }

    public ClientResponse registerProduct(ProductDTO productDTO) {
        if (productRepository.existsByNameAndBrand_Id(productDTO.name(), productDTO.brand()))
            throw new RuntimeException("Product already exists");

        Unit unit = unitRepository.findById(productDTO.unit()).orElseThrow(() -> new RuntimeException("Product Unit Not Found!"));
        Brand brand = brandRepository.findById(productDTO.brand()).orElseThrow(() -> new RuntimeException("Product Brand Not Found"));
        productRepository.save(Product.builder().name(productDTO.name()).unit(unit).brand(brand).build());
        log.info("Product registered successfully with name: {}", productDTO.name());
        return new ClientResponse(true, "Product registered successfully");
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    public ClientResponse updateProduct(ProductDTO productDTO) {
        if (!productRepository.existsById(productDTO.id()))
            throw new RuntimeException("Product not found");

        Unit unit = unitRepository.findById(productDTO.unit()).orElseThrow(() -> new RuntimeException("Product Unit Not Found!"));
        Brand brand = brandRepository.findById(productDTO.brand()).orElseThrow(() -> new RuntimeException("Product Brand Not Found"));
        productRepository.save(Product.builder().id(productDTO.id()).name(productDTO.name()).unit(unit).brand(brand).build());
        log.info("Product updated successfully with name: {}", productDTO.name());
        return new ClientResponse(true, "Product updated successfully");
    }
}
