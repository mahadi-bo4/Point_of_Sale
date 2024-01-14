package com.mahadi.poin_of_sale.repository;

import com.mahadi.poin_of_sale.model.product.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Page<Brand> findByNameContaining(String name, PageRequest pageRequest);

    boolean existsByName(String name);
}
