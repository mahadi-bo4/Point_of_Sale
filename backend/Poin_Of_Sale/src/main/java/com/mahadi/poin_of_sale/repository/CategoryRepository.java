package com.mahadi.poin_of_sale.repository;

import com.mahadi.poin_of_sale.model.product.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findByNameContaining(String text, Pageable pageable);

    boolean existsByName(String name);
}
